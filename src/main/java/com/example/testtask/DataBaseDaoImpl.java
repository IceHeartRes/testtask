package com.example.testtask;

import com.example.testtask.entries.User;
import com.example.testtask.mappers.UserMapper;
import com.example.testtask.sql.MessageTable;
import com.example.testtask.sql.TariffPlaneTable;
import com.example.testtask.sql.UserTable;
import com.example.testtask.sql.interfaces.IUserTable;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */

@Repository
public class DataBaseDaoImpl implements DataBaseDao {
    private final UserMapper userMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DataBaseDaoImpl(
            UserMapper userMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }//TODO сделать @Autowired в самом классе таблиц

    @Override
    public void createDemoTables() {
        UserTable userTable = new UserTable();
        TariffPlaneTable tariffPlaneTable = new TariffPlaneTable();
        MessageTable messageTable = new MessageTable();
        userTable.createTable(jdbcTemplate);
        tariffPlaneTable.createTable(jdbcTemplate);
        messageTable.createTable(jdbcTemplate);

        userTable.insertDemoIntoTable(jdbcTemplate);
        tariffPlaneTable.insertDemoIntoTable(jdbcTemplate);
        messageTable.insertDemoIntoTable(jdbcTemplate);
    }

    @Override
    public List<User> getUsers() {
        return new UserTable().readAllUsers(jdbcTemplate);
    }


}
