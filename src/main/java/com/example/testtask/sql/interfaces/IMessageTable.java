package com.example.testtask.sql.interfaces;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by resident on 08.07.17.
 * интерфейс класса пользователей
 */
public interface IMessageTable {
    void createTable(NamedParameterJdbcTemplate jdbcTemplate);

    void insertDemoIntoTable(NamedParameterJdbcTemplate jdbcTemplate);
}
