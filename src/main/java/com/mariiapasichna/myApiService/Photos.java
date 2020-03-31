package com.mariiapasichna.myApiService;

public class Photos {
    int albumId;
    int id;
    String title;
    String url;
    String thumbnailUrl;

    @Override
    public String toString() {
        return "{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}