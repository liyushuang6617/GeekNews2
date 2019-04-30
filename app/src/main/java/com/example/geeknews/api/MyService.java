package com.example.geeknews.api;

import com.example.geeknews.bean.Ban;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {

    public String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<Ban> get();
}
