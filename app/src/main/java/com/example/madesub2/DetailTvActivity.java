package com.example.madesub2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailTvActivity extends AppCompatActivity {
    public static final  String KIRIM_TV = "kirim_tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        Tvshow tvshow = getIntent().getParcelableExtra(KIRIM_TV);

        String titleTv = tvshow.getJudulTv() ;
        String releaseTv = tvshow.getTglrilisTv();
        String deskripsTv = tvshow.getDeskrisiTv();
        String creatorTv = tvshow.getCreatorTv();

        ImageView imgTv = findViewById(R.id.iv_img__tv);
        Glide.with(this)
                .load(tvshow.getPosterTv())
                .into(imgTv);

        TextView judulTv = findViewById(R.id.tv_titletv);
        judulTv.setText(titleTv);

        TextView rilisTV = findViewById(R.id.tv_releasetv);
        rilisTV.setText(releaseTv);

        TextView diskripTV = findViewById(R.id.tv_deskripsitv);
        diskripTV.setText(deskripsTv);

        TextView creator = findViewById(R.id.tv_creator);
        creator.setText(creatorTv);

    }
}
