package com.example.logtest;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
public class LoggerTest {

    @Autowired
    private SampleLogger sampleLogger;

    @Mock
    private Appender<ILoggingEvent> mockAppender;

    @Captor
    private ArgumentCaptor<LoggingEvent> captorLoggingEvent;

    @BeforeEach
    public void setup() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.addAppender(mockAppender);
    }

    @AfterEach
    public void cleanup() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.detachAppender(mockAppender);
    }

    //use Mockito
    @Test
    void testSampleLoggerUsingMockito() {
        sampleLogger.outputLog();

        verify(mockAppender, times(1)).doAppend(captorLoggingEvent.capture());
        final LoggingEvent loggingEvent = captorLoggingEvent.getValue();


        //test the log level and message
        assertEquals(Level.INFO, loggingEvent.getLevel());
        assertEquals("Logger_test",
                loggingEvent.getFormattedMessage());
    }

    //use OutputCapture
    @ExtendWith(OutputCaptureExtension.class)
    @Test
    void testSampleLoggerUsingOutputCapture(CapturedOutput output) {
        sampleLogger.outputLog();

        //test the capturedOutput
        assertTrue(output.toString().contains("Logger_test"));
    }

}