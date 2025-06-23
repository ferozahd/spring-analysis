package com.frameworkanalysis.apachelogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApacheLoggerStarter {
    private static final Log log = LogFactory.getLog(ApacheLoggerStarter.class);

    public static void main(String[] args) {
        System.out.println("Classpath: " + System.getProperty("java.class.path"));

        log.debug("Debug message");
        log.info("Info message");
        log.warn("Warning message");
        log.error("Error message");
    }
}
