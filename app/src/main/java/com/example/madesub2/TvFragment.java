package com.example.madesub2;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TvFragment extends Fragment {
    RecyclerView rvTv;
    ArrayList<Tvshow> list;
    String[] judulTv;
    String[] tglrilisTv;
    String[] deskripsiTv;
    String[] creatorTv;
    private TypedArray imgTv;
    CardviewTvAdapter adapter;


    public TvFragment() {
        // Required empty public constructor
    }
    public static Fragment newInstance(){
        return new TvFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        rvTv = view.findViewById(R.id.menu_tv);
        rvTv.setHasFixedSize(true);

        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CardviewTvAdapter(getActivity());
        adapter.setListTv(list);
        rvTv.setAdapter(adapter);
        prepare();
        addItem();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


    }


    private void addItem() {
        list = new ArrayList<>();

        for (int i = 0; i < judulTv.length; i++){
            Tvshow tvshow = new Tvshow();
            tvshow.setJudulTv(judulTv[i]);
            tvshow.setTglrilisTv(tglrilisTv[i]);
            tvshow.setDeskrisiTv(deskripsiTv[i]);
            tvshow.setCreatorTv(creatorTv[i]);
            tvshow.setPosterTv(imgTv.getResourceId(i,-1));

            list.add(tvshow);
        }
        adapter.setListTv(list);
    }

    private void prepare(){
        imgTv = getResources().obtainTypedArray(R.array.img_tv);
        judulTv = getResources().getStringArray(R.array.titletv);
        tglrilisTv = getResources().getStringArray(R.array.release_datetv);
        creatorTv = getResources().getStringArray(R.array.creatortv);
        deskripsiTv = getResources().getStringArray(R.array.description_tv);

    }


}
