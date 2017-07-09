package com.example.testtask;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * Created by Resident on 05.07.2017.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = TestTaskApplication.class)
//@WebAppConfiguration
public class RedirectTest {
//    private static final String PATH = "/aabbccdd";
//    private static final int REDIRECT_STATUS = 302;
//    private static final String HEADER_NAME = "Location";
//    private static final String HEADER_VALUE = "www.ya.ru";
////    private static final String BAD_PATH = "/users";
//    private static final String BAD_PATH = "/users/id=3";
////    private static final String BAD_PATH = "/create_tables";
//    private static final int NOT_FOUND = 404;
//    private static final int SUCCESS_STATUS = 200;
////    @Autowired
//    WebApplicationContext webApplicationContext;
//    MockMvc mockMvc;

    @Before
    public void init() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void checkKey() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get(BAD_PATH))
//                .andExpect(MockMvcResultMatchers.status().is(SUCCESS_STATUS));
    }
}
