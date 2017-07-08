package com.example.testtask.dao.interfaces;

import com.example.testtask.entries.TariffPlane;
import com.example.testtask.entries.User;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */
public interface TariffPlaneDataDao {
    List<TariffPlane> getAllTariffPlanes();
}
