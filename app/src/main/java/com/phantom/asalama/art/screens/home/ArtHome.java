package com.phantom.asalama.art.screens.home;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.phantom.asalama.art.R;
import com.phantom.asalama.art.apiServices.ArtServices;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.models.ProjectsPage;
import com.phantom.asalama.art.utill.Utility;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ArtHome extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ProjectsPage> {

    private ArtServices mArtServices;
    private int mPageNumber=1;
    private List<Project>mProjects;
    private static final int PROJECT_NETWORK_LOADER =0 ;
    private static final String PAGE_NUMBER_KEY_BUNDLE  = "page_number_key_bundle";
    private LoaderManager mLoaderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_home);

        mArtServices=((Application)getApplication()).getArtServices();

        mLoaderManager = getLoaderManager();
        Loader<ProjectsPage>projectsPageLoader=mLoaderManager
                .getLoader(PROJECT_NETWORK_LOADER);

        Bundle pageNumberBundle=new Bundle();
        pageNumberBundle.putInt(PAGE_NUMBER_KEY_BUNDLE,1);

        if(projectsPageLoader==null){
            mLoaderManager.initLoader(PROJECT_NETWORK_LOADER,pageNumberBundle,this);
        }else {
            mLoaderManager.restartLoader(PROJECT_NETWORK_LOADER,pageNumberBundle,this);
        }
    }

    @NonNull
    @Override
    public Loader<ProjectsPage> onCreateLoader(int id, @Nullable Bundle args) {

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

                Call<ProjectsPage> projectsPageCall=mArtServices.getListProjects(mPageNumber,"","","","");
                if (Utility.isConnectedOrConnecting(getContext())){
                    try {
                       Response<ProjectsPage> projectsPageResponse =projectsPageCall.execute();
                        if(projectsPageResponse.isSuccessful()){
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
        if(data!=null) {
            mProjects = data.getProjects();
            //TODO swap data
            //TODO notify dataSetChanged
            //TODO loading indicator
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ProjectsPage> loader) {

    }
}
