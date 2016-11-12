package com.xurxodev.moviesandroidkata;

import com.xurxodev.moviesandroidkata.view.activity.MoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, MovieRepositoryModule.class})
public interface MovieRepositoryComponent {
    void inject(MoviesActivity activity);
}
