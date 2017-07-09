package com.example.testtask.entries;

import java.util.Date;

/**
 * Created by resident on 08.07.17.
 */
public class Message {
    private int id;
    private int userId;
    private Date date;
    private String message;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
