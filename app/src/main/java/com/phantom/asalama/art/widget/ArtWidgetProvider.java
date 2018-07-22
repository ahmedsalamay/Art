package com.phantom.asalama.art.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RemoteViews;

import com.google.gson.Gson;
import com.phantom.asalama.art.R;
import com.phantom.asalama.art.models.Project;
import com.phantom.asalama.art.screens.home.ArtHome;
import com.phantom.asalama.art.utill.Utility;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.net.MalformedURLException;
import java.net.URL;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Implementation of App Widget functionality.
 */
public class ArtWidgetProvider extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId,Project project) {

        // Construct the RemoteViews object
        int[]appWidgetIds=appWidgetManager.getAppWidgetIds(new ComponentName
                (context, ArtWidgetProvider.class));
        final RemoteViews views = new RemoteViews(context.getPackageName(),
                R.layout.art_widget_provider);

        Intent intent=new Intent(context, ArtHome.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.cover_img_widget,pendingIntent);

        if(project==null||project.getName().isEmpty()){
            views.setViewVisibility(R.id.empty_state_widget,VISIBLE);
            views.setViewVisibility(R.id.widget_container,GONE);
        }
        if(project!=null&&!project.getName().isEmpty()){

            views.setViewVisibility(R.id.empty_state_widget,GONE);
            views.setViewVisibility(R.id.widget_container,VISIBLE);
            Picasso picasso=new Picasso.Builder(context).build();
            picasso.load(project.getCovers().get230())
                    .into(views,R.id.cover_img_widget,appWidgetIds);
           /* Picasso.get().load(project.getCovers().get404()).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    views.setImageViewBitmap(R.id.cover_img_widget, bitmap);

                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                    Log.e("Picasso","Picasso Failed Load Image "+e.getMessage());
                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {
                    Log.e("Picasso","Picasso onPrepareLoad  ");
                }

            });*/


            views.setTextViewText(R.id.project_name_text_h2,project.getName());
            views.setTextViewText(R.id.creative_fields_txt, Utility.convertArrayToString(project.getFields())
                    .replace("__,__"," , "));
            views   .setTextViewText(R.id.views_txt,project.getStats().getViews().toString());
            views.setTextViewText(R.id.likes_txt,project.getStats().getAppreciations().toString());

        }// Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public static void updateArtWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds, Project project){
        for (int widgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, widgetId, project);
        }

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Project project=new Project();
        Gson gson= new Gson();
        String projecJson;
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);

        if(preferences.contains("ART_WIDGET_KEY")){
            projecJson= preferences.getString("ART_WIDGET_KEY","");
            project=gson.fromJson(projecJson,Project.class);
        }

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, project);
        }

    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

