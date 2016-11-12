package com.xurxodev.moviesandroidkata;

import android.app.Application;


public class MoviesApp extends Application {
    private MovieRepositoryComponent movieRepositoryComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        this.movieRepositoryComponent = DaggerMovieRepositoryComponent.builder()
                .appModule(new AppModule(this))
                .movieRepositoryModule(new MovieRepositoryModule())
                .build();
    }

    public MovieRepositoryComponent getMovieRepositoryComponent() {
        return movieRepositoryComponent;
    }
}
