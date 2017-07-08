package com.example.testtask.controllers;

import com.example.testtask.request.RequestError;
import com.example.testtask.request.RequestSuccess;
import com.example.testtask.services.DataService;
import com.example.testtask.entries.User;
import com.example.testtask.exceptions.DuplicateUserIdException;
import com.example.testtask.exceptions.UsersNotFoundException;
import com.example.testtask.utils.ErrorHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Resident on 05.07.2017.
 * контроллер чтения информации о пользователях
 */
@Controller
public class ReadUsersController {
    private final DataService dataService;

    @Autowired
    public ReadUsersController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public void readAllUsers(HttpServletResponse response) throws IOException {
        String json;
        try {
            List<User> users = dataService.getAllUsers();
            json = new Gson().toJson(new RequestSuccess(users));
            response.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            json = new Gson().toJson(new RequestError(ErrorHandler.getHandler(e)));
            response.setStatus(500);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @RequestMapping(value = "/users/id={id}", method = RequestMethod.GET)
    @ResponseBody
    public void readUserById(@PathVariable("id") int userId, HttpServletResponse response) throws IOException {
        String json;
        try {
            User user = dataService.getUserById(userId);
            json = new Gson().toJson(new RequestSuccess(Collections.singletonList(user)));
            response.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            json = new Gson().toJson(new RequestError(ErrorHandler.getHandler(e)));
            response.setStatus(500);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @RequestMapping(value = "/users/tp={tpid}", method = RequestMethod.GET)
    @ResponseBody
    public void readUsersByTp(@PathVariable("tpid") int tpId, HttpServletResponse response) throws IOException {
        String json;
        try {
            List<User> users = dataService.getUsersByTp(tpId);
            json = new Gson().toJson(new RequestSuccess<>(users));
            response.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            json = new Gson().toJson(new RequestError(ErrorHandler.getHandler(e)));
            response.setStatus(500);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }




}
