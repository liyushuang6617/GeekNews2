package com.example.geeknews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknews.R;
import com.example.geeknews.adapter.MyRe1F1Adapter;
import com.example.geeknews.bean.Ban;
import com.example.geeknews.model.MyModelImple;
import com.example.geeknews.prenster.MyPrenster;
import com.example.geeknews.prenster.MyPrensterImple;
import com.example.geeknews.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements MyView {


    private static final String TAG = Fragment1.class.getName();
    private View view;
    private RecyclerView mRe;
    private ArrayList<Ban.StoriesBean> list;
    private MyRe1F1Adapter adapter;
    private ArrayList<Ban.TopStoriesBean> list1;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        MyPrenster prenster = new MyPrensterImple(new MyModelImple(),this);
        prenster.getData();
    }

    private void initView(View view) {
        mRe = (RecyclerView) view.findViewById(R.id.re);

        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        list1 = new ArrayList<>();

        adapter = new MyRe1F1Adapter(getActivity(), list,list1);
        mRe.setAdapter(adapter);
    }

    @Override
    public void onSuccess(Ban ban) {
        list.addAll(ban.getStories());
        list1.addAll(ban.getTop_stories());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " +msg );
    }
}
