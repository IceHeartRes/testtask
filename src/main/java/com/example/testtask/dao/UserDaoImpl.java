package com.example.testtask.dao;

import com.example.testtask.dao.interfaces.DemoDataDao;
import com.example.testtask.dao.interfaces.UserDataDao;
import com.example.testtask.entries.User;
import com.example.testtask.tables.MessageTable;
import com.example.testtask.tables.TariffPlaneTable;
import com.example.testtask.tables.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */

@Repository
public class UserDaoImpl implements UserDataDao {
    private UserTable userTable;

    @Autowired
    public UserDaoImpl(UserTable userTable) {
        this.userTable = userTable;
    }

    @Override
    public List<User> getAllUsers() {
        return userTable.readAll();
    }

    @Override
    public User getUserById(int userId) {
        return userTable.readById(userId);
    }

    @Override
    public List<User> getUsersByTp(int tpId) {
        return userTable.readByTp(tpId);
    }


}
