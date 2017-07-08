package com.example.testtask.sql;

import com.example.testtask.sql.interfaces.ITariffPlaneTable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by resident on 08.07.17.
 */
public class TariffPlaneTable implements ITariffPlaneTable {
    private static final String DROP_TABLE =
            "DROP TABLE IF EXISTS tariffplanes";

    private static final String CREATE_TABLE =
            "CREATE TABLE tariffplanes (" +
                    "id SERIAL," +
                    "condition bigint," +
                    "change bigint," +
                    "time_interval bigint," +
                    "description text)";
    private static final String INSERT_INTO_TABLE =
            "INSERT INTO tariffplanes (condition, change, time_interval, description) VALUES (100, 1, 50,'стоимость одной минуты разговора, в копейках');" +
                    "INSERT INTO tariffplanes (condition, change, time_interval, description) VALUES (250, 5, 30,'стоимость одного СМС, в копейках');" +
                    "INSERT INTO tariffplanes (condition, change, time_interval, description) VALUES (10, 1, 100,'стоимость одного Мб интернета, в копейках');";

    @Override
    public void createTable(NamedParameterJdbcTemplate jdbcTemplate) {
        jdbcTemplate.update(DROP_TABLE, new MapSqlParameterSource());
        jdbcTemplate.update(CREATE_TABLE, new MapSqlParameterSource());
    }

    @Override
    public void insertDemoIntoTable(NamedParameterJdbcTemplate jdbcTemplate) {
        jdbcTemplate.update(INSERT_INTO_TABLE, new MapSqlParameterSource());
    }

}
