package com.example.testtask;

import com.example.testtask.entries.User;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */
public interface DataBaseDao {
    void createDemoTables();

    List<User> getUsers();
}
