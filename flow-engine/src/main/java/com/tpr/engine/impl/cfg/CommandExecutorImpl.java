package com.tpr.engine.impl.cfg;

import com.tpr.engine.impl.interceptor.Command;
import com.tpr.engine.impl.interceptor.CommandConfig;
import com.tpr.engine.impl.interceptor.CommandExecutor;
import com.tpr.engine.impl.interceptor.CommandInterceptor;

/**
 * Command executor that passes commands to the first interceptor in the chain.
 * If no {@link CommandConfig} is passed, the default configuration will be used.
 *
 * @author Marcus Klimstra (CGI)
 * 对 CommandExecutor 进行实现,
 * 内部有 CommandInterceptor 对象 负责调度执行具体的命令拦截器实例对象
 *
 */
public class CommandExecutorImpl implements CommandExecutor {

    private final CommandConfig defaultConfig;

    private final CommandInterceptor first;

    public CommandExecutorImpl(CommandConfig defaultConfig, CommandInterceptor first) {
        this.defaultConfig = defaultConfig;
        this.first = first;
    }

    @Override
    public <T> T execute(Command<T> command) {
        return execute(defaultConfig, command);
    }

    @Override
    public <T> T execute(CommandConfig config, Command<T> command) {
        return first.execute(config, command);
    }

}
