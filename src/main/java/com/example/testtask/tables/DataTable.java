package com.example.testtask.tables;

import com.example.testtask.sql.interfaces.ITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by resident on 08.07.17.
 */
public abstract class DataTable<M, I> implements ITable<I> {
    protected String DROP_TABLE;
    protected String CREATE_TABLE;
    protected String INSERT_INTO_TABLE;
    protected String SELECT_ALL_FROM_TABLE;

    protected final M mapper;
    protected final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DataTable(
            M mapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.mapper = mapper;
        this.jdbcTemplate = jdbcTemplate;
    }


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
