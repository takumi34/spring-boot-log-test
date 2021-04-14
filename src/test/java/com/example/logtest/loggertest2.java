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
public class loggertest2 {

    @Autowired
    Logger2 logger2;

    @Test
    void test(CapturedOutput output) {
        logger2.outputLog();
        assertThat(output).doesNotContain("sample");
        System.out.println("+" + output + "+");
    }
}
