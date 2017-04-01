package com.bajzat.ubbnews.activity;

import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.bajzat.ubbnews.R;
import com.bajzat.ubbnews.fragments.HomeFragment;
import com.bajzat.ubbnews.fragments.ProfileFragment;
import com.bajzat.ubbnews.model.FeedItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeActivity extends AppCompatActivity
        implements HomeFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private BottomBar bottomBar;
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();

        manageToolbars();
    }

    void manageToolbars() {
        toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        bottomBar = (BottomBar) findViewById(R.id.bottom_nav);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                        .beginTransaction();
                if (tabId == R.id.tab_home) {
                    fragmentTransaction.replace(R.id.fragments_container, homeFragment);
                }
                if (tabId == R.id.tab_profile) {
                    fragmentTransaction.replace(R.id.fragments_container, profileFragment);
                }
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFeedChoosed(FeedItem feedItem) {

    }
}
