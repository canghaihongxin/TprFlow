package com.tpr.engine;
/**
 * Interface implemented by all classes that expose the Activiti services.
 *
 * @author Joram Barrez
 * @desc 该接口中定义了获取各种服务实例对象的方法
 */
public interface EngineServices {


    //操作 流程定义的()      存储 流程图,  web 流程设计器
    RepositoryService getRepositoryService();


}
