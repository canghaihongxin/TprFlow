package com.tpr.engine.impl.context;

import com.tpr.engine.impl.cfg.ProcessEngineConfigurationImpl;

import java.util.Stack;

public class Context {
    protected static ThreadLocal<Stack<ExecutionContext>> executionContextStackThreadLocal = new ThreadLocal<Stack<ExecutionContext>>();

    protected static ThreadLocal<Stack<ProcessEngineConfigurationImpl>> processEngineConfigurationStackThreadLocal = new ThreadLocal<Stack<ProcessEngineConfigurationImpl>>();
    public static ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        Stack<ProcessEngineConfigurationImpl> stack = getStack(processEngineConfigurationStackThreadLocal);
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }



    protected static <T> Stack<T> getStack(ThreadLocal<Stack<T>> threadLocal) {
        Stack<T> stack = threadLocal.get(); //首先从集合中获取
        if (stack==null) {//如果当前线程不存在元素
            stack = new Stack<T>();//实例化栈 并将其设置到threadLocal集合中
            threadLocal.set(stack);
        }
        return stack;
    }
}
