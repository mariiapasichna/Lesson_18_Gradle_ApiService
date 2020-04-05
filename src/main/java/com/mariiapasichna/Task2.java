package com.mariiapasichna;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import okhttp3.*;

import java.io.IOException;

public class Task2 {

    /*
    2) Программно послать POST запрос на https://postman-echo.com/post где в BODY передать foo1=bar1&foo2=bar2
    в формате x-www-form-urlencoded Ответ распарсить и вывести.
    */

    public static final String FORMAT = "application/x-www-form-urlencoded";
    public static final String CONTENT = "foo1=bar1&foo2=bar2";
    public static final String URL = "https://postman-echo.com/post";

    public static void main(String[] args) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse(FORMAT);
            RequestBody body = RequestBody.create(mediaType, CONTENT);
            Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            ResponseBody responseBody = gson.fromJson(response.body().string(), ResponseBody.class);
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ResponseBody {
        Args args;
        String data;
        Files files;
        Form form;
        Headers headers;
        Json json;
        String url;

        @Override
        public String toString() {
            return "{" +
                    "args=" + args +
                    ", data='" + data + '\'' +
                    ", files=" + files +
                    ", form=" + form +
                    ", headers=" + headers +
                    ", json=" + json +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static class Json {
        String foo1;
        String foo2;

        @Override
        public String toString() {
            return "Json{" +
                    "foo1='" + foo1 + '\'' +
                    ", foo2='" + foo2 + '\'' +
                    '}';
        }
    }

    public static class Headers {
        @SerializedName("x-forwarded-proto")
        String xForwardedProto;
        String host;
        @SerializedName("content-length")
        String contentLength;
        @SerializedName("accept-encoding")
        String acceptEncoding;
        @SerializedName("content-type")
        String contentType;
        @SerializedName("user-agent")
        String userAgent;
        @SerializedName("x-forwarded-port")
        String xForwardedPort;

        @Override
        public String toString() {
            return "Headers{" +
                    "xForwardedProto='" + xForwardedProto + '\'' +
                    ", host='" + host + '\'' +
                    ", contentLength='" + contentLength + '\'' +
                    ", acceptEncoding='" + acceptEncoding + '\'' +
                    ", contentType='" + contentType + '\'' +
                    ", userAgent='" + userAgent + '\'' +
                    ", xForwardedPort='" + xForwardedPort + '\'' +
                    '}';
        }
    }

    public static class Form {
        String foo1;
        String foo2;

        @Override
        public String toString() {
            return "Form{" +
                    "foo1='" + foo1 + '\'' +
                    ", foo2='" + foo2 + '\'' +
                    '}';
        }
    }

    public static class Files {
        @Override
        public String toString() {
            return "Files{}";
        }
    }

    public static class Args {
        @Override
        public String toString() {
            return "Args{}";
        }
    }
}