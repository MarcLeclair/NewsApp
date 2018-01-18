package com.marcl.news;

import com.marcl.news.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcl on 2018-01-14.
 */

public class NewsStore {
    private static List<NewsArticle> newsArticle = new ArrayList<NewsArticle>();

    public static List<NewsArticle> getNewsArticle() {
        return newsArticle;
    }

    public static void setNewsArticle(List<NewsArticle> newsArticle) {
        NewsStore.newsArticle = newsArticle;
    }
}
