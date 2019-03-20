package com.oliverstudio.simpleroomdemo;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "movies_db";

    private Button mAddButton;

    private MovieDatabase mMovieDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddButton = findViewById(R.id.add_btn);

        mMovieDatabase = Room.databaseBuilder(getApplicationContext(), MovieDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        mMovieDatabase.daoAccess().insertOnlySingleMovie(new Movie("The Prestige"));
                        mMovieDatabase.daoAccess().insertOnlySingleMovie(new Movie("Harry Potter"));
                        Movie movie = mMovieDatabase.daoAccess().fetchOneMovieByMovieId(3);
                        List<Movie> allMovies = mMovieDatabase.daoAccess().fetchAllMoviesByMovieId();

                    }
                }).start();
            }
        });



    }
}