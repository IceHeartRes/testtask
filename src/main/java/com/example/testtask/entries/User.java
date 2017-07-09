package com.example.testtask.entries;

import java.util.List;

/**
 * Created by resident on 08.07.17.
 */
public class User {
    private int id;
    private String name;
    private int tpId;
    private List<Message> messages;
    private TariffPlane tariffPlane;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTpId(int tpId) {
        this.tpId = tpId;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setTariffPlane(TariffPlane tariffPlane) {
        this.tariffPlane = tariffPlane;
    }
}
