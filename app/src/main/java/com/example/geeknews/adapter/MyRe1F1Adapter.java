package com.example.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknews.R;
import com.example.geeknews.bean.Ban;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MyRe1F1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Ban.StoriesBean> list;
    private ArrayList<Ban.TopStoriesBean> list1;

    public MyRe1F1Adapter(Context context, ArrayList<Ban.StoriesBean> list, ArrayList<Ban.TopStoriesBean> list1) {
        this.context = context;
        this.list = list;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View view = View.inflate(context, R.layout.f1_re1_item_layout, null);
            return new ViewHolder1(view);
        } else if (i == 1) {
            View view = View.inflate(context, R.layout.f1_re2_item_layout, null);
            return new ViewHolder2(view);
        } else {
            View view = View.inflate(context, R.layout.f1_re3_item_layout, null);
            return new ViewHolder3(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 0) {
            final ViewHolder1 holder1 = (ViewHolder1) viewHolder;
            holder1.banner.setImages(list1).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Ban.TopStoriesBean path1 = (Ban.TopStoriesBean) path;
                    Glide.with(context).load(path1.getImage()).placeholder(R.mipmap.ic_launcher).into(imageView);
                }
            }).start();
        } else if (getItemViewType(i) == 1) {
            ViewHolder2 holder2 = (ViewHolder2) viewHolder;
            holder2.tv.setText("今日热闻");
        } else {
            ViewHolder3 holder3 = (ViewHolder3) viewHolder;
            int pos = 0;
            if (list1.size() > 0) {
                pos = i - 1;
            } else {
                pos = i;
            }
            holder3.tv1.setText(list.get(pos).getTitle());
            holder3.tv2.setText(list.get(pos).getGa_prefix());
            Glide.with(context).load(list.get(pos).getImages()).placeholder(R.mipmap.ic_launcher).into(holder3.iv);
        }
    }

    @Override
    public int getItemCount() {
        if(list1.size() > 0){
            return list.size() + 1;
        }else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else {
            return 2;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        Banner banner;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.mybanner);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

}
