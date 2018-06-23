package com.phantom.asalama.art.infastructure;

import android.graphics.Movie;

import com.phantom.asalama.art.apiServices.ArtServices;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class Application extends android.app.Application {

    private ArtServices mArtServices;
    private Picasso mPicasso;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

    }

    public ArtServices getArtServices() {
        return mArtServices;
    }

    public Picasso getPicasso() {
        return mPicasso;
    }
}
