package com.example.testtask.controllers;

import com.example.testtask.entries.User;
import com.example.testtask.services.DataService;
import com.example.testtask.utils.ErrorHandler;
import com.example.testtask.utils.ResponseModified;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Resident on 05.07.2017.
 * контроллер чтения информации о пользователях
 */
@RestController
public class ReadUsersController {
    private final DataService dataService;

    @Autowired
    public ReadUsersController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public void readAllUsers(HttpServletResponse response) throws IOException {
        try {
            List<User> users = dataService.getAllUsers();
            ResponseModified.toSuccess(response, users);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModified.toFail(response, ErrorHandler.getHandler(e));
        }
    }

    @RequestMapping(value = "/users/id={id}", method = RequestMethod.GET)
    @ResponseBody
    public void readUserById(@PathVariable("id") int userId, HttpServletResponse response) throws IOException {
        try {
            User user = dataService.getUserById(userId);
            ResponseModified.toSuccess(response, Collections.singletonList(user));
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModified.toFail(response, ErrorHandler.getHandler(e));
        }
    }

    @RequestMapping(value = "/users/tp={tpid}", method = RequestMethod.GET)
    @ResponseBody
    public void readUsersByTp(@PathVariable("tpid") int tpId, HttpServletResponse response) throws IOException {
        try {
            List<User> users = dataService.getUsersByTp(tpId);
            ResponseModified.toSuccess(response, users);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModified.toFail(response, ErrorHandler.getHandler(e));
        }
    }
}
