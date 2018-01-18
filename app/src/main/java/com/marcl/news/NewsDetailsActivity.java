package com.marcl.news;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NewsDetailsActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "news_index";
    private WebView webview;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         webview = (WebView) findViewById(R.id.activity_news_details_webview);
         progressBar = (ProgressBar) findViewById(R.id.activity_news_details_progressbar);

         int index = getIntent().getIntExtra(KEY_INDEX, -1);
         if(index != -1){
             UpdateNewsDetails(index);
         }else{
             Toast.makeText(NewsDetailsActivity.this, "Sorry, incorrect index", Toast.LENGTH_SHORT);
         }

    }

    public void UpdateNewsDetails(int index){
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(NewsDetailsActivity.this, "Error in loading webpage ", Toast.LENGTH_SHORT).show();
            }
        });
        webview.loadUrl(NewsStore.getNewsArticle().get(index).getArticleUrl());
        getSupportActionBar().setTitle(NewsStore.getNewsArticle().get(index).getTitle());

    }

    public static void launch(Context context, int index ){
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(KEY_INDEX, index);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
