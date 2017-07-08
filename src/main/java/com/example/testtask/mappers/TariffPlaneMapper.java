package com.example.testtask.mappers;

import com.example.testtask.entries.Message;
import com.example.testtask.entries.TariffPlane;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by resident on 08.07.17.
 */
@Component
public class TariffPlaneMapper implements RowMapper<TariffPlane> {

    @Override
    public TariffPlane mapRow(ResultSet rs, int rowNum) throws SQLException {

        return TariffPlaneGetter.parse(rs);
    }
}
