package com.example.testtask.dao;

import com.example.testtask.dao.interfaces.MessageDataDao;
import com.example.testtask.dao.interfaces.TariffPlaneDataDao;
import com.example.testtask.entries.Message;
import com.example.testtask.entries.TariffPlane;
import com.example.testtask.tables.MessageTable;
import com.example.testtask.tables.TariffPlaneTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */

@Repository
public class MessageDaoImpl implements MessageDataDao {
    @Autowired
    private MessageTable messageTable;

    @Override
    public List<Message> getAllMessages() {
        return messageTable.readAll();
    }
}
