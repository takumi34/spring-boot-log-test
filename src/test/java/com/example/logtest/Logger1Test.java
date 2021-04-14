package com.example.logtest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
public class Logger1Test {

    @Autowired
    Logger1 logger1;

    @Test
    void test(CapturedOutput output) {
        logger1.outputLog();
        assertThat(output).contains("sample");
    }
}