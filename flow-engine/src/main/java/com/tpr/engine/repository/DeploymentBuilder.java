package com.tpr.engine.repository;

/**
 * 田培融
 * 部署构建器
 */
public interface DeploymentBuilder {

    /**
     * Gives the deployment the given name.
     * 设置部署名称   ACT_RE_DEPLOYMENT   的 name列
     */
    DeploymentBuilder name(String name);


    /**
     *  通过字符串的方式部署
    *        适用场景:
    *      流程文档的内容大部分是不变的,只有少部分属性在流程部署的时候需要跟外部进行交互从而动态填充
    *      eg:  开发人员适用图形化工具绘制流程文档, 有可能人员组织机构或者其他信息需要从DB中动态查询
    *      这时候就可以使用该方式结合模板引擎动态渲染数据, 常用的模板引擎有 ftl velocity 等
    *      然后生成预期的流程文档内容,
    *     该方式就是客户端自定义流程设计器与原生设计器的一种过渡方案
    *
    *        addString() 内部就是 调用 String的getBytes() 得到字节数组, 再将其放到部署对象的Map中
     * @param resourceName
     * @param text
     * @return
     */
    DeploymentBuilder addString(String resourceName, String text);



    /**
     * Deploys all provided sources to the Activiti engine.
     * 根据提供的部署方式进行资源的部署
     */
    Deployment deploy();

}
