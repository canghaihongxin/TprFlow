package com.tpr;

import static org.junit.Assert.assertTrue;

import com.tpr.engine.impl.RepositoryServiceImpl;
import com.tpr.engine.repository.DeploymentBuilder;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        RepositoryServiceImpl repositoryService = new RepositoryServiceImpl();
        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.name("qq");
    }
}
