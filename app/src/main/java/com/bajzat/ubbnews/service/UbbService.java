package com.bajzat.ubbnews.service;

import com.bajzat.ubbnews.model.FeedItem;
import com.bajzat.ubbnews.model.FeedResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bjz on 3/23/2017.
 */
public interface UbbService {
    @GET("api.json?rss_url=http%3A%2F%2Fwww.cs.ubbcluj.ro%2Ffeed%2F")
    Call<FeedResponse> feedItemList(@Query("paged") int page);
}
