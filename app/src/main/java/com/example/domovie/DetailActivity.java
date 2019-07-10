package com.example.domovie;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domovie.Util.Movie;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitleD;
    TextView tvOverviewD;
    TextView tvGenreD;
    TextView tvRuntimeD;
    TextView tvYearD;
    ImageView ivPosterD;

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitleD = findViewById(R.id.tvTitle);
        tvOverviewD = findViewById(R.id.tvOverview);
        tvGenreD = findViewById(R.id.tvGenre);
        tvRuntimeD = findViewById(R.id.tvRuntime);
        tvYearD = findViewById(R.id.tvYear);
        ivPosterD = findViewById(R.id.ivPoster);

        Movie movie = getIntent().getParcelableExtra("EXTRA_MOVIE");

        tvTitleD.setText(movie.getTitle());
        tvOverviewD.setText(movie.getOverview());
        tvGenreD.setText(movie.getGenre());
        tvRuntimeD.setText(movie.getRuntime());
        tvYearD.setText(movie.getYear());
        ivPosterD.setImageResource(movie.getPoster());


    }
}
