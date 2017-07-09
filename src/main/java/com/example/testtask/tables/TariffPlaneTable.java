package com.example.testtask.tables;

import com.example.testtask.entries.TariffPlane;
import com.example.testtask.exceptions.TariffPlanesNotFoundException;
import com.example.testtask.mappers.TariffPlaneMapper;
import com.example.testtask.sql.interfaces.ITable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by resident on 08.07.17.
 * таблица тарифных планов
 */
@Component
public class TariffPlaneTable extends DataTable<TariffPlaneMapper, TariffPlane> implements ITable<TariffPlane> {

    public TariffPlaneTable() {
        DROP_TABLE =
                "DROP TABLE IF EXISTS tariffplanes";

        CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS tariffplanes (" +
                        "id SERIAL," +
                        "condition bigint," +
                        "change bigint," +
                        "time_interval bigint," +
                        "description text)";
        INSERT_INTO_TABLE =
                "INSERT INTO tariffplanes (condition, change, time_interval, description) VALUES (100, 1, 50,'стоимость одной минуты разговора, в копейках');" +
                        "INSERT INTO tariffplanes (condition, change, time_interval, description) VALUES (250, 5, 30,'стоимость одного СМС, в копейках');" +
                        "INSERT INTO tariffplanes (condition, change, time_interval, description) VALUES (10, 1, 100,'стоимость одного Мб интернета, в копейках');";

        SELECT_ALL_FROM_TABLE = "SELECT * FROM tariffplanes";
    }

    @Override
    public List<TariffPlane> readAll() {
        List<TariffPlane> tariffPlanes = jdbcTemplate.query(
                SELECT_ALL_FROM_TABLE,
                new MapSqlParameterSource(),
                mapper
        );
        if (tariffPlanes.isEmpty()) {
            throw new TariffPlanesNotFoundException();
        }

        return tariffPlanes;
    }

}
