package com.fernandofischer.technews;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by fernandofischer on 31/07/17.
 */

public class Article {

    private String title;
    private String thumbnail;
    private String url;
    private Date datetime;
    private String section;
    private String trailText;
    private Bitmap bitmap;

    public Article(String title, String trailText, Date datetime, String thumbnail, String url, String section, Bitmap bitmap) {
        this.title = title;
        this.trailText = trailText;
        this.datetime = datetime;
        this.thumbnail = thumbnail;
        this.url = url;
        this.section = section;
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public Date getDatetime() {
        return datetime;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getSection() {
        return section;
    }

    public String getTrailText() {
        return trailText;
    }
}