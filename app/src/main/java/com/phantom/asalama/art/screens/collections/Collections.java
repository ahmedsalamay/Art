package com.phantom.asalama.art.screens.collections;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.android.gms.ads.MobileAds;
import com.phantom.asalama.art.R;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.screens.home.ProjectsRecyclerViewAdapter;
import com.phantom.asalama.art.utill.DBUtill;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Collections extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Project>>{

    private ProjectsRecyclerViewAdapter mProjectsRecyclerViewAdapter;

     @BindView(R.id.projects_rec_view)
     RecyclerView mProjectsRecView;
    private List<Project> mProjects;
    private LoaderManager mLoaderManager;
    private static final int PROJECT_DATABASE_LOADER_  = 597;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_art_home);
        ButterKnife.bind(this);

        MobileAds.initialize(this,"ca-app-pub-8336404465569985~5584210818");

        RecyclerView.LayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mProjectsRecyclerViewAdapter = new ProjectsRecyclerViewAdapter(this, mProjects);
        mProjectsRecView.setLayoutManager(staggeredGridLayoutManager);
        mProjectsRecView.setAdapter(mProjectsRecyclerViewAdapter);

        mLoaderManager=getLoaderManager();
        Loader<List<Project>>projectsLoader=mLoaderManager.getLoader(PROJECT_DATABASE_LOADER_);
        if(projectsLoader==null){
            mLoaderManager.initLoader(PROJECT_DATABASE_LOADER_,null,this);
        }else {
            mLoaderManager.restartLoader(PROJECT_DATABASE_LOADER_,null,this);
        }

    }

    @Override
    public Loader<List<Project>> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<List<Project>>(this) {
            @Override
            protected void onStartLoading() {
                //super.onStartLoading();
                forceLoad();
                //TODO Loading
            }

            @Override
            public List<Project> loadInBackground() {

                return DBUtill.getProjects(Collections.this);
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<List<Project>> loader, List<Project> data) {
        if (data != null) {
                mProjects = data;
            mProjectsRecyclerViewAdapter.setNewData(mProjects);
            mProjectsRecyclerViewAdapter.notifyDataSetChanged();
            //TODO loading indicator
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Project>> loader) {

    }
}
