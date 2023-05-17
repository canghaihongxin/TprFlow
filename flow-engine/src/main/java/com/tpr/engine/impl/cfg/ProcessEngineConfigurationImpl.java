package com.tpr.engine.impl.cfg;

import com.tpr.engine.ProcessEngine;
import com.tpr.engine.ProcessEngineConfiguration;
import com.tpr.engine.RepositoryService;
import com.tpr.engine.exception.TprException;
import com.tpr.engine.impl.ProcessEngineImpl;
import com.tpr.engine.impl.RepositoryServiceImpl;
import com.tpr.engine.impl.ServiceImpl;
import com.tpr.engine.impl.interceptor.CommandConfig;
import com.tpr.engine.impl.interceptor.CommandExecutor;
import com.tpr.engine.impl.interceptor.CommandInterceptor;
import com.tpr.engine.impl.interceptor.CommandInvoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 田培融
 * @desc 该抽象类继承 ProcessEngineConfiguration  负责创建一系列服务类实例对象,  流程引擎实例对象
 * 以及ProcessEngineImpl对象
 * 该类可以通过 流程引擎配置文件 交给Spring容器管理 或者使用编程方式动态构造
 */
public abstract class ProcessEngineConfigurationImpl extends ProcessEngineConfiguration {


    protected Map<Object, Object> beans;

    protected RepositoryService repositoryService = new RepositoryServiceImpl();

    protected CommandConfig defaultCommandConfig;
    /**
     * this will be initialized during the configurationComplete()
     */
    protected CommandExecutor commandExecutor;

    protected CommandInterceptor commandInvoker;


    protected List<CommandInterceptor> commandInterceptors;

    public ProcessEngine buildProcessEngine() {
        init();
        return new ProcessEngineImpl(this);
    }

    protected void init() {
       /* initConfigurators(); //初始化配置器
        configuratorsBeforeInit();//调用配置器的beforeinit()
        initProcessDiagramGenerator();//初始化流程图片生成器
        initHistoryLevel();//初始化历史记录归档级别
        initExpressionManager();//初始化表达式管理器
        initDataSource();//初始化数据源
        initVariableTypes();//初始化变量类型
        initBeans();//初始化可以管理bean
        initFormEngines();//初始化表单引擎
        initFormTypes();//初始化表单类型,
        initScriptingEngines();//初始化脚本引擎
        initClock();//初始化时间类 ,主要负责提供设置当前时间等
        initBusinessCalendarManager();//初始化日期管理器
        initCommandContextFactory();//初始化命令上下文工厂
        initTransactionContextFactory();//事务上下文工厂*/
        initCommandExecutors();//命令执行器
        initServices();//为各种服务类 比如respositoryService 设置命令执行器
      /*  initIdGenerator();//初始化id生成器
        initDeployers();//部署器
        initJobHandlers();//定时处理器
        initJobExecutor();//定时任务执行器
        initAsyncExecutor();//异步执行器
        initTransactionFactory();//事务工厂
        initSqlSessionFactory();//SqlSession工厂
        initSessionFactories();//session工厂
        initJpa();//JPA
        initDelegateInterceptor();//负责处理器拦截器默认实现类(拦截监听器或者表达式
        initEventHandlers();//事件处理类
        initFailedJobCommandFactory();//失败命令工厂
        initEventDispatcher();//事件转发器
        initProcessValidator();//BPMNMOdel 校验器
        initDatabaseEventLogging();//数据库事件记录
        configuratorsAfterInit();//调用配置器的configure()*/
    }
    protected void initCommandExecutors() {
/*        initDefaultCommandConfig();//默认命令配置信息
        initSchemaCommandConfig();//Schema命令配置信息
        initCommandInvoker();//命令调用者
      */
        initCommandInterceptors();  //命令拦截器
        initCommandExecutor();//命令执行器
    }


    /**
     *  初始化命令调度者
     */
    protected void initCommandInvoker() {
        if (commandInvoker==null) {
            commandInvoker = new CommandInvoker();
        }
    }

    /**
     * 初始化命令拦截器
     */
    protected void initCommandInterceptors() {
        if (commandInterceptors==null) {
            commandInterceptors = new ArrayList<CommandInterceptor>();
/*            if (customPreCommandInterceptors!=null) {
                commandInterceptors.addAll(customPreCommandInterceptors);
            }
            commandInterceptors.addAll(getDefaultCommandInterceptors());
            if (customPostCommandInterceptors!=null) {
                commandInterceptors.addAll(customPostCommandInterceptors);
            }*/
            //添加命令调用拦截器   commandInvoker 永远是拦截器链中的最后一个执行节点, 负责调度执行具体的命令类
            commandInterceptors.add(commandInvoker);
        }
    }



    /*
     * 命令拦截器初始化步骤
     * */
    protected void initCommandExecutor() {
        if (commandExecutor == null) { //
            //构造命令拦截器链
            CommandInterceptor first = initInterceptorChain(commandInterceptors);
          /*
          实例化命令拦截器
          根据命令配置对象 以及命令拦截器链中的第一个节点 实例化
          该类负责全局统筹命令拦截器的调用工作
           */
            commandExecutor = new CommandExecutorImpl(getDefaultCommandConfig(), first);
        }
    }

    /*
     *  将一系列的命令拦截器组装成链, 并返回链中的开始节点, 方便后续程序自上而下执行命令拦截器
     * */
    protected CommandInterceptor initInterceptorChain(List<CommandInterceptor> chain) {
        if (chain == null || chain.isEmpty()) { //非空校验
            //因为 如果命令拦截器集合为空 则必要的命令拦截器肯定缺失 ,不完整的命令拦截器链式无法使用的
            throw new TprException("invalid command interceptor chain configuration: " + chain);
        }
        for (int i = 0; i < chain.size() - 1; i++) {
            //循环链中的 chain参数结构为LinkedLIst,    有序的, 所以最终构造的命令拦截器链的节点熟悉怒 和节点 在chain
//      集合中的顺序是一致的, 命令拦截器链构造完毕之后, 第14行 直接从 chain集合中取出第一个元素作为该() 返回值
            chain.get(i).setNext(chain.get(i + 1));
        }
        return chain.get(0);
    }


    @Override
    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    protected void initServices() {
        //这一系列的服务类实例对象 都是通过 commadnExecutor 对象 作为属性值 注入进去的
        initService(repositoryService);
       /* initService(runtimeService);
        initService(historyService);
        initService(identityService);
        initService(taskService);
        initService(formService);
        initService(managementService);
        initService(dynamicBpmnService);*/
    }

    protected void initService(Object service) {
        //首先判断 service 对象是否是ServiceImpl 对象, 如果是 则执行后续操作
        if (service instanceof ServiceImpl) {
            //所以可以很方便的通过 任意一个服务类 对象获取CommandExecutor 对象
            ((ServiceImpl) service).setCommandExecutor(commandExecutor);
        }
    }

    public CommandConfig getDefaultCommandConfig() {
        return defaultCommandConfig;
    }


    public ProcessEngineConfigurationImpl setBeans(Map<Object, Object> beans) {
        this.beans = beans;
        return this;
    }

}
