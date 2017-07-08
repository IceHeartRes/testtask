package com.example.testtask.sql;

import com.example.testtask.ProfileNotFoundException;
import com.example.testtask.entries.User;
import com.example.testtask.mappers.UserMapper;
import com.example.testtask.sql.interfaces.IUserTable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * Created by resident on 08.07.17.
 */
public class UserTable implements IUserTable {
    private static final String DROP_TABLE =
            "DROP TABLE IF EXISTS users";

    private static final String CREATE_TABLE =
            "CREATE TABLE users (" +
                    "id SERIAL," +
                    "name text," +
                    "tpId bigint)";
    private static final String INSERT_INTO_TABLE =
            "INSERT INTO users (name, tpid) VALUES ('qwe',1);" +
                    "INSERT INTO users (name, tpid) VALUES ('asd',3);" +
                    "INSERT INTO users (name, tpid) VALUES ('asd',3);" +
                    "INSERT INTO users (name, tpid) VALUES ('asd',2);" +
                    "INSERT INTO users (name, tpid) VALUES ('asd',1);";

    private static final String SELECT_FROM_TABLE = "select * from users";

    @Override
    public  void createTable(NamedParameterJdbcTemplate jdbcTemplate){
        jdbcTemplate.update(DROP_TABLE, new MapSqlParameterSource());
        jdbcTemplate.update(CREATE_TABLE, new MapSqlParameterSource());
    }

    @Override
    public  void insertDemoIntoTable(NamedParameterJdbcTemplate jdbcTemplate) {
        jdbcTemplate.update(INSERT_INTO_TABLE, new MapSqlParameterSource());
    }

    public List<User> readAllUsers(NamedParameterJdbcTemplate jdbcTemplate){
        List<User> profiles = jdbcTemplate.query(
                SELECT_FROM_TABLE,
                new MapSqlParameterSource(),
                new UserMapper()
        );
        if (profiles.isEmpty()) {
            throw new ProfileNotFoundException(1);
        }
        return profiles;
    }

}
