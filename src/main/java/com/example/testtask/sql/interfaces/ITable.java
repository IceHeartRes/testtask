package com.example.testtask.sql.interfaces;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * Created by resident on 08.07.17.
 * интерфейс класса пользователей
 */
public interface ITable<T> {
   void createTable();

    void insertDemoIntoTable();

    List<T> readAll();
}
