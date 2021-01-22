package com.homework.week02;

import okhttp3.*;

import java.io.IOException;

public class OkHttp {
    public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8801";
        String getResult = doGet(url);
        System.out.println("get result:" + getResult);
        String postResult = doPost(url, "{}");
        System.out.println("post  result:" + postResult);
    }


    private static String doGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private static String doPost(String url, String content) throws IOException {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), content);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
