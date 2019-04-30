package com.example.geeknews;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.example.geeknews.adapter.MyVpAdapter;
import com.example.geeknews.fragment.Fragment1;
import com.example.geeknews.fragment.Fragment2;
import com.example.geeknews.fragment.Fragment3;
import com.example.geeknews.fragment.Fragment4;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private RelativeLayout mRl;
    private NavigationView mNv;
    private DrawerLayout mDl;
    private Toolbar mToolbar;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private MyVpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        mRl = (RelativeLayout) findViewById(R.id.rl);
        mNv = (NavigationView) findViewById(R.id.nv);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());

        title = new ArrayList<>();
        title.add("日报");
        title.add("主题");
        title.add("专栏");
        title.add("热门");

        adapter = new MyVpAdapter(getSupportFragmentManager(), list, title);
        mVp.setAdapter(adapter);

        mTab.setupWithViewPager(mVp);
    }
}
