package com.phantom.asalama.art.apiServices;


import com.phantom.asalama.art.models.ProjectPage;
import com.phantom.asalama.art.models.ProjectsPage;
import com.phantom.asalama.art.utill.BehanceUrls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ArtServices {
    @GET(BehanceUrls.PROJECTS_URL)
    Call<ProjectsPage> getListProjects(@Query("page")int page
            ,@Query("field")String field
            ,@Query("country")String country
            ,@Query("sort")String sort
            ,@Query("q")String query);

    @GET(BehanceUrls.PROJECT_BY_ID+"{project_id}?api_key="+BehanceUrls.API)
    Call<ProjectPage>getProject(@Path("project_id")String projectId);
}

