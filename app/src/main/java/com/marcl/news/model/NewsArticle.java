package com.marcl.news.model;

/**
 * Created by marcl on 2018-01-14.
 */

public class NewsArticle {
    private String title;
    private String details;
    private String imgUrl;
    private String time;
    private String articleUrl;

    public NewsArticle(String title, String details, String imgUrl, String time, String articleUrl) {
        this.title = title;
        this.details = details;
        this.imgUrl = imgUrl;
        this.time = time;
        this.articleUrl = articleUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
}
