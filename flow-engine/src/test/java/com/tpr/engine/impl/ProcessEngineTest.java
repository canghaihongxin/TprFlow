package com.tpr.engine.impl;


import com.tpr.engine.ProcessEngine;
import com.tpr.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProcessEngineTest {
    private static Logger log = LoggerFactory.getLogger(ProcessEngineTest.class);
    protected String configurationResource = "activiti.cfg.xml";
    @Test
    public void initializeProcessEngine() {

        log.debug("==== BUILDING PROCESS ENGINE ========================================================================");
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource(
                        configurationResource).buildProcessEngine();

        log.debug("==== PROCESS ENGINE CREATED =========================================================================");

    }

}

