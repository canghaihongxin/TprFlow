package com.tpr.engine;

import com.tpr.engine.impl.cfg.BeansConfigurationHelper;
import com.tpr.engine.runtime.Clock;

/**
 * Configuration information from which a process engine can be build.
 *
 * <p>Most common is to create a process engine based on the default configuration file:
 * <pre>ProcessEngine processEngine = ProcessEngineConfiguration
 *   .createProcessEngineConfigurationFromResourceDefault()
 *   .buildProcessEngine();
 * </pre>
 * </p>
 *
 * <p>To create a process engine programatic, without a configuration file,
 * the first option is {@link #createStandaloneProcessEngineConfiguration()}
 * <pre>ProcessEngine processEngine = ProcessEngineConfiguration
 *   .createStandaloneProcessEngineConfiguration()
 *   .buildProcessEngine();
 * </pre>
 * This creates a new process engine with all the defaults to connect to
 * a remote h2 database (jdbc:h2:tcp://localhost/activiti) in standalone
 * mode.  Standalone mode means that Activiti will manage the transactions
 * on the JDBC connections that it creates.  One transaction per
 * service method.
 * For a description of how to write the configuration files, see the
 * userguide.
 * </p>
 *
 * <p>The second option is great for testing: {@link #createStandalonInMemeProcessEngineConfiguration()}
 * <pre>ProcessEngine processEngine = ProcessEngineConfiguration
 *   .createStandaloneInMemProcessEngineConfiguration()
 *   .buildProcessEngine();
 * </pre>
 * This creates a new process engine with all the defaults to connect to
 * an memory h2 database (jdbc:h2:tcp://localhost/activiti) in standalone
 * mode.  The DB schema strategy default is in this case <code>create-drop</code>.
 * Standalone mode means that Activiti will manage the transactions
 * on the JDBC connections that it creates.  One transaction per
 * service method.
 * </p>
 *
 * <p>On all forms of creating a process engine, you can first customize the configuration
 * before calling the {@link #buildProcessEngine()} method by calling any of the
 * setters like this:
 * <pre>ProcessEngine processEngine = ProcessEngineConfiguration
 *   .createProcessEngineConfigurationFromResourceDefault()
 *   .setMailServerHost("gmail.com")
 *   .setJdbcUsername("mickey")
 *   .setJdbcPassword("mouse")
 *   .buildProcessEngine();
 * </pre>
 * </p>
 *
 * @author 田培融
 * @desc 该抽象类实现 EngineServices 接口 提供了一系列创建流程引擎配置类  ProcessEngineConfiguration 对象的()
 * <p>
 * <p>
 * <p>
 * 该类中提供了一系列创建流程引擎配置类 实例对象的静态() 从而方便客户端获取流程引擎实例对象
 * 而无需关心内部实现细节
 * 疑问:
 * 这个类中  很多 () 都是创建 ProcessEngineConfiguration 对象 并没有提供构造 ProcessEngine 对象的()
 * 因为只要能够 获取  ProcessEngineConfiguration 对象 就可以直接调用该对象的 buildProcessEngine() 创建ProcessEngine实例
 * @see ProcessEngines
 */
public abstract class ProcessEngineConfiguration implements EngineServices {



    protected Clock clock;


    protected String processEngineName = ProcessEngines.NAME_DEFAULT;

    protected ProcessEngineConfiguration() {
    }
    /*
     * 此（）用于创建 ProcessEngine 对象  因为activiti.cfg.xml配置文件中定义的流程引擎配置类为
     * StaddaloneProcessEngineConfiguration ,但是该类中并没有定义 buildProcessEngine
     * 那么 此() 肯定在其父类中进行了实现
     * */
    public abstract ProcessEngine buildProcessEngine();


    public Clock getClock() {
        return clock;
    }


    public String getProcessEngineName() {
        return processEngineName;
    }

    /*
 xml文件名可以自定义
 beanName为 processEngineConfiguration 对应配置文件中 流程引擎配置类bean的id值
  */
    public static ProcessEngineConfiguration createProcessEngineConfigurationFromResource(String resource) {
        return createProcessEngineConfigurationFromResource(resource, "processEngineConfiguration");
    }

    /*
  两个 参数都可以自定义
 */
    public static ProcessEngineConfiguration createProcessEngineConfigurationFromResource(String resource, String beanName) {
        return BeansConfigurationHelper.parseProcessEngineConfigurationFromResource(resource, beanName);
    }
}
