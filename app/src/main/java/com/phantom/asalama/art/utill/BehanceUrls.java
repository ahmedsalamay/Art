package com.phantom.asalama.art.utill;

import android.content.res.Configuration;

import com.phantom.asalama.art.BuildConfig;

public class BehanceUrls {
    public static final String API=BuildConfig.BehanceApiKey;
    public static final String BASE_URL="http://www.behance.net";
    public static final String PROJECTS_URL="/v2/projects?api_key="+ API;
    public static final String PROJECT_BY_ID="/v2/projects/";
}
