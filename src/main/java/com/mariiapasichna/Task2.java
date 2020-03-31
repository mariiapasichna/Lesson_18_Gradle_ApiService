package com.mariiapasichna;

import okhttp3.*;

import java.io.IOException;

public class Task2 {

    /*
    2) Программно послать POST запрос на https://postman-echo.com/post где в BODY передать foo1=bar1&foo2=bar2
    в формате x-www-form-urlencoded Ответ распарсить и вывести.
    */

    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "foo1=bar1&foo2=bar2");
            Request request = new Request.Builder()
                    .url("https://postman-echo.com/post")
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}