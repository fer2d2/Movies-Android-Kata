package com.xurxodev.moviesandroidkata.view.fragment;

import android.app.Application;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xurxodev.moviesandroidkata.MoviesApp;
import com.xurxodev.moviesandroidkata.R;
import com.xurxodev.moviesandroidkata.data.DiskMovieRepository;
import com.xurxodev.moviesandroidkata.model.Movie;
import com.xurxodev.moviesandroidkata.view.activity.MoviesActivity;
import com.xurxodev.moviesandroidkata.view.adapter.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

public class MoviesFragment extends Fragment {

    @Inject
    DiskMovieRepository movieRepository;
    private MoviesAdapter adapter;
    private RecyclerView recyclerView;
    private View rootView;

    public MoviesFragment(){
        ((MoviesApp) getActivity().getApplication()).getMovieRepositoryComponent().inject((MoviesActivity) getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_movies, container, false);

        List<Movie> movies = loadMovies();

        initializeAdapter(movies);
        initializeRecyclerView();

        return rootView;
    }

    private void initializeAdapter(List<Movie> movies){
        adapter = new MoviesAdapter(movies);
    }

    private List<Movie> loadMovies(){
        movieRepository = new DiskMovieRepository(getActivity().getApplication());

        return movieRepository.getMovies();
    }

    private void initializeRecyclerView() {
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerview_movies);
        recyclerView.setAdapter(adapter);
    }
}
