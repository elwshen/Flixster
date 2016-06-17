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

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


/**
 * Created by eshen on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie>{
    private Context s_context;

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
        s_context = context;
    }

    private static class ViewHolder {
        TextView tvTitle;
        ImageView ivImage;
        TextView tvSummary;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Movie movie = getItem(position);

        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.ivImage.setImageResource(0);
        viewHolder.tvTitle.setText(movie.getOriginalTitle());

        Log.d("MoviesAdapter", "Position: " + position);
        String imageURI;
        String typ;
        int width;
        int height;
        if (s_context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            imageURI = movie.getPosterPath();
            width = 500;
            height = 800;
            typ = "port";
        }
        else {
            imageURI = movie.getBackdropPath();
            width = 1000;
            height = 800;
            typ = "land";
        }
        Picasso.with(getContext()).load(imageURI).resize(width,height)
                .placeholder(R.drawable.clapboard)
                .transform(new RoundedCornersTransformation(20, 20))
                .into(viewHolder.ivImage);
        viewHolder.tvSummary.setText(movie.getOverview(typ));
        // Return the completed view to render on screen
        return convertView;

    }
}
