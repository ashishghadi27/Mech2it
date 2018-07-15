package com.rootdevs.ashish.mech2it;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


public class Feeds extends AppCompatActivity {
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mSwipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(isNetworkAvailable()) {
                    ReadRSS readRss = new ReadRSS(Feeds.this, mRecyclerView);
                    readRss.execute();
                    readRss.count = 1;
                    mSwipeRefresh.setRefreshing(false);
                }
                else
                    Toast.makeText(Feeds.this, "Please Check Your Connection", Toast.LENGTH_SHORT).show();

            }
        });
        if(isNetworkAvailable()){
            ReadRSS readRss = new ReadRSS(Feeds.this, mRecyclerView);
            readRss.execute();
        }
        else
            Toast.makeText(Feeds.this, "Please Check Your Connection", Toast.LENGTH_SHORT).show();
    }



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
