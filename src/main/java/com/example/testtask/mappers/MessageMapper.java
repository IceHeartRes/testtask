package com.example.testtask.mappers;

import com.example.testtask.entries.Message;
import com.example.testtask.entries.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by resident on 08.07.17.
 */
@Component
public class MessageMapper implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();
        message.setId(rs.getInt("id"));
        message.setUserId(rs.getInt("userId"));
        message.setDate(rs.getDate("date"));
        message.setMessage(rs.getString("message"));
        return message;
    }
}
