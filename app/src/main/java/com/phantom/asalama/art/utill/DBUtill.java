package com.phantom.asalama.art.utill;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.google.gson.Gson;
import com.phantom.asalama.art.contentProvider.Contract;
import com.phantom.asalama.art.models.Covers;
import com.phantom.asalama.art.models.Owner;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.models.ProjectStats;
import com.phantom.asalama.art.models.Stats_;

import java.util.ArrayList;
import java.util.List;

import static com.phantom.asalama.art.contentProvider.Contract.ArtEntry.*;

public final class DBUtill {

    public static ArrayList<Project>getProjects(Context context){
        ArrayList<Project>projects=new ArrayList<>();
        Cursor cursor=context.getContentResolver()
                .query(Contract.CONTEN_BASE_URI
                        ,null,null,
                        null,null);
        if (cursor.moveToFirst()) {
            do {
                Project project = new Project();
                project.setId((Integer.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_ID)))));
                project.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NAME)));

                Owner owner=new Owner();
                List<Owner> owners=new ArrayList<>();
                owner.setDisplayName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_OWNER_DISPLAYED_NAME)));
                owners.add(owner);
                project.setOwners(owners);

                Stats_ stats_=new Stats_();
                stats_.setAppreciations(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_APPRECIATIONS)));
                stats_.setViews(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_VIEWS)));
                project.setStats(stats_);

                Covers covers=new Covers();
                covers.setOriginal(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_COVER)));
                project.setCovers(covers);

                project.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_DESCRIPTION)));
                project.setPublishedOn(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_PUBLISHED_ON)));

                List<String>fields;
                fields=Utility.convertStringToArray(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_FIELDS)));
                project.setFields(fields);

                projects.add(project);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return projects;

    }

    public static Uri addProjectToFavorite(Project project,Context context) {
        ContentValues values = new ContentValues();
        values.put(Contract.ArtEntry.COLUMN_NAME_ID, project.getId());
        values.put(COLUMN_NAME_NAME, project.getName());
        values.put(COLUMN_NAME_COVER, project.getCovers().getOriginal());
        values.put(COLUMN_NAME_VIEWS, project.getStats().getViews());
        values.put(COLUMN_NAME_APPRECIATIONS, project.getStats().getAppreciations());
        values.put(COLUMN_NAME_FIELDS, Utility.convertArrayToString(project.getFields()));
        values.put(COLUMN_NAME_DESCRIPTION, project.getDescription());
        values.put(COLUMN_NAME_OWNER_DISPLAYED_NAME, project.getOwners().get(0).getDisplayName());
        values.put(COLUMN_NAME_PUBLISHED_ON, project.getPublishedOn());
        return context.getContentResolver().insert(Contract.CONTEN_BASE_URI, values);
    }


    public static Project getProjectFromDatabase(String ID,Context context) {
        Project project = null;
        Uri contentUri = Contract.CONTEN_BASE_URI;
        String selectionClause = null;
        String[] selectionArgs = {""};
        selectionClause = Contract.ArtEntry.COLUMN_NAME_ID + " = ?";

        selectionArgs[0] = ID;
        Cursor cursor = context.getContentResolver().query(contentUri, null, selectionClause, selectionArgs, null);
        cursor.moveToFirst();
        if (null == cursor) {

        } else if (cursor.getCount() < 1) {

        } else {
            project = new Project();
            project.setId((Integer.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_ID)))));
            project.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NAME)));

            Owner owner=new Owner();
            List<Owner> owners=new ArrayList<>();
            owner.setDisplayName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_OWNER_DISPLAYED_NAME)));
            owners.add(owner);
            project.setOwners(owners);

            Stats_ stats_=new Stats_();
            stats_.setAppreciations(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_APPRECIATIONS)));
            stats_.setViews(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_VIEWS)));
            project.setStats(stats_);

            Covers covers=new Covers();
            covers.setOriginal(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_COVER)));
            project.setCovers(covers);

            project.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_DESCRIPTION)));
            project.setPublishedOn(cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_PUBLISHED_ON)));

            List<String>fields;
            fields=Utility.convertStringToArray(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_FIELDS)));
            project.setFields(fields);

        }
        cursor.close();
        return project;
    }


    public static boolean isProjectInDatabase(String id,Context context) {

        Project project = getProjectFromDatabase(id,context);
        if (project == null)
            return false;
        return true;
    }

    public static int deleteProjectFromDatabase(String ID,Context context) {

        Uri contentUri = Contract.CONTEN_BASE_URI;
        String selectionClause = null;
        String[] selectionArgs = {""};
        selectionClause = COLUMN_NAME_ID + " = ?";

        selectionArgs[0] = ID;
        return context.getContentResolver().delete(contentUri, selectionClause, selectionArgs);
    }
}
