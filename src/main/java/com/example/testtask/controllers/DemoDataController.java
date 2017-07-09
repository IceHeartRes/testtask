package com.example.testtask.controllers;

import com.example.testtask.services.DataService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Resident on 05.07.2017.
 * контроллер заполнения таблиц демонстрационными данными
 */
@RestController
public class DemoDataController {
    private final DataService dataService;

    @Autowired
    public DemoDataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/create_tables", method = RequestMethod.GET)
    @ResponseBody
    public void createDemoTableAndFill(HttpServletResponse response) throws IOException {
        String json;
        try {
            dataService.createDemoTables();
            json = new Gson().toJson(new RequestSuccess());
            response.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
            json = new Gson().toJson(new RequestError(e.getLocalizedMessage()));
            response.setStatus(500);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private class RequestSuccess {
        private boolean result = true;
    }

    private class RequestError {
        private boolean result = false;
        private String message;

        public RequestError(String message) {
            this.message = message;
        }
    }
}
