package com.homework.week02;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpClient {
    public static CloseableHttpClient httpclient = HttpClients.createDefault();


    public static void main(String[] args) {
        String url = "http://localhost:8801";
        String getStr = get(url);
        System.out.println("get result:"+getStr);
        String postStr = post(url);
        System.out.println(postStr);
    }

    public static String get(String url) {

        HttpGet request = new HttpGet(url);
        String result = null;
        result = getResponseString(request);
        return result;
    }

    public static String post(String url) {

        HttpPost request = new HttpPost(url);
        String result = null;
        result = getResponseString(request);
        return result;
    }

    private static String getResponseString(HttpRequestBase request) {

        String result = null;
        StringBuilder resultBuffer = new StringBuilder();
        CloseableHttpResponse response = null;
        try {

            response = httpclient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                throw new RuntimeException("Http invoke failed, status code: " + statusCode+"errorMsg:"+jsonString);
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                String inputLine = null;
                while ((inputLine = in.readLine()) != null) {
                    resultBuffer.append(inputLine);
                    resultBuffer.append("\n");
                }
                in.close();
                result = resultBuffer.toString();
            }
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        } finally {
            if (null!=response) {
                IOUtils.closeQuietly(response);
            }
        }
        return result;
    }
}
