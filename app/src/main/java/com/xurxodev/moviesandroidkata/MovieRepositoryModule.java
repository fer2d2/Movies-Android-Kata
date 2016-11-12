package com.xurxodev.moviesandroidkata;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieRepositoryModule {

    @Provides
    @Singleton
    Context provideApplicationContext(Application application){
        return application.getApplicationContext();
    }

}
