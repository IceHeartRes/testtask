package com.example.testtask.tables;

import com.example.testtask.entries.Message;
import com.example.testtask.exceptions.MessagesNotFoundException;
import com.example.testtask.mappers.MessageMapper;
import com.example.testtask.sql.interfaces.ITable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by resident on 08.07.17.
 */
@Component
public class MessageTable extends DataTable<MessageMapper, Message> {

    private static final String SELECT_FROM_TABLE = "SELECT * FROM messages WHERE userid = :userid";

    public MessageTable(MessageMapper mapper, NamedParameterJdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);

        DROP_TABLE =
                "DROP TABLE IF EXISTS messages";

        CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS messages (" +
                        "id SERIAL," +
                        "userId bigint," +
                        "date date," +
                        "message text)";
        INSERT_INTO_TABLE =
                "INSERT INTO messages (userid, date, message) VALUES (1, '2016.05.03','условия тарифного плана изменены.');" +
                        "INSERT INTO messages (userid, date, message) VALUES (3, '2016.06.12','условия тарифного плана изменены.');" +
                        "INSERT INTO messages (userid, date, message) VALUES (3, '2016.09.20','условия тарифного плана изменены.');" +
                        "INSERT INTO messages (userid, date, message) VALUES (2, '2016.07.30','условия тарифного плана изменены.');" +
                        "INSERT INTO messages (userid, date, message) VALUES (1, '2016.06.22','условия тарифного плана изменены.');" +
                        "INSERT INTO messages (userid, date, message) VALUES (5, '2016.01.12','условия тарифного плана изменены.');" +
                        "INSERT INTO messages (userid, date, message) VALUES (4, '2016.07.01','условия тарифного плана изменены.');" +
                        "INSERT INTO messages (userid, date, message) VALUES (4, '2016.07.01','условия тарифного плана изменены.');";

        SELECT_ALL_FROM_TABLE = "SELECT * FROM messages";
    }


    @Override
    public List<Message> readAll() {
        List<Message> messages = jdbcTemplate.query(
                SELECT_ALL_FROM_TABLE,
                new MapSqlParameterSource(),
                mapper
        );
        if (messages.isEmpty()) {
            throw new MessagesNotFoundException();
        }
        return messages;
    }

    public List<Message> readMessage(int userId) {
        MapSqlParameterSource mapParam = new MapSqlParameterSource();
        mapParam.addValue("userid", Integer.valueOf(userId));

        return jdbcTemplate.query(
                SELECT_FROM_TABLE,
                mapParam,
                mapper
        );
    }

}
