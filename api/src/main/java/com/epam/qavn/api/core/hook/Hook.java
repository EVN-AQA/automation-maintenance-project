package com.epam.qavn.api.core.hook;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Hook {


    protected Logger logger;
    protected ObjectMapper mapper;

    public Hook() {
        logger = LogManager.getLogger(getClass());
        mapper = new ObjectMapper();
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    @Before
    public void setUp(Scenario scenario) {
    }

    @After
    public void tearDown(Scenario scenario) {

    }

}
