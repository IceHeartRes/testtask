package com.example.testtask.mappers;

import com.example.testtask.entries.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by resident on 08.07.17.
 */
@Component
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User profile = new User();
        profile.setId(rs.getInt("id"));
        profile.setName(rs.getString("name"));
        profile.setTpId(rs.getInt("tpId"));
        return profile;
    }
}
