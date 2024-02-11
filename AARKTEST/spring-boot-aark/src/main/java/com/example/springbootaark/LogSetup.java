package com.example.springbootaark;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSetup {

    private static final Logger logger
            = LoggerFactory.getLogger(LogSetup.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", LogSetup.class.getSimpleName());
    }
}
