package com.phantom.asalama.art.infastructure;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @ArtAppScope
    public OkHttpClient provideHttpClient(HttpLoggingInterceptor interceptor, Cache cache){
        return   new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @ArtAppScope
    public  HttpLoggingInterceptor provideLoggingInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @Provides
    @ArtAppScope
    public Cache provideCache(File file){
        return new Cache(file,10*1000*1000);
    }

    @Provides
    @ArtAppScope
    public File provideFile(Context context){
        return new File(context.getCacheDir(),"okhttp cache");
    }
}
