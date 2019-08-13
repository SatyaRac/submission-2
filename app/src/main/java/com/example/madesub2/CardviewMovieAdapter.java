package com.example.madesub2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardviewMovieAdapter extends RecyclerView.Adapter<CardviewMovieAdapter.CardViewViewHolder> {
    private ArrayList<Moviedab> listMovie;
    private Context context;

    public CardviewMovieAdapter(Context context) {
        this.context = context;
        listMovie = new ArrayList<>();
    }

    public ArrayList<Moviedab> getListMovie(){
    return listMovie;
}
    public void setListMovie(ArrayList<Moviedab>listMovie){
    this.listMovie = listMovie;
}

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movie, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
       final Moviedab movie = listMovie.get(position);

        holder.posterMov.setImageResource(movie.getPosterMov());
        holder.tvJudulMov.setText(movie.getJudulmov());
        holder.tvRilisMov.setText(movie.getTglrilisMov());
        holder.detailmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mov = new Intent(context, DetailMovieActivity.class);
                mov.putExtra(DetailMovieActivity.KIRIM_MOVIE, movie);
                context.startActivity(mov);
            }
        });


    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

     class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView posterMov;
        TextView tvJudulMov, tvRilisMov, tvDiskripsi;
        Button detailmv;



         CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            posterMov = itemView.findViewById(R.id.iv_poster_mov);
            tvJudulMov = itemView.findViewById(R.id.tv_judul_mov);
            tvRilisMov = itemView.findViewById(R.id.tv_rilis_mov);
            detailmv = itemView.findViewById(R.id.btn_detailmov);
        }
    }
}
