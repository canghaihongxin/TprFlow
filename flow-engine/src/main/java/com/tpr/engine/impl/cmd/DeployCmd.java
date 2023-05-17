package com.tpr.engine.impl.cmd;

import com.tpr.engine.impl.interceptor.Command;
import com.tpr.engine.impl.interceptor.CommandContext;
import com.tpr.engine.impl.repository.DeploymentBuilderImpl;
import com.tpr.engine.persistence.DeploymentEntity;
import com.tpr.engine.repository.Deployment;

import java.io.Serializable;

/**
 * @author 田培融

 * 部署的命令类
 */
public class DeployCmd<T>  implements Command<Deployment> , Serializable {


    protected DeploymentBuilderImpl deploymentBuilder;


    public DeployCmd(DeploymentBuilderImpl deploymentBuilder) {
        this.deploymentBuilder = deploymentBuilder;
    }

    @Override
    public Deployment execute(CommandContext commandContext) {
        //获取部署实体对象
        DeploymentEntity deployment = deploymentBuilder.getDeployment();

        //设置部署时间为当前系统时间
        deployment.setDeploymentTime(commandContext.getProcessEngineConfiguration().getClock().getCurrentTime());

        /*
        判断是否开启了过滤重复文档功能
        如果DB中已经存在 ,则不会重复部署
        repositoryService.createDeployment().enableDuplicateFiltering();
        具体如何过滤重复文档的???
        */
        return deployment;

    }
}
