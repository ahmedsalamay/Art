package com.phantom.asalama.art.screens.home;

import android.Manifest;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.phantom.asalama.art.R;
import com.phantom.asalama.art.apiServices.ArtServices;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.models.ProjectsPage;
import com.phantom.asalama.art.screens.collections.Collections;
import com.phantom.asalama.art.screens.settings.SettingsActivity;
import com.phantom.asalama.art.utill.EndlessRecyclerViewScrollListener;
import com.phantom.asalama.art.utill.Utility;

import org.joda.time.Days;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

public class ArtHome extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ProjectsPage>, SharedPreferences.OnSharedPreferenceChangeListener {

    private static final int LAST_KNOWN_LOCATION_REQUEST = 0;
    private static final int REQUEST_CHECK_SETTINGS = 1;
    private ArtServices mArtServices;
    private int mPageNumber = 1;
    private String mField;
    private String mCountry;
    private String mSortBy;
    private boolean isMycountryEnabled;
    private List<Project> mProjects;
    private ProjectsRecyclerViewAdapter mProjectsRecyclerViewAdapter;
    private static final int PROJECT_NETWORK_LOADER = 0;
    private static final String PAGE_NUMBER_KEY_BUNDLE = "page_number_key_bundle";
    private LoaderManager mLoaderManager;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private GoogleApiClient mGoogleApiClient;
    private SharedPreferences mSharedPreferences;
    private DrawerLayout mDrawerLayout;
    @BindView(R.id.projects_rec_view)
    RecyclerView mProjectsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_home);
        ButterKnife.bind(this);
        setUpSharedPrefernces();
        mArtServices = ((Application) getApplication()).getArtServices();
        mLoaderManager = getLoaderManager();
        mSharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        Loader<ProjectsPage> projectsPageLoader = mLoaderManager
                .getLoader(PROJECT_NETWORK_LOADER);

        Bundle pageNumberBundle = new Bundle();
        pageNumberBundle.putInt(PAGE_NUMBER_KEY_BUNDLE, 1);

        if (projectsPageLoader == null) {
            mLoaderManager.initLoader(PROJECT_NETWORK_LOADER, pageNumberBundle, this);
        } else {
            mLoaderManager.restartLoader(PROJECT_NETWORK_LOADER, pageNumberBundle, this);
        }

        RecyclerView.LayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mProjectsRecyclerViewAdapter = new ProjectsRecyclerViewAdapter(this, mProjects);
        mProjectsRecView.setLayoutManager(staggeredGridLayoutManager);
        mProjectsRecView.setAdapter(mProjectsRecyclerViewAdapter);
        mProjectsRecView.addOnScrollListener(new EndlessRecyclerViewScrollListener((StaggeredGridLayoutManager) staggeredGridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (Utility.isConnectedOrConnecting(getBaseContext())) {
                    loadNextDataFromApi(page);
                }
            }
        });

        mDrawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                if(item.getItemId()==R.id.collections){
                    Intent intent=new Intent(ArtHome.this,Collections.class);
                    startActivity(intent);
                }
                return true;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
            mGoogleApiClient=new GoogleApiClient.Builder(this)
                    .addApi(LocationServices.API).build();
            mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        createLocationRequest();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void setUpSharedPrefernces() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mField = sharedPreferences.getString(getString(R.string.field_list), "");
        isMycountryEnabled = sharedPreferences.getBoolean(getString(R.string.country_switch), false);
        mSortBy = sharedPreferences.getString(getString(R.string.sort_list), "");
        mCountry=sharedPreferences.getString(getString(R.string.country_code),"");
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void loadNextDataFromApi(int page) {
        Bundle pageNumber = new Bundle();
        pageNumber.putInt(PAGE_NUMBER_KEY_BUNDLE, page);
        mLoaderManager.restartLoader(PROJECT_NETWORK_LOADER, pageNumber, this);
    }

    @NonNull
    @Override
    public Loader<ProjectsPage> onCreateLoader(int id, @Nullable Bundle args) {

        mPageNumber = args.getInt(PAGE_NUMBER_KEY_BUNDLE);

        return new AsyncTaskLoader<ProjectsPage>(this) {

            @Override
            protected void onStartLoading() {
                //super.onStartLoading();
                forceLoad();
                //TODO loading indicator
            }

            @Nullable
            @Override
            public ProjectsPage loadInBackground() {
                String country;
                //this nulls and if conditions to make the url pure e.g
                // instead of abc.com/q=EmptyString--> it will be abc.com/
                //Recommend for me better solution please :D
                //also separate country and mCountry as i want to preserve the mCountry object
                //however i want to pass the mCountry =country or  mCountry =null depend on the settings
                //so i declare a holder(country) for mCountry
                if(isMycountryEnabled) {
                    country=mCountry;
                } else {
                    country=null;
                }
                if(mField.isEmpty()){
                    mField=null;
                }
                if(mSortBy.isEmpty()||mSortBy.equals("-1")){//"-1" means the there is no selection for sort
                    mSortBy=null;
                }

                Call<ProjectsPage> projectsPageCall = mArtServices.getListProjects(mPageNumber, mField, country,
                        mSortBy, null);
                if (Utility.isConnectedOrConnecting(getContext())) {
                    try {
                        Response<ProjectsPage> projectsPageResponse = projectsPageCall.execute();
                        if (projectsPageResponse.isSuccessful()) {
                            return projectsPageResponse.body();
                        } else {
                            Log.e("Response Msg", projectsPageResponse.message());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ProjectsPage> loader, ProjectsPage data) {
        if (data != null) {
            if (mProjects == null)
                mProjects = data.getProjects();
            else
                mProjects.addAll(data.getProjects());

            mProjectsRecyclerViewAdapter.setNewData(mProjects);
            mProjectsRecyclerViewAdapter.notifyDataSetChanged();
            //TODO loading indicator
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ProjectsPage> loader) {

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        mField = sharedPreferences.getString(getString(R.string.field_list), "");
        isMycountryEnabled = sharedPreferences.getBoolean(getString(R.string.country_switch), false);
        mSortBy = sharedPreferences.getString(getString(R.string.sort_list), "");
        mProjects = null;
        Bundle pageNumber = new Bundle();
        pageNumber.putInt(PAGE_NUMBER_KEY_BUNDLE, 1);
        if(key.equals(getString(R.string.country_switch))&&(mCountry==null||mCountry.isEmpty())){
            createLocationRequest();
        }
        mLoaderManager.restartLoader(PROJECT_NETWORK_LOADER, pageNumber, this);
    }

    private void getCountryIfNeeded() {
        if (isMycountryEnabled) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                final Context conntext=this;
                mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Geocoder geocoder = new Geocoder(conntext, Locale.getDefault());
                        try {
                            if(location!=null){

                                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLatitude(), 1);
                                mCountry = addresses.get(0).getCountryCode();
                                SharedPreferences.Editor editor= mSharedPreferences.edit();
                                editor.putString(getString(R.string.country_code),mCountry);
                                editor.apply();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                } else {
                    // No explanation needed; request the permission
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, LAST_KNOWN_LOCATION_REQUEST);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case  LAST_KNOWN_LOCATION_REQUEST:{
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do
                    final Context conntext=this;
                    mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            Geocoder geocoder = new Geocoder(conntext, Locale.getDefault());
                            try {
                                if(location!=null){
                                    List  <Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLatitude(), 1);
                                    mCountry = addresses.get(0).getCountryCode();
                                    SharedPreferences.Editor editor= mSharedPreferences.edit();
                                    editor.putString(getString(R.string.country_code),mCountry);
                                    editor.apply();
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }
    protected  void createLocationRequest(){
        LocationRequest locationRequest=new LocationRequest();
        locationRequest.setInterval(5184000)
                .setFastestInterval(5184000)
                .setPriority(LocationRequest.PRIORITY_LOW_POWER);
        LocationSettingsRequest.Builder builder=new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        SettingsClient settingsClient=LocationServices.getSettingsClient(this);
        com.google.android.gms.tasks.Task<LocationSettingsResponse> task= settingsClient.checkLocationSettings(builder.build());
        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                getCountryIfNeeded();
            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    try {
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(ArtHome.this,
                                REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            getCountryIfNeeded();
        }else{

        }
    }
}
