package com.peeyoosh.mvvm_sample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import android.util.Log;

import com.peeyoosh.mvvm_sample.models.GreetMessage;
import com.peeyoosh.mvvm_sample.repositories.GreetRespository;

public class GreetViewModel extends ViewModel {
    private static final String TAG = "GreetViewModel";
    private GreetRespository greetRespository;

    /**
     * live data instance must be inside viewmodel class for lifecycle awareness
     * Mediator live data instance must be used to observe source live data
     */
    private MediatorLiveData<GreetMessage> messageMediatorLiveData = new MediatorLiveData<>();

    public GreetViewModel() {
        greetRespository = GreetRespository.getInstance();
        addMediaterDataSource();
    }

    public void doGreetRequest(int time /* seconds */, String message) {
        greetRespository.doGreetRequest(time, message);
    }

    private LiveData<GreetMessage> getMessage() {
        Log.w(TAG, "==== " + TAG + " getMessage");
        return greetRespository.getMessage();
    }

    private void addMediaterDataSource() {
        messageMediatorLiveData.addSource(getMessage(), new Observer<GreetMessage>() {
            @Override
            public void onChanged(@Nullable GreetMessage greetMessage) {
                messageMediatorLiveData.setValue(greetMessage);
            }
        });
    }

    public LiveData<GreetMessage> getGreetMessage() {
        return messageMediatorLiveData;
    }
}
