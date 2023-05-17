package com.tpr.engine;

/** Helper for initializing and closing process engines in server environments.
 * <br>
 * All created {@link ProcessEngine}s will be registered with this class.
 * <br>
 * The activiti-webapp-init webapp will
 * call the {@link #init()} method when the webapp is deployed and it will call the
 * {@link #destroy()} method when the webapp is destroyed, using a context-listener
 * (<code>org.activiti.impl.servlet.listener.ProcessEnginesServletContextListener</code>).  That way,
 * all applications can just use the {@link #getProcessEngines()} to
 * obtain pre-initialized and cached process engines. <br>
 * <br>
 * Please note that there is <b>no lazy initialization</b> of process engines, so make sure the
 * context-listener is configured or {@link ProcessEngine}s are already created so they were registered
 * on this class.<br>
 * <br>
 * The {@link #init()} method will try to build one {@link ProcessEngine} for
 * each activiti.cfg.xml file found on the classpath.  If you have more then one,
 * make sure you specify different process.engine.name values.
 *
 * @author 田培融

 * @desc  该类负责管理所有的流程引擎  ProcessEngine 集合 ,并负责流程引擎实例对象的注册 ,获取 注销等操作
 *
 */
public  abstract class ProcessEngines {

    public static final String NAME_DEFAULT = "default"; //流程引擎默认的名称

}
