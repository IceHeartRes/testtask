package com.example.testtask.request;

/**
 * Created by resident on 09.07.17.
 */
public class RequestError {
    private boolean result = false;
    private String message;

    public RequestError(String message) {
        this.message = message;
    }
}
