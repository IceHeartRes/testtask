package com.example.testtask.dao;

import com.example.testtask.dao.interfaces.DemoDataDao;
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
public class DemoDataDaoImpl implements DemoDataDao {
    @Autowired
    private UserTable userTable;
    @Autowired
    private  TariffPlaneTable tariffPlaneTable;
    @Autowired
    private  MessageTable messageTable;

    @Override
    public void createDemoTables() {
        userTable.createTable();
        tariffPlaneTable.createTable();
        messageTable.createTable();

        userTable.insertDemoIntoTable();
        tariffPlaneTable.insertDemoIntoTable();
        messageTable.insertDemoIntoTable();
    }
}
