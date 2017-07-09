package com.example.testtask.services;

import com.example.testtask.dao.interfaces.DemoDataDao;
import com.example.testtask.dao.interfaces.MessageDataDao;
import com.example.testtask.dao.interfaces.TariffPlaneDataDao;
import com.example.testtask.dao.interfaces.UserDataDao;
import com.example.testtask.entries.Message;
import com.example.testtask.entries.TariffPlane;
import com.example.testtask.entries.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 * сервис работы с данными
 */

@Component
public class DataService {
    @Autowired
    private DemoDataDao demoDataDao;
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private TariffPlaneDataDao tariffPlaneDataDao;
    @Autowired
    private MessageDataDao messageDataDao;

    public void createDemoTables() throws Exception{
        demoDataDao.createDemoTables();
    }

    public List<User> getAllUsers(){
        return userDataDao.getAllUsers();
    }

    public User getUserById(int userId){
        return userDataDao.getUserById(userId);
    }

    public List<User> getUsersByTp(int tpId){
        return userDataDao.getUsersByTp(tpId);
    }

    public List<TariffPlane> getAllTariffPlanes(){
        return tariffPlaneDataDao.getAllTariffPlanes();
    }

    public List<Message> getAllMessages(){
        return messageDataDao.getAllMessages();
    }
}
