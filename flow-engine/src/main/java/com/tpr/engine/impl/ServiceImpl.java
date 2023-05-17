package com.tpr.engine.impl;

import com.tpr.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.tpr.engine.impl.interceptor.CommandExecutor;

/**
 * 持久层封闭， 方便操作数据库
 */
public class ServiceImpl {

    protected ProcessEngineConfigurationImpl processEngineConfiguration;
    public ServiceImpl() {

    }
    public ServiceImpl(ProcessEngineConfigurationImpl processEngineConfiguration) {
        this.processEngineConfiguration = processEngineConfiguration;
    }

    protected CommandExecutor commandExecutor;

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }


    public void setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }
}
