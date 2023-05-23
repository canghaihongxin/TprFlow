package com.tpr.engine.test;

import com.tpr.engine.ProcessEngine;
import junit.framework.TestCase;

public abstract class ActivitiTestCase {


    protected String configurationResource = "activiti.cfg.xml";

    protected ProcessEngine processEngine;


    protected void initializeProcessEngine() {
        if (processEngine == null) {
            processEngine = TestHelper.getProcessEngine(getConfigurationResource());
        }
    }

    public String getConfigurationResource() {
        return configurationResource;
    }


}
