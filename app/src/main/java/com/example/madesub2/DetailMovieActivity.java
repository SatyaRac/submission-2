package com.example.madesub2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {

public static final  String KIRIM_MOVIE = "kirim_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);



        Moviedab moviedab = getIntent().getParcelableExtra(KIRIM_MOVIE);

        String titleMov = moviedab.getJudulmov() ;
        String releaseMov = moviedab.getTglrilisMov();
        String deskripsiMov = moviedab.getDeskripsi();
        String directorMov = moviedab.getDierctorMov();

        ImageView imgMov = findViewById(R.id.iv_img__mov);

        Glide.with(this)
                .load(moviedab.getPosterMov())
                .into(imgMov);

        TextView judul = findViewById(R.id.tv_title_mov);
        judul.setText(titleMov);

        TextView rilis = findViewById(R.id.tv_releasemov);
        rilis.setText(releaseMov);

        TextView diskrip = findViewById(R.id.tv_deskripsimov);
        diskrip.setText(deskripsiMov);

        TextView direct = findViewById(R.id.tv_director);
        direct.setText(directorMov);


    }
}


