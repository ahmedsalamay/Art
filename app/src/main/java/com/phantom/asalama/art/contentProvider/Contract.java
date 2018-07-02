package com.phantom.asalama.art.contentProvider;

import android.net.Uri;

public class Contract {
    public static final String AUTHORITY="com.phantom.asalama.art.provider";
    public static final String BASE_PATH="arts";
    public static final Uri CONTEN_BASE_URI=Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);

    private Contract(){

    }

    public static class ArtEntry{
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAME= "name";
        public static final String COLUMN_NAME_PUBLISHED_ON = "puplished_on";
        public static final String COLUMN_NAME_FIELDS = "fields";
        public static final String COLUMN_NAME_COVER = "cover";
        public static final String COLUMN_NAME_VIEWS = "views";
        public static final String COLUMN_NAME_APPRECIATIONS = "appreciations";
        public static final String COLUMN_NAME_OWNER_DISPLAYED_NAME  = "display_name";
        public static final String COLUMN_NAME_DESCRIPTION = "Description";
    }
}
