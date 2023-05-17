package com.tpr.engine.impl.repository;

import com.tpr.engine.exception.TprException;
import com.tpr.engine.exception.TprIllegalArgumentException;
import com.tpr.engine.impl.RepositoryServiceImpl;
import com.tpr.engine.impl.persistence.ResourceEntity;
import com.tpr.engine.persistence.DeploymentEntity;
import com.tpr.engine.repository.Deployment;
import com.tpr.engine.repository.DeploymentBuilder;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * @author 田培融
 */
public class DeploymentBuilderImpl implements DeploymentBuilder, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String DEFAULT_ENCODING = "UTF-8";

    protected transient RepositoryServiceImpl repositoryService;


    protected DeploymentEntity deployment = new DeploymentEntity();

    public DeploymentBuilderImpl(RepositoryServiceImpl repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Override
    public DeploymentBuilder name(String name) {
        deployment.setName(name);
        return this;
    }

    @Override
    public DeploymentBuilder addString(String resourceName, String text) {

        if (text==null) {
            throw new TprIllegalArgumentException("text is null");
        }
        ResourceEntity resource = new ResourceEntity();
        resource.setName(resourceName);

        try {
            resource.setBytes(text.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new TprException("Unable to get process bytes.  请检查是否为UTF-8格式", e);
        }
        deployment.addResource(resource);
        return this;
    }


    public Deployment deploy() {
        return repositoryService.deploy(this);
    }

    public DeploymentEntity getDeployment() {
        return deployment;
    }
}
