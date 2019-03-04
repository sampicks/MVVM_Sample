package com.peeyoosh.mvvm_sample.requests;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.peeyoosh.mvvm_sample.models.GreetMessage;

import java.util.Timer;
import java.util.TimerTask;

public class RequestApiClient {
    private static final String TAG = "RequestApiClient";

    private static RequestApiClient requestApiClient;

    private MutableLiveData<GreetMessage> messageMutableLiveData;

    private RequestApiClient() {
        messageMutableLiveData = new MutableLiveData<>();
    }

    public static RequestApiClient getInstance() {
        if (requestApiClient == null)
            requestApiClient = new RequestApiClient();
        return requestApiClient;
    }

    public LiveData<GreetMessage> getMessage() {
        Log.d(TAG,"==== "+TAG+" getMessage");
        return messageMutableLiveData;
    }

    public void doGreetRequest(int time /* seconds */, String message) {
        final GreetMessage greetMessage = new GreetMessage();
        greetMessage.setTimeDuration(time);
        greetMessage.setMessage(message);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                messageMutableLiveData.postValue(greetMessage);
            }
        }, greetMessage.getTimeDuration() * 1000);
    }
}
