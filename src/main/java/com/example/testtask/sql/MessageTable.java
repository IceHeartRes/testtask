package com.example.testtask.sql;

import com.example.testtask.sql.interfaces.IMessageTable;
import com.example.testtask.sql.interfaces.IUserTable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by resident on 08.07.17.
 */
public class MessageTable implements IMessageTable {
    private static final String DROP_TABLE =
            "DROP TABLE IF EXISTS messages";

    private static final String CREATE_TABLE =
            "CREATE TABLE messages (" +
                    "id SERIAL," +
                    "userId bigint," +
                    "date date," +
                    "messages text)";
    private static final String INSERT_INTO_TABLE =
            "INSERT INTO messages (userid, date, messages) VALUES (1, '2016.05.03 01:27:10+3','условия тарифного плана изменены.');" +
                    "INSERT INTO messages (userid, date, messages) VALUES (3, '2016.06.12 12:04:56+7','условия тарифного плана изменены.');" +
                    "INSERT INTO messages (userid, date, messages) VALUES (3, '2016.09.20 12:04:56+7','условия тарифного плана изменены.');" +
                    "INSERT INTO messages (userid, date, messages) VALUES (2, '2016.07.30 15:20:00+7','условия тарифного плана изменены.');" +
                    "INSERT INTO messages (userid, date, messages) VALUES (1, '2016.06.22 01:27:10+3','условия тарифного плана изменены.');" +
                    "INSERT INTO messages (userid, date, messages) VALUES (5, '2016.01.12 00:00:00+7','условия тарифного плана изменены.');" +
                    "INSERT INTO messages (userid, date, messages) VALUES (4, '2016.07.01 20:48:04+1','условия тарифного плана изменены.');" +
                    "INSERT INTO messages (userid, date, messages) VALUES (4, '2016.07.01 20:48:04+1','условия тарифного плана изменены.');";

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
