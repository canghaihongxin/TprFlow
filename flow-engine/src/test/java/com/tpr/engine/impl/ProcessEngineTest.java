package com.tpr.engine.impl;


import com.tpr.engine.ProcessEngine;
import com.tpr.engine.ProcessEngineConfiguration;
import com.tpr.engine.RepositoryService;
import com.tpr.engine.test.ActivitiTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProcessEngineTest  extends ActivitiTestCase {
    private static Logger log = LoggerFactory.getLogger(ProcessEngineTest.class);
    protected String configurationResource = "activiti.cfg.xml";




    @Before
    public void before(){
        super.initializeProcessEngine();
    }

    @Test
    public void initializeProcessEngine() {

        log.debug("==== BUILDING PROCESS ENGINE ========================================================================");
         processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource(
                        configurationResource).buildProcessEngine();

        log.debug("==== PROCESS ENGINE CREATED =========================================================================");

    }

    /**
     * 初始化repositoryService
     */
    @Test
    public void initializeRepositoryService(){
        initializeProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        log.debug("==== REPOSITORY_SERVICE ENGINE CREATED =========================================================================");
    }

    @Test
    public void addModel(){

        RepositoryService repositoryService1 = processEngine.getRepositoryService();
//        Model model = repositoryService1.newModel();
    }




}

