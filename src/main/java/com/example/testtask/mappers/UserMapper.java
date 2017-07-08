package com.example.testtask.mappers;

import com.example.testtask.entries.TariffPlane;
import com.example.testtask.entries.User;
import com.example.testtask.tables.MessageTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by resident on 08.07.17.
 */
@Component
public class UserMapper implements RowMapper<User> {

    private MessageTable messageTable;

    @Autowired
    public UserMapper(MessageTable messageTable) {
        this.messageTable = messageTable;
    }




    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setTpId(rs.getInt("tpId"));

        user.setTariffPlane(TariffPlaneGetter.parse(rs));

        MapSqlParameterSource mapParam = new MapSqlParameterSource();
        mapParam.addValue("userid", user.getId());


        user.setMessages(messageTable.readMessage(user.getId()));

        return user;
    }
}
