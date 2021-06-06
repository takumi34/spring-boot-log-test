package com.example.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SampleLogger {
    private final static Logger log = LoggerFactory.getLogger(Logger.class);

    public void outputLog() {
        log.info("Logger_test");
    }

}
