package com.mariiapasichna;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
1) Программно послать HEAD запрос для файла доступного по прямой ссылке, например:
https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java
Скачать сначала первую половину этого файла, а потом докачать вторую.
Range:bytes=0-500
*/

public class Task1 {

    public static final String URL = "https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Text.txt"))) {
            int length = getContentLength(client);
            if (length != 0) {
                writer.write(getResponse(client, "bytes=" + 0 + "-" + length / 2));
                writer.write(getResponse(client, "bytes=" + (length / 2 + 1) + "-" + length));
            } else {
                System.out.println("Content is empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private static String getResponse(OkHttpClient client, String range) throws IOException {
        Request request = new Request.Builder()
                .url(URL)
                .get()
                .addHeader("Range", range)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private static int getContentLength(OkHttpClient client) throws IOException {
        Request request = new Request.Builder()
                .url(URL)
                .head()
                .build();
        Response response = client.newCall(request).execute();
        return Integer.parseInt(response.header("Content-Length"));
    }
}