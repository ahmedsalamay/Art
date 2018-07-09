package com.phantom.asalama.art.screens.detail;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.database.DatabaseUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.util.DbUtils;
import com.phantom.asalama.art.R;
import com.phantom.asalama.art.apiServices.ArtServices;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Modules;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.models.ProjectPage;
import com.phantom.asalama.art.utill.DBUtill;
import com.phantom.asalama.art.utill.Utility;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import butterknife.BindDimen;
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
   private Project mProject;
   private ModulesRecyclerViewAdapter mModulesRecyclerViewAdapter;
   private ArtServices mArtServices;
   private LoaderManager loaderManager;
   private final int LOADER_PROJECT_NETWORK=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Picasso picasso=((Application)getApplication()).getPicasso();
         mArtServices=((Application)getApplication()).getArtServices();
        mProject= getIntent().getParcelableExtra(PROJECT_ITEM_KEY);
        loaderManager=getLoaderManager();
        Loader<ProjectPage> loader= loaderManager.getLoader(LOADER_PROJECT_NETWORK);
        if(loader==null){
            loaderManager.initLoader(LOADER_PROJECT_NETWORK,null,this);
        }else {
            loaderManager.restartLoader(LOADER_PROJECT_NETWORK,null,this);
        }

        picasso.load(mProject.getOwners().get(0).getImages().get115()).into(mArtistImg);
        mArtistNameTxt.setText( mProject.getOwners().get(0).getDisplayName());
        mProjectNameTxtH1.setText(mProject.getName());
        mProjectNameTxtH2.setText(mProject.getName());
        mCreativeFieldsTxt.setText(
                Utility.convertArrayToString(mProject.getFields())
                        .replace("__,__"," , "));
        mViewsTxt.setText(mProject.getStats().getViews().toString());
        mApprecaitionTxt.setText(mProject.getStats().getAppreciations().toString());
        mDiscreption.setText(mProject.getDescription());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        mModulesRecView.setLayoutManager(linearLayoutManager);
        mModulesRecView.hasFixedSize();

        mModulesRecyclerViewAdapter=new
                ModulesRecyclerViewAdapter(this,mProject.getModules());
        mModulesRecView.setAdapter(mModulesRecyclerViewAdapter);

        Button BookMark =findViewById(R.id.book_mark);
        BookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DBUtill.isProjectInDatabase(mProject.getId().toString(),Details.this)){
                    //SetRemoveDrawer
                    DBUtill.deleteProjectFromDatabase(mProject.getId().toString(),Details.this);
                }else {
                    //Set Add Drawer
                    DBUtill.addProjectToFavorite(mProject,Details.this);
                }
            }
        });

    }

    @Override
    public Loader<ProjectPage> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<ProjectPage>(this) {
            @Override
            protected void onStartLoading() {
               // super.onStartLoading();
                forceLoad();
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
            //TODO loading indecator
        }
    }

    @Override
    public void onLoaderReset(Loader<ProjectPage> loader) {

    }
}
