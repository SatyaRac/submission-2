package com.example.madesub2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
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

import static com.bumptech.glide.load.resource.UnitTransformation.get;

public class CardviewTvAdapter extends RecyclerView.Adapter<CardviewTvAdapter.CardViewViewHolder> {
    private ArrayList<Tvshow> listTv;
    private Context context;

    public CardviewTvAdapter(Context context){
        this.context = context;
        listTv = new ArrayList<>();
    }


    public ArrayList<Tvshow> getListTv(){
        return listTv;
    }
    public void setListTv(ArrayList<Tvshow>listTv){
        this.listTv = listTv;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_tv, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Tvshow tvshow = listTv.get(position);

        holder.posterTv.setImageResource(tvshow.getPosterTv());
        holder.tvJudulTv.setText(tvshow.getJudulTv());
        holder.tvRilisTv.setText(tvshow.getTglrilisTv());
        holder.detailTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tv = new Intent (context, DetailTvActivity.class);
                tv.putExtra(DetailTvActivity.KIRIM_TV, tvshow);
                context.startActivity(tv);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListTv().size();
    }

     class CardViewViewHolder extends RecyclerView.ViewHolder {

        ImageView posterTv;
        TextView tvJudulTv,tvRilisTv,tvDeskripsiTv;
        Button detailTv;

         CardViewViewHolder(@NonNull View itemView) {
            super(itemView);


            posterTv = itemView.findViewById(R.id.iv_poster_tv);
            tvJudulTv = itemView.findViewById(R.id.tv_judul_tv);
            tvRilisTv = itemView.findViewById(R.id.tv_rilis_tv);
            detailTv = itemView.findViewById(R.id.btn_detailtv);
        }
    }
}
