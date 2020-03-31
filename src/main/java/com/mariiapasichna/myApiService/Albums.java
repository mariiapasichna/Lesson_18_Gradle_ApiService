package com.mariiapasichna.myApiService;

public class Albums {
    int userId;
    int id;
    String title;

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}