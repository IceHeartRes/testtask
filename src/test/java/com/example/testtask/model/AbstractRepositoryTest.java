package com.example.testtask.model;

import com.example.testtask.TestTaskApplication;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Created by resident on 09.07.17.
 * подключение к тестовому репозиторию
 */

@TestPropertySource(locations = "classpath:test-repository.properties")
@TestExecutionListeners(DbUnitTestExecutionListener.class)
@SpringBootTest(classes = TestTaskApplication.class)
@DirtiesContext
public abstract class AbstractRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
}
