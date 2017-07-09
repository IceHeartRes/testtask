package com.example.testtask.controllers;

import com.example.testtask.entries.Message;
import com.example.testtask.services.DataService;
import com.example.testtask.utils.ErrorHandler;
import com.example.testtask.utils.ResponseModified;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Resident on 05.07.2017.
 * контроллер чтения информации о тарифных планах
 */
@RestController
public class ReadMessagesController {
    private final DataService dataService;

    @Autowired
    public ReadMessagesController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    @ResponseBody
    public void readAllTariffPlanes(HttpServletResponse response) throws IOException {
        try {
            List<Message> messages = dataService.getAllMessages();
            ResponseModified.toSuccess(response, messages);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModified.toFail(response, ErrorHandler.getHandler(e));
        }
    }
}
