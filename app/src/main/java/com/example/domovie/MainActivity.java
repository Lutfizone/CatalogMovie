package com.example.domovie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.domovie.Util.Movie;
import com.example.domovie.Util.MovieAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private String[] dataTitle, dataOverview, dataGenre, dataRuntime, dataYear;
    private ArrayList<Movie> movies;
    private TypedArray dataPoster;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(MainActivity.this);
        final ListView listView = findViewById(R.id.lvMovie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("EXTRA_MOVIE", movies.get(position));
                startActivity(intent);
            }
        });
    }

    private void addItem() {

        movies= new ArrayList<Movie>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setOverview(dataOverview[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setYear(dataYear[i]);
            movies.add(movie);

            movie.setPoster(dataPoster.getResourceId(i, -1));
        }
        adapter.setMovies(movies);
    }


    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataYear = getResources().getStringArray(R.array.data_year);
    }




}
