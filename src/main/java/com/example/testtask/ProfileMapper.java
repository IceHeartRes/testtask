package com.example.testtask;

import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Resident on 06.07.2017.
 */

@Component
public class ProfileMapper implements RowMapper<Profile> {

    @Override
    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
        Profile profile = new Profile();
        profile.setId(rs.getInt("id"));
        profile.setA(rs.getInt("a"));
        profile.setB(rs.getString("b"));
        return profile;
    }
}
