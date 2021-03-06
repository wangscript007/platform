package cn.elvea.platform.commons.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * HttpUtils
 * 基于OkHTTP封装网络请求相关的方法
 *
 * @author elvea
 */
public abstract class HttpUtils {

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static Response execute(Request request) throws IOException {
        return okHttpClient.newCall(request).execute();
    }

    public static void enqueue(Request request, Callback responseCallback) {
        okHttpClient.newCall(request).enqueue(responseCallback);
    }

    public static void enqueue(Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public static String getStringResult(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String respString = response.body().string();
            return respString;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

}
