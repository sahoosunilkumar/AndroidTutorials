package com.sunilsahoo.databinding.recyclerview.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Lincoln on 15/01/16.
 */
public class Movie {
    private String title, genre, year;
    private Drawable image;

    public Movie() {
    }

    public Movie(String title, String genre, String year, Drawable image) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
