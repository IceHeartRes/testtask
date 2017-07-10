package com.example.testtask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Resident on 06.07.2017.
 */
@Component
@ConfigurationProperties(prefix = "dataSource")
public class ConnectionSettings {

    private static final String TCP_ADDR = "TEST_PORT_5432_TCP_ADDR";
    private static final String TCP_PORT = "TEST_PORT_5432_TCP_PORT";
    private static int DEFAULT_MAX_POOL_SIZE = 5;

    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String name;
    @Value("${dataSource.password}")
    private String password;
    private int jdbcMaxPoolSize = DEFAULT_MAX_POOL_SIZE;

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return String.format(url, System.getenv(TCP_ADDR), System.getenv(TCP_PORT));
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getJdbcMaxPoolSize() {
        return jdbcMaxPoolSize;
    }

    public void setJdbcMaxPoolSize(int jdbcMaxPoolSize) {
        this.jdbcMaxPoolSize = jdbcMaxPoolSize;
    }
}
