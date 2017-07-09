package com.example.testtask;

import com.example.testtask.dao.DemoDataDaoImpl;
import com.example.testtask.model.AbstractRepositoryTest;
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
 * тестирование рипозитория при правильной информации в ДБ
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestTaskApplication.class)
@WebAppConfiguration
public class SuccessRepository extends AbstractRepositoryTest {
    private static final String BAD_PATH = "/qq";
    private static final String CREATE_TABLES = "/create_tables";
    private static final String USERS = "/users";
    private static final String USERS_BY_ID = "/users/id=1";
    private static final String USERS_BY_TP = "/users/tp=1";
    private static final String TARIFF_PLANES = "/tariff_planes";
    private static final String MESSAGES = "/messages";
    private static final int SUCCESS_STATUS = 200;
    private static final int NOT_FOUND_STATUS = 404;
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    @Autowired
    private DemoDataDaoImpl demoDataDao;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        demoDataDao.createDemoTables();
    }

    @Test
    public void badPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(BAD_PATH))
                .andExpect(MockMvcResultMatchers.status().is(NOT_FOUND_STATUS));
    }

    @Test
    public void reCreateTables() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(CREATE_TABLES))
                .andExpect(MockMvcResultMatchers.status().is(SUCCESS_STATUS));
    }

    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(USERS))
                .andExpect(MockMvcResultMatchers.status().is(SUCCESS_STATUS));
    }

    @Test
    public void getUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(USERS_BY_ID))
                .andExpect(MockMvcResultMatchers.status().is(SUCCESS_STATUS));
    }

    @Test
    public void getUserByTp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(USERS_BY_TP))
                .andExpect(MockMvcResultMatchers.status().is(SUCCESS_STATUS));
    }

    @Test
    public void getTariffPlanes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TARIFF_PLANES))
                .andExpect(MockMvcResultMatchers.status().is(SUCCESS_STATUS));
    }

    @Test
    public void getMessages() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(MESSAGES))
                .andExpect(MockMvcResultMatchers.status().is(SUCCESS_STATUS));
    }
}
