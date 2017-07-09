package com.example.testtask.mappers;

import com.example.testtask.entries.TariffPlane;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by resident on 09.07.17.
 */

public class TariffPlaneGetter {

    public static TariffPlane parse(ResultSet rs) throws SQLException {
        TariffPlane tariffPlane = new TariffPlane();
        tariffPlane.setId(rs.getInt("id"));
        tariffPlane.setCondition(rs.getInt("condition"));
        tariffPlane.setChange(rs.getInt("change"));
        tariffPlane.setTime_interval(rs.getInt("time_interval"));
        tariffPlane.setDescription(rs.getString("description"));
        return tariffPlane;
    }
}
