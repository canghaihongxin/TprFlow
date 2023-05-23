package com.tpr.engine.test;


import com.tpr.engine.ProcessEngine;
import com.tpr.engine.ProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 田培融
 */
public class TestHelper {
    private static Logger log = LoggerFactory.getLogger(TestHelper.class);
    static Map<String, ProcessEngine> processEngines = new HashMap<String, ProcessEngine>();


    public static ProcessEngine getProcessEngine(String configurationResource) {
        ProcessEngine processEngine = processEngines.get(configurationResource);
        if (processEngine == null) {
            log.debug("==== BUILDING PROCESS ENGINE ========================================================================");
            processEngine = ProcessEngineConfiguration
                    .createProcessEngineConfigurationFromResource(
                            configurationResource).buildProcessEngine();
            log.debug("==== PROCESS ENGINE CREATED =========================================================================");
            processEngines.put(configurationResource, processEngine);
        }
        return processEngine;
    }

}
