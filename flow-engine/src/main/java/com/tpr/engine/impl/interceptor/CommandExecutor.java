package com.tpr.engine.impl.interceptor;

public interface CommandExecutor {

    <T> T execute(Command<T> command);


    /**
     * Execute a command with the specified {@link CommandConfig}.
     */
    <T> T execute(CommandConfig config, Command<T> command);
}
