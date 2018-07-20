package com.phantom.asalama.art.infastructure;

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

        ArtAppComponent artAppComponent= DaggerArtAppComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        mArtServices=artAppComponent.provideArtService();
        mPicasso=artAppComponent.providePicasso();

    }

    public ArtServices getArtServices() {
        return mArtServices;
    }

    public Picasso getPicasso() {
        return mPicasso;
    }
}
