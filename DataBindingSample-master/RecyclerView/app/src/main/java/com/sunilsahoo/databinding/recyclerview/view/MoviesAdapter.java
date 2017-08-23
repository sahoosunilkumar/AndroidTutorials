package com.sunilsahoo.databinding.recyclerview.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.sunilsahoo.databinding.recyclerview.R;
import com.sunilsahoo.databinding.recyclerview.databinding.MovieListRowBinding;
import com.sunilsahoo.databinding.recyclerview.model.Movie;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;
    MovieListRowBinding movieListRowBinding;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        MovieListRowBinding movieListRowBinding;

        public MyViewHolder(MovieListRowBinding movieListRowBinding) {
            super(movieListRowBinding.getRoot());
            this.movieListRowBinding=movieListRowBinding;
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        movieListRowBinding = MovieListRowBinding.bind(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false));

        return new MyViewHolder(movieListRowBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        movieListRowBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
