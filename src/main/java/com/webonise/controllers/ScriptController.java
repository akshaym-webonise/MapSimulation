package com.webonise.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptController {

    private static final Logger LOG = LoggerFactory.getLogger(ScriptController.class);

    public void logInfo(String message){
        LOG.info(message);
    }

    public void logError(String message){
        LOG.error(message);
    }

    public void logDebug(String message){
        LOG.debug(message);
    }

    public void logWarn(String message){
        LOG.warn(message);
    }
}
