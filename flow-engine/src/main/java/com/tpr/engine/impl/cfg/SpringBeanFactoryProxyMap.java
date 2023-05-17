package com.tpr.engine.impl.cfg;

import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/**
 * @author 田培融
 * @desc
 *  该类实现了Map接口 ,其内部持有BeanFactory对象, 主要是用于获取配置文件中定义的bean实例对象
 *  所以开发人员只要能够获取到SpringBeanFactoryProxyMap 对象 就可以获取到
 *  流程配置文件中定义的所有bean实例对象 Activtii 这样设计很精巧,
 *
 *  将SpringBeanFactoryProxyMap对象设置到 processEngineConfiguration 中
 *  因此只要能够获取processEngineConfiguration对象
 *  就可以通过该对象的getBeans()  获取 流程配置文件中定义的所有bena实例对象 不过由于这个地方
 *  Activiti使用的是map结构, 因此需要类型转换
 *
 */
public class SpringBeanFactoryProxyMap implements Map<Object, Object> {

    protected BeanFactory beanFactory;

    public SpringBeanFactoryProxyMap(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<?, ?> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Object> keySet() {
        return null;
    }

    @Override
    public Collection<Object> values() {
        return null;
    }

    @Override
    public Set<Entry<Object, Object>> entrySet() {
        return null;
    }
}
