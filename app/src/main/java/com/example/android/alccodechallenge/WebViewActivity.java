package com.example.android.alccodechallenge;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;


public class WebViewActivity extends AppCompatActivity {

    private LinearLayout lyt_progress;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        webView = findViewById(R.id.webView);
        lyt_progress = findViewById(R.id.lyt_progress);

        showLoader();

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //hide loader after page has finished loading
                hideLoader();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        //load andela website
        webView.loadUrl("https://andela.com/alc/");

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private void showLoader() {
        lyt_progress.setVisibility(View.VISIBLE);
        lyt_progress.setAlpha(1.0f);
    }

    private void hideLoader() {
        lyt_progress.setVisibility(View.GONE);
    }
}
