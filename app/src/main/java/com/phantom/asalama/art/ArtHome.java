package com.phantom.asalama.art;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.phantom.asalama.art.apiServices.ArtServices;
import com.phantom.asalama.art.infastructure.Application;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.models.ProjectPage;
import com.phantom.asalama.art.models.ProjectsPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_home);
        ArtServices mArtServices=((Application)getApplication()).getArtServices();
        Call<ProjectsPage> projectsPageCall=mArtServices.getListProjects(1,"","","","");
        final ProjectsPage[] projectsPage = new ProjectsPage[1];
        projectsPageCall.enqueue(new Callback<ProjectsPage>() {
            @Override
            public void onResponse(Call<ProjectsPage> call, Response<ProjectsPage> response) {
                if(response.isSuccessful()){
                    Log.e("WEB",response.body().toString());
                     projectsPage[0] =response.body();
                }else{
                    Log.e("WEB",response.message());
                }
                Log.e("WEB",response.message());
            }

            @Override
            public void onFailure(Call<ProjectsPage> call, Throwable t) {
                Log.e("WEB",t.getMessage());
            }
        });
        ProjectsPage p=projectsPage[0];


        Call<ProjectPage> projectCall=mArtServices.getProject("4889175");
        final ProjectPage[] po = {new ProjectPage()};
        projectCall.enqueue(new Callback<ProjectPage>() {
            @Override
            public void onResponse(Call<ProjectPage> call, Response<ProjectPage> response) {
                if(response.isSuccessful()){
                    Log.e("WEB",response.body().toString());
                    po[0] =response.body();
                }else{
                    Log.e("WEB",response.message());
                }
                Log.e("WEB",response.message());
            }

            @Override
            public void onFailure(Call<ProjectPage> call, Throwable t) {
                Log.e("WEB",t.getMessage());
            }
        });
        ProjectPage m=po[0];
    }
}
