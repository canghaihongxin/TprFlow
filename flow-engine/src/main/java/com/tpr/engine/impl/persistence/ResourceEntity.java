package com.tpr.engine.impl.persistence;

import com.tpr.engine.impl.db.PersistentObject;

import java.io.Serializable;

/**
 * @author 田培融
 *
 * 此实体对应的表是 ACT_re_bytearray
 * 对应的实体是 ResourceEntity
 * 但是需要注意的是
 * identityService的api 可以给用户设置图片
 * 用到的类是 BytearrayEntity类
 * 他们是有区别的
 *
 * ByteArrayEntity 对应的数据有版本管理  而 ResourceEntity没有
 * ByteArrayEntity 会设置表表的 GENERATED_字段值
 * 而ByteArrayEntity 在进行保存时 ,该值为null
 *
 *
 */
public class ResourceEntity implements PersistentObject, Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;
    protected String name;
    protected byte[] bytes;
    protected String deploymentId;
    protected boolean generated = false;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Object getPersistentState() {
        return ResourceEntity.class;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    /**
     * Indicated whether or not the resource has been generated while deploying rather than
     * being actual part of the deployment.
     */
    public boolean isGenerated() {
        return generated;
    }

    // common methods  //////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "ResourceEntity[id=" + id + ", name=" + name + "]";
    }
}
