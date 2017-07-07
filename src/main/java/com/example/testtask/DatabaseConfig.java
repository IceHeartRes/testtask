package com.example.testtask;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Resident on 06.07.2017.
 */
@Configuration
public class DatabaseConfig {

    @Autowired
    private ConnectionSettings connectionSettings;

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(connectionSettings.getDriver());
        hikariConfig.setJdbcUrl(connectionSettings.getUrl());
        hikariConfig.setUsername(connectionSettings.getName());
        hikariConfig.setPassword(connectionSettings.getPassword());
        hikariConfig.setMaximumPoolSize(connectionSettings.getJdbcMaxPoolSize());
        hikariConfig.setPoolName("main");
        return new HikariDataSource(hikariConfig);
    }
}
