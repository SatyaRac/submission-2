package com.example.madesub2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MovieFragment extends Fragment {
    RecyclerView rvMovie;
    ArrayList<Moviedab> list;
    String[] judulmov;
    String[] tglrilisMov;
    String[] deskripsi;
    String[] director;
    private TypedArray imgMov;
    CardviewMovieAdapter adapter;




    public MovieFragment() {

    }

    public static Fragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.menu_movie);
        rvMovie.setHasFixedSize(true);

        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CardviewMovieAdapter(getActivity());
        adapter.setListMovie(list);
        rvMovie.setAdapter(adapter);
        prepare();
        addItem();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


    }

    private void addItem(){
        list = new ArrayList<>();

        for (int i = 0; i < judulmov.length; i++){
            Moviedab movie = new Moviedab();
            movie.setJudulmov(judulmov[i]);
            movie.setTglrilisMov(tglrilisMov[i]);
            movie.setDeskripsi(deskripsi[i]);
            movie.setDierctorMov(director[i]);
            movie.setPosterMov(imgMov.getResourceId(i,-1));

            list.add(movie);
        }
        adapter.setListMovie(list);
    }

    private void prepare(){
        imgMov = getResources().obtainTypedArray(R.array.img_mov);
        judulmov = getResources().getStringArray(R.array.titlemov);
        tglrilisMov = getResources().getStringArray(R.array.release_datemov);
        director = getResources().getStringArray(R.array.directormov);
        deskripsi = getResources().getStringArray(R.array.description_move);


    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.lt_movie:
                Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
                intent.putExtra("KIRIM_MOVIE",list );
                startActivity(intent);

        }

    }


}
