package com.bajzat.ubbnews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bjz on 3/25/2017.
 */

public class FeedResponse {
    @SerializedName("items")
    @Expose
    private List<FeedItem> mFeedItemList;
    @SerializedName("status")
    @Expose
    private String status;


    public List<FeedItem> getFeedItemList() {
        return mFeedItemList;
    }

    public void setFeedItemList(List<FeedItem> feedItemList) {
        mFeedItemList = feedItemList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FeedResponse(List<FeedItem> feedItemList, String status, String feed) {

        mFeedItemList = feedItemList;
        this.status = status;
    }
}
