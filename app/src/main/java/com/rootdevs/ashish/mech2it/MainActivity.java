package com.rootdevs.ashish.mech2it;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private WebView web;
    private ProgressBar progress;
    static String weblink;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String link = "";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webview);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe);
        SharedPreferences sharedPreferences = getSharedPreferences("unique", MODE_PRIVATE);
        link = sharedPreferences.getString("code", "");
        weblink = "https://"+link+".m2i.cloud/app/";
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setSupportZoom(true);       //Zoom Control on web
        web.getSettings().setBuiltInZoomControls(true); //Enable Multitouch if supported by ROM
        web.getSettings().setAllowFileAccess(true);
        web.addJavascriptInterface(new MyJavaScriptInterface(), "android");
        web.getSettings().setGeolocationEnabled(true);
        web.getSettings().setAllowUniversalAccessFromFileURLs(true);
        web.getSettings().setDisplayZoomControls(false);
        web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        web.getSettings().setMediaPlaybackRequiresUserGesture(false);
        web.setWebViewClient(new WebViewClientDemo());
        web.setWebChromeClient(new WebChromeClientDemo());

        web.getSettings().setAllowUniversalAccessFromFileURLs(true);
        web.getSettings().setAllowContentAccess(true);
        web.getSettings().setDatabaseEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(web, true);
        CookieManager.getInstance().acceptThirdPartyCookies(web);
        CookieManager.getInstance().acceptCookie();
        progress = findViewById(R.id.progress);
        if (isConnect()){
            web.loadUrl(weblink);
        }

        else
            Toast.makeText(this, "Please Check your Connection",Toast.LENGTH_SHORT).show();


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                web.loadUrl(web.getUrl());
                swipeRefreshLayout.setRefreshing(false);
            }
        });



    }




    @Override

    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        web = findViewById(R.id.webview);

        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();

            return true;
        }



        else
            return super.onKeyDown(keyCode, event);
    }





    private boolean isConnect() {
        ConnectivityManager c = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert c != null;
        NetworkInfo activeNetwork = c.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();

    }


    public class WebViewClientDemo extends WebViewClient {

        ProgressBar progress = findViewById(R.id.progress);




        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progress.setProgress(0);
            view.loadUrl("javascript:window.android.onUrlChange(window.location.href);");
            //Address.setText(web.getTitle());
            progress.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#d3d3d3")));
            progress.setVisibility(View.GONE);
            swipeRefreshLayout.setRefreshing(false);



        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progress.setVisibility(View.VISIBLE);
            progress.setProgress(0);
            progress.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#1565c0")));


        }




    }

    private class WebChromeClientDemo extends WebChromeClient {
        public void onProgressChanged(WebView view, int prog) {

            ObjectAnimator animation = ObjectAnimator.ofInt(progress, "progress",prog);
            animation.setDuration(500); // 0.5 second
            animation.setInterpolator(new DecelerateInterpolator());
            animation.start();

            progress.setProgress(prog);

        }



    }


    class MyJavaScriptInterface {
        @JavascriptInterface
        public void onUrlChange(String url) {
            Log.d("hydrated", "onUrlChange" + url);
        }
    }



}
