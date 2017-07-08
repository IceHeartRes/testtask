package com.example.testtask.dao.interfaces;

import com.example.testtask.entries.User;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */
public interface UserDataDao {
    List<User> getAllUsers();

    User getUserById(int userId);

    List<User> getUsersByTp(int tpId);
}
