package com.tpr.engine.impl.interceptor;

/**
 * @author Tom Baeyens
 * 命令拦截器
 * 在命令类执行之前 进行拦截器
 * 一个命令 可以有多个拦截器
 * 这一系列的拦截器最终构造成拦截器链 然后 依次调用
 */
public interface CommandInterceptor {

    <T> T execute(CommandConfig config, Command<T> command);

    void setNext(CommandInterceptor next);
}
