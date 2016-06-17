package com.example.eshen.flixster;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by eshen on 6/15/16.
 */
public class SingleMovieActivity extends AppCompatActivity{
    ImageView ivImage2;
    TextView tvFullSummary;
    TextView tvTitle2;
    String backdropPath;
    String title;
    String summary;
    double rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_movie);

        ivImage2 = (ImageView) findViewById(R.id.ivImage2);
        backdropPath = getIntent().getStringExtra("backdropPath");
        Picasso.with(this).load(backdropPath).fit().centerCrop().transform(new RoundedCornersTransformation(20, 20))
                .placeholder(R.drawable.clapboard)
                .into(ivImage2);

        title = getIntent().getStringExtra("title");
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        if (tvTitle2 != null) {
            tvTitle2.setText(title);
        }

        tvFullSummary = (TextView) findViewById(R.id.tvFullSummary);
        summary = getIntent().getStringExtra("summary");
        tvFullSummary.setText(summary);

        rating = getIntent().getDoubleExtra("rating", 0.0);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        if (ratingBar != null) {
            ratingBar.setRating((float) (rating/2.0));
        }
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(this, R.color.starFullySelected), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(ContextCompat.getColor(this, R.color.starPartiallySelected), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(ContextCompat.getColor(this, R.color.starNotSelected), PorterDuff.Mode.SRC_ATOP);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MoviesActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
