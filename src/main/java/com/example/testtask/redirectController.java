package com.example.testtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Resident on 05.07.2017.
 */
//5432
@Controller
//@RequestMapping("/{key}")
@RequestMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class redirectController {
    @Autowired
    private ConnectionSettings connectionSettings;

    private final ProfileService profileService;

    @Autowired
    public redirectController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "/{personId:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public Profile getProfile(@PathVariable String personId) {
        return profileService.getProfile(Integer.valueOf(personId));
    }

    @RequestMapping()
    public void redirect(@PathVariable("key") String key, HttpServletResponse response) {


        try {
            Class.forName(connectionSettings.getName());
            Connection connection = DriverManager.getConnection(connectionSettings.getUrl(), connectionSettings.getName(), connectionSettings.getPassword());
            Statement statement = connection.createStatement();

            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM aaa");

            while (result1.next()) {
                System.out.println(" ");
            }
        } catch (Exception ex) {
            System.out.println("error");
        }

        if (key.equals("aabbccdd")) {
            response.setHeader("Location", "http://www.ya.ru");
            response.setStatus(302);
        } else {
            response.setStatus(404);
        }
    }


}
