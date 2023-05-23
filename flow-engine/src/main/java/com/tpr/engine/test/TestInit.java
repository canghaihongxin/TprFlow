package com.tpr.engine.test;

import com.tpr.engine.ProcessEngine;
import com.tpr.engine.ProcessEngines;
import com.tpr.engine.exception.TprException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInit extends ActivitiTestCase {
    private static Logger TestInitLogger = LoggerFactory.getLogger(TestInit.class);


    protected static ProcessEngine cachedProcessEngine;




    protected void initializeProcessEngine() {
        if (cachedProcessEngine == null) {

            TestInitLogger.info("No cached process engine found for test. Retrieving the default engine.");

            // Just to be sure we're not getting any previously cached version
//            ProcessEngines.destroy();

            cachedProcessEngine = ProcessEngines.getDefaultProcessEngine();
            if (cachedProcessEngine==null) {
                throw new TprException("no default process engine available");
            }
        }
        processEngine = cachedProcessEngine;
    }

}
