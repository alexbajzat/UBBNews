package com.bajzat.ubbnews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.bajzat.ubbnews.R;
import com.bajzat.ubbnews.adapter.FeedListAdapter;
import com.bajzat.ubbnews.model.FeedItem;
import com.bajzat.ubbnews.service.FeedService;
import com.bajzat.ubbnews.service.UbbService;

import java.util.ArrayList;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView feedListView;
    private FeedListAdapter mFeedListAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Retrofit retrofit;
    private FeedService mFeedService;
    private UbbService ubbService;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initService();
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);


        feedListView = (RecyclerView) findViewById(R.id.feed_list);
        mLayoutManager = new LinearLayoutManager(this);
        feedListView.setLayoutManager(mLayoutManager);

        mFeedListAdapter = new FeedListAdapter((ArrayList<FeedItem>) mFeedService.getList());
        mFeedService.addObserver(mFeedListAdapter);

        feedListView.setAdapter(mFeedListAdapter);
    }

    private void initService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.rss2json.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ubbService = retrofit.create(UbbService.class);
        mFeedService = new FeedService(ubbService);
    }
}
