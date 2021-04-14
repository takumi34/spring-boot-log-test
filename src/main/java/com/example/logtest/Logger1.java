package com.example.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Logger1 {
    private final static Logger log = LoggerFactory.getLogger(Logger1.class);

    public void outputLog(){
        log.info("sample");
    }
}
