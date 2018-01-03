package com.husenansari.boxoffice.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.husenansari.boxoffice.R;
import com.husenansari.boxoffice.api.model.results;
import com.husenansari.boxoffice.helper.AppConstant;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gulamhusen on 10-04-2017.
 */

public class PopularAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<results> results;
    private Context context;


    public PopularAdapter(Context context, ArrayList<results> resultList) {
        this.results = resultList;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item_popular, parent, false);
        return new PopularViewHoldar(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PopularViewHoldar popularViewHoldar = (PopularViewHoldar) holder;
        popularViewHoldar.setValues(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setMoviePopularlist(ArrayList<results> dataList) {
        this.results = new ArrayList<>();
        this.results = dataList;
        notifyDataSetChanged();
    }

    private class PopularViewHoldar extends RecyclerView.ViewHolder {

        private TextView txtName, txtRating;
        private ImageView imgPoster;

        public PopularViewHoldar(View view) {
            super(view);

            txtName = (TextView) view.findViewById(R.id.popMovie_Title);
            txtRating = (TextView) view.findViewById(R.id.popMovie_Rating);
            imgPoster = (ImageView) view.findViewById(R.id.popMovie_Poster);
        }

        public void setValues(results results) {
            txtName.setText(results.getOriginal_title());
            txtRating.setText(String.valueOf(results.getVote_average()));
            Glide.with(context).load(AppConstant.BASE_IMAGE_URL+""+results.getPoster_path().trim()).centerCrop().placeholder(R.drawable.video).into(imgPoster);
            Log.e("path",results.getPoster_path());
        }
    }
}
