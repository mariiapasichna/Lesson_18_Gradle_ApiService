package com.mariiapasichna.myApiService;

public class Posts {
    int userId;
    int id;
    String title;
    String body;

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
