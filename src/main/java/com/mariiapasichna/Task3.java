package com.mariiapasichna;

/*
3*) Написать класс MyApiService с использованием паттерна синглтон для доступа к API:
(предварительно создать все необходимые модели List, Post, User...)
Пример:
ApiService service = ApiService.getInstance();
List<Post> posts = service.getPosts();
List<User> users = service.getUses();
Для следующих запросов:
Posts https://jsonplaceholder.typicode.com/posts
Comments https://jsonplaceholder.typicode.com/comments
Albums https://jsonplaceholder.typicode.com/albums
Photos https://jsonplaceholder.typicode.com/photos
Users https://jsonplaceholder.typicode.com/users
Todos https://jsonplaceholder.typicode.com/todos
*/

import com.mariiapasichna.myApiService.*;

import java.io.IOException;
import java.util.List;

public class Task3 {

    public static final String POSTS = "https://jsonplaceholder.typicode.com/posts";
    public static final String COMMENTS = "https://jsonplaceholder.typicode.com/comments";
    public static final String ALBUMS = "https://jsonplaceholder.typicode.com/albums";
    public static final String PHOTOS = "https://jsonplaceholder.typicode.com/photos";
    public static final String USERS = "https://jsonplaceholder.typicode.com/users";
    public static final String TODOS = "https://jsonplaceholder.typicode.com/todos";

    public static void main(String[] args) {
        ApiService service = ApiService.getInstance();
        try {
            List<Posts> posts = service.getPosts(POSTS);
            List<Comments> comments = service.getComments(COMMENTS);
            List<Albums> albums = service.getAlbums(ALBUMS);
            List<Photos> photos = service.getPhotos(PHOTOS);
            List<Users> users = service.getUsers(USERS);
            List<Todos> todos = service.getTodos(TODOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}