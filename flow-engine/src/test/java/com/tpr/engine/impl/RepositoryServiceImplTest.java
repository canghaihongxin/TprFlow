package com.tpr.engine.impl;

import com.tpr.engine.repository.DeploymentBuilder;
import junit.framework.TestCase;
import org.junit.Test;



public class RepositoryServiceImplTest  {


    @Test
    public void deploy(){
        String processName = "processName";

        RepositoryServiceImpl repositoryService = new RepositoryServiceImpl();
        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.name("modelName").addString(processName,"1234");
        deployment.deploy();


    }

}