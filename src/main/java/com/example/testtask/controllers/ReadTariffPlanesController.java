package com.example.testtask.controllers;

import com.example.testtask.entries.TariffPlane;
import com.example.testtask.request.RequestError;
import com.example.testtask.request.RequestSuccess;
import com.example.testtask.services.DataService;
import com.example.testtask.utils.ErrorHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Resident on 05.07.2017.
 * контроллер чтения информации о тарифных планах
 */
@Controller
public class ReadTariffPlanesController {
    private final DataService dataService;

    @Autowired
    public ReadTariffPlanesController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/tariff_planes", method = RequestMethod.GET)
    @ResponseBody
    public void readAllTariffPlanes(HttpServletResponse response) throws IOException {
        String json;
        try {
            List<TariffPlane> tariffPlanes = dataService.getAllTariffPlanes();
            json = new Gson().toJson(new RequestSuccess<>(tariffPlanes));
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
