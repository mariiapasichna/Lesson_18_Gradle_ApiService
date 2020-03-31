package com.mariiapasichna.myApiService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ApiService {
    private static ApiService instance;
    private Gson gson = new Gson();

    public static synchronized ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    private ApiService() {
    }

    private Response getResponse(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return client.newCall(request).execute();
    }

    public List<Posts> getPosts(String url) throws IOException {
        Response response = getResponse(url);
        Type listType = new TypeToken<ArrayList<Posts>>() {
        }.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public List<Comments> getComments(String url) throws IOException {
        Response response = getResponse(url);
        Type listType = new TypeToken<ArrayList<Comments>>() {
        }.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public List<Albums> getAlbums(String url) throws IOException {
        Response response = getResponse(url);
        Type listType = new TypeToken<ArrayList<Albums>>() {
        }.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public List<Photos> getPhotos(String url) throws IOException {
        Response response = getResponse(url);
        Type listType = new TypeToken<ArrayList<Photos>>() {
        }.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public List<Users> getUsers(String url) throws IOException {
        Response response = getResponse(url);
        Type listType = new TypeToken<ArrayList<Users>>() {
        }.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public List<Todos> getTodos(String url) throws IOException {
        Response response = getResponse(url);
        Type listType = new TypeToken<ArrayList<Todos>>() {
        }.getType();
        return gson.fromJson(response.body().string(), listType);
    }
}