package com.example.testtask.tables;

import com.example.testtask.sql.interfaces.ITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by resident on 08.07.17.
 *
 */
public abstract class DataTable<M, I> implements ITable<I> {
    String DROP_TABLE;
    String CREATE_TABLE;
    String INSERT_INTO_TABLE;
    String SELECT_ALL_FROM_TABLE;

    @Autowired
    M mapper;
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void createTable() {
        jdbcTemplate.update(DROP_TABLE, new MapSqlParameterSource());
        jdbcTemplate.update(CREATE_TABLE, new MapSqlParameterSource());
    }

    @Override
    public void insertDemoIntoTable() {
        jdbcTemplate.update(INSERT_INTO_TABLE, new MapSqlParameterSource());
    }


}
