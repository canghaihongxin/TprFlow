package com.tpr.engine.impl;

import com.tpr.engine.ProcessEngine;
import com.tpr.engine.RepositoryService;
import com.tpr.engine.impl.cfg.ProcessEngineConfigurationImpl;

/**
 * @author Tom Baeyens
 * @desc 对ProcessEngine接口中定义的() 进行实现
 */
public class ProcessEngineImpl implements ProcessEngine {

    protected String name;

    protected RepositoryService repositoryService;

    protected ProcessEngineConfigurationImpl processEngineConfiguration;

    public ProcessEngineImpl(ProcessEngineConfigurationImpl processEngineConfiguration) {
        this.processEngineConfiguration = processEngineConfiguration; //流程引擎配置 实例

        this.name = processEngineConfiguration.getProcessEngineName();  //流程引擎名称

        //初始化各种服务类实例
        this.repositoryService = processEngineConfiguration.getRepositoryService();


    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public RepositoryService getRepositoryService() {
        return repositoryService;
    }
}
