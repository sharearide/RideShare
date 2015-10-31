package com.example.bunty.sharetheride.Network;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Femion-3 on 17/07/2015.
 */
public class GetData {

    private static final String BASE_URL = "http://allrounderservices.com/mypool/request.php?action=";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        Log.d("paramas is", "" + params);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        Log.d("url is", "" + BASE_URL + relativeUrl);
        return BASE_URL + relativeUrl;

    }
}
