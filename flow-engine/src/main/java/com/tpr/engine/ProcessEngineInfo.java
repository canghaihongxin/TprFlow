package com.tpr.engine;
/**
 * Represents information about the initialization of the process engine.
 *
 * @see ProcessEngines
 * @author 田培融
 */
public interface ProcessEngineInfo {

    /**
     * Returns the name of the process engine.
     */
    String getName();

    /**
     * Returns the resources the engine was configured from.
     */
    String getResourceUrl();

    /**
     * Returns the exception stacktrace in case an exception occurred while initializing
     * the engine. When no exception occured, null is returned.
     */
    String getException();
}
