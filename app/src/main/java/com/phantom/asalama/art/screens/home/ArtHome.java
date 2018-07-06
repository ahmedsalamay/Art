package com.phantom.asalama.art.screens.home;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.phantom.asalama.art.R;
import com.phantom.asalama.art.apiServices.ArtServices;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.models.ProjectsPage;
import com.phantom.asalama.art.utill.EndlessRecyclerViewScrollListener;
import com.phantom.asalama.art.utill.Utility;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

public class ArtHome extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ProjectsPage> {

    private ArtServices mArtServices;
    private int mPageNumber=1;
    private List<Project>mProjects;
    private ProjectsRecyclerViewAdapter mProjectsRecyclerViewAdapter;
    private static final int PROJECT_NETWORK_LOADER =0 ;
    private static final String PAGE_NUMBER_KEY_BUNDLE  = "page_number_key_bundle";
    private LoaderManager mLoaderManager;
    @BindView(R.id.projects_rec_view) RecyclerView mProjectsRecView;
    private  EndlessRecyclerViewScrollListener mEndlessRecyclerViewScrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_home);
        ButterKnife.bind(this);
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

        RecyclerView.LayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mProjectsRecyclerViewAdapter=new ProjectsRecyclerViewAdapter(this,mProjects);
        mProjectsRecView.setLayoutManager(staggeredGridLayoutManager);
        mProjectsRecView.setAdapter(mProjectsRecyclerViewAdapter);
        mProjectsRecView.addOnScrollListener(new EndlessRecyclerViewScrollListener((StaggeredGridLayoutManager) staggeredGridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if(Utility.isConnectedOrConnecting(getBaseContext())){
                    loadNextDataFromApi(page);
                }
            }
        });

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
            if(mProjects==null)
                mProjects=data.getProjects();
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
}
