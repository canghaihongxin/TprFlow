package com.tpr.engine.impl;

import com.tpr.engine.ProcessEngineInfo;

import java.io.Serializable;

/**
 * 田培融
 */
public class ProcessEngineInfoImpl implements Serializable, ProcessEngineInfo {

    private static final long serialVersionUID = 1L;

    String name;
    String resourceUrl;
    String exception;

    public ProcessEngineInfoImpl(String name, String resourceUrl, String exception) {
        this.name = name;
        this.resourceUrl = resourceUrl;
        this.exception = exception;
    }

    public String getName() {
        return name;
    }
    public String getResourceUrl() {
        return resourceUrl;
    }
    public String getException() {
        return exception;
    }
}
