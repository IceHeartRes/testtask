package com.example.testtask.request;

import java.util.List;

/**
 * Created by resident on 09.07.17.
 */
public class RequestSuccess<T> {
    private List<T> result;

    public RequestSuccess(List<T> result) {

        this.result = result;
    }
}
