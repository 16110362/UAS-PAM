package com.example.amikom.simplenewsapps.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikko Eka Saputra on 12/03/2018.
 */

public class News {

    @SerializedName("urlToImage")
    String imgNews;
    @SerializedName("title")
    String titleNews;
    @SerializedName("publishedAt")
    String dateNews;
    @SerializedName("author")
    String authorNews;
    @SerializedName("description")
    String contentNews;
    @SerializedName("url")
    String sourceNews;

    public News(String imgNews, String titleNews, String dateNews, String authorNews, String contentNews, String sourceNews) {
        this.imgNews = imgNews;
        this.titleNews = titleNews;
        this.dateNews = dateNews;
        this.authorNews = authorNews;
        this.contentNews = contentNews;
        this.sourceNews = sourceNews;
    }

    public String getImgNews() {
        return imgNews;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public String getDateNews() {
        return dateNews;
    }

    public String getAuthorNews() {
        return authorNews;
    }

    public String getContentNews() {
        return contentNews;
    }

    public String getSourceNews() {
        return sourceNews;
    }
}
