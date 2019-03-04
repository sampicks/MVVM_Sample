package com.peeyoosh.mvvm_sample.repositories;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.peeyoosh.mvvm_sample.models.GreetMessage;
import com.peeyoosh.mvvm_sample.requests.RequestApiClient;

public class GreetRespository {
    private static final String TAG = "GreetRespository";

    private static GreetRespository instance;
    private RequestApiClient apiClient;

    public static GreetRespository getInstance() {
        if (instance == null) {
            instance = new GreetRespository();
        }
        return instance;
    }

    private GreetRespository() {
        apiClient = RequestApiClient.getInstance();
    }

    public void doGreetRequest(int time /* seconds */, String message) {
        apiClient.doGreetRequest(time, message);
    }

    public LiveData<GreetMessage> getMessage() {
        Log.i(TAG,"==== "+TAG+" getMessage");
        return apiClient.getMessage();
    }
}
