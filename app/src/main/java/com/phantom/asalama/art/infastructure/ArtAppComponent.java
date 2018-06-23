package com.phantom.asalama.art.infastructure;

import com.phantom.asalama.art.apiServices.ArtServices;
import com.squareup.picasso.Picasso;

import dagger.Component;

@ArtAppScope
@Component(modules = {ArtServicesModule.class,PicassoModule.class})
public interface ArtAppComponent {

    Picasso providePicasso();
    ArtServices provideArtService();
}
