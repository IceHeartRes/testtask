package com.example.testtask.dao;

import com.example.testtask.dao.interfaces.TariffPlaneDataDao;
import com.example.testtask.dao.interfaces.UserDataDao;
import com.example.testtask.entries.TariffPlane;
import com.example.testtask.entries.User;
import com.example.testtask.tables.TariffPlaneTable;
import com.example.testtask.tables.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */

@Repository
public class TariffPlaneDaoImpl implements TariffPlaneDataDao {
    @Autowired
    private TariffPlaneTable tariffPlaneTable;

    @Override
    public List<TariffPlane> getAllTariffPlanes() {
        return tariffPlaneTable.readAll();
    }
}
