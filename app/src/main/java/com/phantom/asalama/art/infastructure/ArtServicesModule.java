package com.phantom.asalama.art.infastructure;

import com.fatboyindustrial.gsonjodatime.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phantom.asalama.art.apiServices.ArtServices;
import com.phantom.asalama.art.utill.BehanceUrls;

import org.joda.time.DateTime;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {NetworkModule.class})
public class ArtServicesModule {

    @Provides
    @ArtAppScope
    public ArtServices provideArtService(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BehanceUrls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit.create(ArtServices.class);
    }

    @Provides
    @ArtAppScope
    public Gson provideGson() {
        return new GsonBuilder().
                registerTypeAdapter(DateTime.class, new DateTimeConverter()).create();
    }

}
