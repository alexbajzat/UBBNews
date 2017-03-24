package com.bajzat.ubbnews.service;

import android.util.Log;

import com.bajzat.ubbnews.model.FeedItem;
import com.bajzat.ubbnews.repository.FeedRepositoryMemory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bjz on 3/23/2017.
 */
public class FeedService {
    private UbbService mUbbService;
    private FeedRepositoryMemory mFeedRepositoryMemory;

    public FeedService(UbbService ubbService) {
        mUbbService = ubbService;
        Call<List<FeedItem>> call = mUbbService.feedItemList();
        call.enqueue(new Callback<List<FeedItem>>() {
            @Override
            public void onResponse(Call<List<FeedItem>> call, Response<List<FeedItem>> response) {
                Log.d("ON RESPONSE", "DONE ");
            }

            @Override
            public void onFailure(Call<List<FeedItem>> call, Throwable t) {
                Log.d("ON FAILURE", "ON FAILURE!!! ");
            }
        });
    }

}
