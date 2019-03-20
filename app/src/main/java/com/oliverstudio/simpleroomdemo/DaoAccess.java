package com.oliverstudio.simpleroomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleMovie(Movie movie);

    @Insert
    void insertMultipleMovies (List<Movie> movieList);

    @Query("SELECT * FROM Movie WHERE id =:id")
    Movie fetchOneMovieByMovieId(int id);

    @Query("SELECT * FROM Movie")
    List<Movie> fetchAllMoviesByMovieId();

    //TODO finalize update and delete methods
//    @Update
//    void updateMovie (Movie movies);
//
//    @Delete
//    void deleteMovie (Movie movie);
}
