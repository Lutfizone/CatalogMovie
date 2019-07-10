package com.example.domovie.Util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domovie.R;
import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_movie, viewGroup, false);
        }
        CardViewHolder viewHolder = new CardViewHolder(view);
        Movie movieGetItem = (Movie) getItem(i);
        viewHolder.bind(movieGetItem);
        return view;
    }

    private class CardViewHolder {
        private TextView tvTitle, tvOverview, tvGenre, tvRuntime, tvYear;
        private ImageView ivPoster;

        CardViewHolder (View view) {
            tvTitle = view.findViewById(R.id.tvTitle);
            tvOverview = view.findViewById(R.id.tvOverview);
            tvGenre = view.findViewById(R.id.tvGenre);
            tvRuntime = view.findViewById(R.id.tvRuntime);
            tvYear = view.findViewById(R.id.tvYear);
            ivPoster = view.findViewById(R.id.ivPoster);
        }

        void bind (Movie movieGetItem) {
            tvTitle.setText(movieGetItem.getTitle());
            //tvOverview.setText(movieGetItem.getOverview());
            tvGenre.setText(movieGetItem.getGenre());
            tvRuntime.setText(movieGetItem.getRuntime());
//            tvYear.setText(movieGetItem.getYear());

            ivPoster.setImageResource(movieGetItem.getPoster());
        }

    }
}
