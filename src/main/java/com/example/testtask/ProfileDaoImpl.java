package com.example.testtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Resident on 06.07.2017.
 */

@Repository
public class ProfileDaoImpl implements ProfileDao {

    private static final String SQL_GET_PROFILE_BY_ID =
            "select * from aaa";

    private final ProfileMapper profileMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProfileDaoImpl(
            ProfileMapper profileMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.profileMapper = profileMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Profile getProfileById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        List<Profile> profiles = jdbcTemplate.query(
                SQL_GET_PROFILE_BY_ID,
                params,
                profileMapper
        );
        if (profiles.isEmpty()) {
            throw new ProfileNotFoundException(id);
        }
        return profiles.get(0);
    }
}
