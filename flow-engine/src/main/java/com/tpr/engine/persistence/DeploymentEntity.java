package com.tpr.engine.persistence;

import com.tpr.engine.impl.db.PersistentObject;
import com.tpr.engine.impl.persistence.ResourceEntity;
import com.tpr.engine.repository.Deployment;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DeploymentEntity implements Serializable, Deployment, PersistentObject {


    protected Map<String, ResourceEntity> resources; //resources是  是Map结构 key : 资源名称 value 是ResourceEntity 对象

    /**
     * 流程名称
     */
    protected String name;


    /**
     * 部署时间
     */
    protected Date deploymentTime;

    public void setName(String name) {
        this.name = name;
    }

    public void addResource(ResourceEntity resource) {
        //判断集合是否为空 如果为空将reources 对象添加到resources集合中
        if (resources==null) {
            //此为MAP 结构 key是资源名称 value 是  ResourceEntity 对象
            resources = new HashMap<String, ResourceEntity>();
        }
        resources.put(resource.getName(), resource);
    }


    public void setDeploymentTime(Date deploymentTime) {
        this.deploymentTime = deploymentTime;
    }

}
