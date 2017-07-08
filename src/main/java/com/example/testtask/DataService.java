package com.example.testtask;

import com.example.testtask.entries.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */

@Component
public class DataService {

    private final DataBaseDao dataBaseDao;

    @Autowired
    public DataService(DataBaseDao dataBaseDao) {
        this.dataBaseDao = dataBaseDao;
    }

    public void createDemoTables() throws Exception{
        dataBaseDao.createDemoTables();
    }

    public List<User> getAllUsers(){
        return dataBaseDao.getUsers();
    }
}
