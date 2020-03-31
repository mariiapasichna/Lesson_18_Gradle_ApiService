package com.mariiapasichna.myApiService;

public class Todos {
    int userId;
    int id;
    String title;
    boolean completed;

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}