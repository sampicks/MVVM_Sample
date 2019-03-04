package com.peeyoosh.mvvm_sample.models;

public class GreetMessage {

    private final int MAXTIME = 15;
    private final int MINTIME = 2;

    private int timeDuration; // in seconds
    private String message;

    public int getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(int timeDuration) {
        if (timeDuration >= MINTIME && timeDuration <= MAXTIME)
            this.timeDuration = timeDuration;
        else {
            timeDuration = MAXTIME;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
