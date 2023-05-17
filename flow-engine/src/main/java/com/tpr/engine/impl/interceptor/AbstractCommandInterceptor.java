package com.tpr.engine.impl.interceptor;

/**
 * @author Tom Baeyens
 * 对 CommandInterceptor中的()进行实现   模板类
 */
public abstract class AbstractCommandInterceptor implements CommandInterceptor {

    /** will be initialized by the {@link com.tpr.engine.ProcessEngineConfiguration ProcessEngineConfiguration} */
    protected CommandInterceptor next;



    @Override
    public void setNext(CommandInterceptor next) {
        this.next = next;
    }
}
