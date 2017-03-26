package com.bajzat.ubbnews.service;

import android.util.Log;

import com.bajzat.ubbnews.model.FeedItem;
import com.bajzat.ubbnews.model.FeedResponse;
import com.bajzat.ubbnews.repository.FeedRepositoryMemory;
import com.bajzat.ubbnews.util.Observable;
import com.bajzat.ubbnews.util.Observer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bjz on 3/23/2017.
 */
public class FeedService implements Observable {
    private UbbService mUbbService;
    private FeedRepositoryMemory mFeedRepositoryMemory;
    private int currentPage = 1;
    private ArrayList<Observer> mObservers;

    public FeedService(UbbService ubbService) {
        mUbbService = ubbService;
        mFeedRepositoryMemory = new FeedRepositoryMemory();
        mObservers = new ArrayList<>();
        readPage(currentPage);
    }

    public void nextPage() {
        currentPage++;
        readPage(currentPage);
    }

    private void readPage(int page) {
        Call<FeedResponse> call = mUbbService.feedItemList(page);

        call.enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                Log.i("FeedService", "Response!");
                FeedResponse feedResponse = response.body();

                for (FeedItem item : feedResponse.getFeedItemList()) {
                    try {
                        mFeedRepositoryMemory.create(item);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                notifyObservers();
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {
                Log.i("FeedService", "Fail!");
            }
        });
    }

    public List<FeedItem> getList() {
        return (List<FeedItem>) mFeedRepositoryMemory.read();
    }

    public FeedItem getById(String id) {
        return mFeedRepositoryMemory.getById(id);
    }

    @Override
    public void addObserver(Observer obs) {
        mObservers.add(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs : mObservers){
            obs.update(this);
        }
    }
}
