package com.example.testtask.request;

/**
 * Created by resident on 09.07.17.
 * данные возвращаемые при ошибке
 */
public class RequestError {
    private boolean status = false;
    private String message;

    public RequestError(String message) {
        this.message = message;
    }
}
