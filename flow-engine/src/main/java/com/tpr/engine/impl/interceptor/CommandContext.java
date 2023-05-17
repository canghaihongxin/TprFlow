package com.tpr.engine.impl.interceptor;

import com.tpr.engine.impl.cfg.ProcessEngineConfigurationImpl;

/**
 * @author 田培融
 * 命令上下文 该类负责在命令中进行参数的传递 ,
 * 不同的命令对象统一从该类中取出需要的参数, 并且把执行结果通过该类传递给上层
 */
public class CommandContext {

    protected ProcessEngineConfigurationImpl processEngineConfiguration;

    public ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        return processEngineConfiguration;
    }
}
