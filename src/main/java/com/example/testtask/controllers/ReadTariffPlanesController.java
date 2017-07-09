package com.example.testtask.controllers;

import com.example.testtask.entries.TariffPlane;
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
public class ReadTariffPlanesController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/tariff_planes", method = RequestMethod.GET)
    @ResponseBody
    public void readAllTariffPlanes(HttpServletResponse response) throws IOException {
        try {
            List<TariffPlane> tariffPlanes = dataService.getAllTariffPlanes();
            ResponseModified.toSuccess(response, tariffPlanes);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModified.toFail(response, ErrorHandler.getHandler(e));
        }
    }
}
