package com.phantom.asalama.art.screens.detail;

import android.app.LoaderManager;
import android.appwidget.AppWidgetManager;
import android.content.AsyncTaskLoader;
import android.content.ComponentName;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.gson.Gson;
import com.phantom.asalama.art.ArtWidgetProvider;
import com.phantom.asalama.art.R;
import com.phantom.asalama.art.apiServices.ArtServices;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.models.ProjectPage;
import com.phantom.asalama.art.utill.DBUtill;
import com.phantom.asalama.art.utill.Utility;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

public class Details extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ProjectPage> {

    public static final String PROJECT_ITEM_KEY = "project_key";

   @BindView(R.id.artist_img) ImageView mArtistImg;
   @BindView(R.id.artist_name_txt) TextView mArtistNameTxt;
   @BindView(R.id.project_name_text_h2) TextView mProjectNameTxtH2;
   @BindView(R.id.creative_fields_txt) TextView mCreativeFieldsTxt;
   @BindView(R.id.views_txt) TextView mViewsTxt;
   @BindView(R.id.likes_txt) TextView mApprecaitionTxt;
   @BindView(R.id.project_name_txt_h1) TextView mProjectNameTxtH1;
   @BindView(R.id.project_description_txt) TextView mDiscreption;
   @BindView(R.id.modules_rec_view) RecyclerView mModulesRecView;
   @BindView(R.id.toolbar)Toolbar mToolbar;
   @BindView(R.id.cardView)
    CardView mDescriptionContainerCard;
   @BindView(R.id.spin_kit)SpinKitView mLoadingIndicator;
   private Project mProject;
   private ModulesRecyclerViewAdapter mModulesRecyclerViewAdapter;
   private ArtServices mArtServices;
    private Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Slide slide= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            slide = new Slide(Gravity.BOTTOM);
            slide.addTarget(R.id.artist_name_txt)
                    .addTarget(R.id.project_name_text_h2)
                    .addTarget(R.id.project_name_txt_h1)
                    .addTarget(R.id.modules_rec_view)
                    .addTarget(R.id.artist_img)
                    .setInterpolator(AnimationUtils.
                            loadInterpolator(this,
                                    android.R.interpolator.linear_out_slow_in));
            slide.setDuration(300);
            getWindow().setEnterTransition(slide);

        }

        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         mPicasso=((Application)getApplication()).getPicasso();
         mArtServices=((Application)getApplication()).getArtServices();
        mProject= getIntent().getParcelableExtra(PROJECT_ITEM_KEY);
        LoaderManager loaderManager = getLoaderManager();
        int LOADER_PROJECT_NETWORK = 0;
        Loader<ProjectPage> loader= loaderManager.getLoader(LOADER_PROJECT_NETWORK);
        if(loader==null){
            loaderManager.initLoader(LOADER_PROJECT_NETWORK,null,this);
        }else {
            loaderManager.restartLoader(LOADER_PROJECT_NETWORK,null,this);
        }
        mProjectNameTxtH1.setText(mProject.getName());
        mProjectNameTxtH2.setText(mProject.getName());
        mCreativeFieldsTxt.setText(
                Utility.convertArrayToString(mProject.getFields())
                        .replace("__,__"," , "));
        mViewsTxt.setText(mProject.getStats().getViews().toString());
        mApprecaitionTxt.setText(mProject.getStats().getAppreciations().toString());
        if(mProject.getDescription()==null||mProject.getDescription().isEmpty()){
            mDescriptionContainerCard.setVisibility(View.INVISIBLE);
        }else{
            mDiscreption.setText(mProject.getDescription());

        }

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        mModulesRecView.setLayoutManager(linearLayoutManager);
        mModulesRecView.hasFixedSize();

        mModulesRecyclerViewAdapter=new
                ModulesRecyclerViewAdapter(this,mProject.getModules());
        mModulesRecView.setAdapter(mModulesRecyclerViewAdapter);

        final ImageButton BookMark =findViewById(R.id.book_mark);
        BookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DBUtill.isProjectInDatabase(mProject.getId().toString(),Details.this)){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        BookMark.setImageDrawable(getDrawable(R.drawable.bookmark));
                    }else {
                        BookMark.setImageResource(R.drawable.bookmark);
                    }
                    DBUtill.deleteProjectFromDatabase(mProject.getId().toString(),Details.this);
                }else {
                    //Set Add Drawer
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        BookMark.setImageDrawable(getDrawable(R.drawable.bookmark_on));
                    }else {
                        BookMark.setImageResource(R.drawable.bookmark_on);
                    }
                    DBUtill.addProjectToFavorite(mProject,Details.this);
                    SetCurrentArtWidget();
                }
            }
        });
        if(DBUtill.isProjectInDatabase(mProject.getId().toString(),Details.this)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                BookMark.setImageDrawable(getDrawable(R.drawable.bookmark_on));
            }else {
                BookMark.setImageResource(R.drawable.bookmark_on);
            }
        }else {
            //Set Add Drawer
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                BookMark.setImageDrawable(getDrawable(R.drawable.bookmark));
            }else {
                BookMark.setImageResource(R.drawable.bookmark);
            }
        }

    }

     private void SetCurrentArtWidget(){
        Gson gson=new Gson();
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String projectJson=gson.toJson(mProject);
        editor.putString("ART_WIDGET_KEY",projectJson);
        editor.apply();
        AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(this);
        int[]appWidgetIds=appWidgetManager.getAppWidgetIds(new ComponentName(this, ArtWidgetProvider.class));
        ArtWidgetProvider.updateArtWidget(this,appWidgetManager,appWidgetIds,mProject);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds,R.id.cover_img_widget);
    }

    @Override
    public Loader<ProjectPage> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<ProjectPage>(this) {
            @Override
            protected void onStartLoading() {
               // super.onStartLoading();
                forceLoad();
                mLoadingIndicator.setVisibility(View.VISIBLE);
                //TODO Loading indicator
            }

            @Override
            public ProjectPage loadInBackground() {
                if(Utility.isConnectedOrConnecting(getContext())){
                    Call<ProjectPage>projectPageCall=mArtServices.getProject(mProject.getId().toString());
                    try {
                      Response<ProjectPage> projectPageResponse= projectPageCall.execute();
                      if(projectPageResponse.isSuccessful()){
                          return projectPageResponse.body();
                      }
                      else{
                            Log.e("Response Msg", projectPageResponse.message());
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
    public void onLoadFinished(Loader<ProjectPage> loader, ProjectPage data) {
        if(data!=null){
            mProject=data.getProject();
            mModulesRecyclerViewAdapter.setNewData(mProject.getModules());
            mModulesRecyclerViewAdapter.notifyDataSetChanged();

            mArtistNameTxt.setText( mProject.getOwners().get(0).getDisplayName());
            mPicasso.load(mProject.getOwners().get(0).getImages().get115())
                    .placeholder(R.drawable.placeholder)
                    .centerInside()
                    .resize(100,100)
                    .error(R.drawable.placeholder)
                    .into(mArtistImg);
            mLoadingIndicator.setVisibility(View.GONE);
            //TODO loading indecator
        }
    }

    @Override
    public void onLoaderReset(Loader<ProjectPage> loader) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
