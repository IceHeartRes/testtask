package com.example.testtask.tables;

import com.example.testtask.entries.User;
import com.example.testtask.exceptions.DuplicateUserIdException;
import com.example.testtask.exceptions.UsersNotFoundException;
import com.example.testtask.mappers.UserMapper;
import com.example.testtask.sql.interfaces.ITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by resident on 08.07.17.
 */
@Component
public class UserTable extends DataTable<UserMapper, User> implements ITable<User> {
//|                                                       "SELECT * FROM users, tariffplanes WHERE users.tpid = tariffplanes.id"
    private static final String SELECT_BY_ID_FROM_TABLE = "SELECT * FROM users, tariffplanes WHERE users.id = :userid AND users.tpid = tariffplanes.id";
    private static final String SELECT_BY_TP_FROM_TABLE = "SELECT * FROM users, tariffplanes WHERE users.tpid = :tpid AND users.tpid = tariffplanes.id";
    private final MessageTable messageTable;

    @Autowired
    public UserTable(UserMapper mapper, NamedParameterJdbcTemplate jdbcTemplate, MessageTable messageTable) {
        super(mapper, jdbcTemplate);
        this.messageTable = messageTable;

        DROP_TABLE =
                "DROP TABLE IF EXISTS users";

        CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS users (" +
                        "id SERIAL," +
                        "name text," +
                        "tpId bigint)";
        INSERT_INTO_TABLE =
                "INSERT INTO users (name, tpid) VALUES ('qwe',1);" +
                        "INSERT INTO users (name, tpid) VALUES ('asd',3);" +
                        "INSERT INTO users (name, tpid) VALUES ('asd',3);" +
                        "INSERT INTO users (name, tpid) VALUES ('asd',2);" +
                        "INSERT INTO users (name, tpid) VALUES ('asd',1);";

        SELECT_ALL_FROM_TABLE = "SELECT * FROM users, tariffplanes WHERE users.tpid = tariffplanes.id";
    }

    @Override
    public List<User> readAll() {
        List<User> users = jdbcTemplate.query(
                SELECT_ALL_FROM_TABLE,
                new MapSqlParameterSource(),
                mapper
        );
        if (users.isEmpty()) {
            throw new UsersNotFoundException();
        }
        return users;
    }

    private void readMessages(User user) {
        MapSqlParameterSource mapParam = new MapSqlParameterSource();
        mapParam.addValue("userid", user.getId());


        user.setMessages(messageTable.readMessage(user.getId()));
    }

    public User readById(int userId){
        MapSqlParameterSource mapParam = new MapSqlParameterSource();
        mapParam.addValue("userid",Integer.valueOf(userId));

        List<User> users = jdbcTemplate.query(
                SELECT_BY_ID_FROM_TABLE,
                mapParam,
                mapper
        );
        if (users.isEmpty()) {
            throw new UsersNotFoundException();
        } else  if (users.size()>1){
            throw new DuplicateUserIdException();
        }
        else {
            User user = users.get(0);
            readMessages(user);
            return user;
        }
    }

    public List<User> readByTp(int tpId){
        MapSqlParameterSource mapParam = new MapSqlParameterSource();
        mapParam.addValue("tpid",Integer.valueOf(tpId));

        List<User> users = jdbcTemplate.query(
                SELECT_BY_TP_FROM_TABLE,
                mapParam,
                mapper
        );
        if (users.isEmpty()) {
            throw new UsersNotFoundException();
        }
        else {
            for (User user : users) {
                readMessages(user);
            }

        }
        return users;
    }
}
