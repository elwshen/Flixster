package com.example.eshen.flixster;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by eshen on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie>{
    private Context s_context;

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
        s_context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);
        TextView tvRating = (TextView) convertView.findViewById(R.id.tvRating);
        ivImage.setImageResource(0);

        // Populate the data into the template view using the data object
        tvTitle.setText(movie.getOriginalTitle());
        tvSummary.setText(movie.getOverview());
        tvRating.setText(Double.toString(movie.getRating()));

        Log.d("MoviesAdapter", "Position: " + position);
        if (s_context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        }
        else {
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImage);
        }

        // Return the completed view to render on screen
        return convertView;

    }
}
