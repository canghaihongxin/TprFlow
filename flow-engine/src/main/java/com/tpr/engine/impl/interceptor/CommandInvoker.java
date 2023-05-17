package com.tpr.engine.impl.interceptor;

import com.tpr.engine.impl.context.Context;

/**
 * @author 田培融
 * 命令调度者 当程序执行到该类时 ,开始调度命令类的执行工作
 *
 * 因为此类 是拦截器链中的最后一个节点
 * 该类中不能设置下一个处理类 并且 getNext()永远为null
 *
 */
public class CommandInvoker extends AbstractCommandInterceptor {
    @Override
    public <T> T execute(CommandConfig config, Command<T> command) {
        /*
    首先获取CommandContext 对象  ,然后用command.execute()

     */
        // todo command.execute(Context.getCommandContext());
        return null;
    }
}
