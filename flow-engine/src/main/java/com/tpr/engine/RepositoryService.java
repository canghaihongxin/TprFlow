package com.tpr.engine;


import com.tpr.engine.repository.DeploymentBuilder;

/**
 * @author canghaihongxin
 * @version 1.0
 * @description: 提供对流程定义和部署存储库的访问权限的服务。
 * @date 2023/4/11 13:48
 */
public interface RepositoryService {

    DeploymentBuilder createDeployment();
}
