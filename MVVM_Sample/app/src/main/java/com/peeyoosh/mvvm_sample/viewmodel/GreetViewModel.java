package com.peeyoosh.mvvm_sample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.peeyoosh.mvvm_sample.models.GreetMessage;
import com.peeyoosh.mvvm_sample.repositories.GreetRespository;

public class GreetViewModel extends ViewModel {
    private static final String TAG = "GreetViewModel";
    private GreetRespository greetRespository;

    public GreetViewModel() {
        greetRespository = GreetRespository.getInstance();
    }

    public LiveData<GreetMessage> getMessage() {
        Log.w(TAG, "==== " + TAG + " getMessage");
        return greetRespository.getMessage();
    }

    public void doGreetRequest(int time /* seconds */, String message) {
        greetRespository.doGreetRequest(time, message);
    }
}
