package com.example.testtask.controllers;

import com.example.testtask.services.DataService;
import com.example.testtask.utils.ErrorHandler;
import com.example.testtask.utils.ResponseModified;
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
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/create_tables", method = RequestMethod.GET)
    public void createDemoTableAndFill(HttpServletResponse response) throws IOException {
        try {
            dataService.createDemoTables();
            ResponseModified.toSuccess(response, null);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModified.toFail(response, ErrorHandler.getHandler(e));
        }
    }
}
