package com.oliverstudio.simpleroomdemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Movie {
    @NonNull
    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo (name = "movie_name")
    private String movieName;

    public Movie() {
    }

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}