package com.phantom.asalama.art.infastructure;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context mContext;

    public  ContextModule(Context context) {
        mContext=context;
    }

    @Provides
    public Context provideContext(){
        return mContext;
    }
}
