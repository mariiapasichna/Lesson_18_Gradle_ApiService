package com.mariiapasichna.myApiService;

public class Comments {
    int postId;
    int id;
    String name;
    String email;
    String body;

    @Override
    public String toString() {
        return "{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}