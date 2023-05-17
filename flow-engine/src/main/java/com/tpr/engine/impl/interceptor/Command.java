package com.tpr.engine.impl.interceptor;


/**
 * @author 田培融
 * 命令接口  所有的命令类都需要实现该接口
 */
public interface Command<T> {

    T execute(CommandContext commandContext);

}
