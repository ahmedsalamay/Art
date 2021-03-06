package com.phantom.asalama.art.screens.collections;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.github.ybq.android.spinkit.SpinKitView;
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
     @BindView(R.id.spin_kit)SpinKitView mLoadingIndicator;
    private List<Project> mProjects;
    private static final int PROJECT_DATABASE_LOADER_  = 597;
    private int[] mScrollPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_art_collections);
        ButterKnife.bind(this);

        MobileAds.initialize(this,"ca-app-pub-8336404465569985~5584210818");

        RecyclerView.LayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mProjectsRecyclerViewAdapter = new ProjectsRecyclerViewAdapter(this, mProjects);
        mProjectsRecView.setLayoutManager(staggeredGridLayoutManager);
        mProjectsRecView.setAdapter(mProjectsRecyclerViewAdapter);

        LoaderManager mLoaderManager = getLoaderManager();
        Loader<List<Project>>projectsLoader= mLoaderManager.getLoader(PROJECT_DATABASE_LOADER_);
        if(projectsLoader==null){
            mLoaderManager.initLoader(PROJECT_DATABASE_LOADER_,null,this);
        }else {
            mLoaderManager.restartLoader(PROJECT_DATABASE_LOADER_,null,this);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mScrollPosition= ((StaggeredGridLayoutManager) mProjectsRecView.getLayoutManager())
                .findFirstVisibleItemPositions(mScrollPosition);
        outState.putIntArray(getString(R.string.first_visible_item_postion),mScrollPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mScrollPosition=savedInstanceState.getIntArray(getString(R.string.first_visible_item_postion));
        mProjectsRecView.getLayoutManager().scrollToPosition(mScrollPosition[0]);
    }

    @Override
    public Loader<List<Project>> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<List<Project>>(this) {
            @Override
            protected void onStartLoading() {
                //super.onStartLoading();
                forceLoad();
                mLoadingIndicator.setVisibility(View.VISIBLE);
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
            mLoadingIndicator.setVisibility(View.GONE);
        }
        if(mScrollPosition!=null&&mScrollPosition[0]!= RecyclerView.NO_POSITION )
        {
            mProjectsRecView.getLayoutManager().scrollToPosition(mScrollPosition[0]);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Project>> loader) {

    }
}
