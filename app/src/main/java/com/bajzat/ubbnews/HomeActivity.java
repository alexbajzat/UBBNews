package com.bajzat.ubbnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bajzat.ubbnews.service.FeedService;
import com.bajzat.ubbnews.service.UbbService;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.rss2json.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UbbService ubbService = retrofit.create(UbbService.class);
        FeedService service = new FeedService(ubbService);
    }
}
