package com.tpr.engine.impl;

import com.tpr.engine.RepositoryService;
import com.tpr.engine.impl.cmd.DeployCmd;
import com.tpr.engine.impl.repository.DeploymentBuilderImpl;
import com.tpr.engine.repository.Deployment;
import com.tpr.engine.repository.DeploymentBuilder;


/**
 * @author 田培融

 */
public class RepositoryServiceImpl  extends  ServiceImpl implements RepositoryService {


    @Override
    public DeploymentBuilder createDeployment() {
        return new DeploymentBuilderImpl(this);
    }

    public Deployment deploy(DeploymentBuilderImpl deploymentBuilder) {
        return commandExecutor.execute(new DeployCmd<Deployment>(deploymentBuilder));
    }
}
