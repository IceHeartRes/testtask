package com.example.testtask.request;

import java.util.List;

/**
 * Created by resident on 09.07.17.
 * данные возвращаемые при успешном выполнении
 */
public class RequestSuccess<T> {
    private boolean status = true;
    private List<T> result;

    public RequestSuccess(List<T> result) {
        this.result = result;
    }
}
