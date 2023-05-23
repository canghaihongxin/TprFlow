/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tpr.engine.util;

import com.tpr.engine.exception.TprException;
import com.tpr.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.tpr.engine.impl.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;


/**
 * @author Tom Baeyens
 */
public abstract class ReflectUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ReflectUtil.class);

    private static final Pattern GETTER_PATTERN = Pattern.compile("(get|is)[A-Z].*");
    private static final Pattern SETTER_PATTERN = Pattern.compile("set[A-Z].*");


    public static ClassLoader getClassLoader() {
        ClassLoader loader = getCustomClassLoader();
        if (loader == null) {
            loader = Thread.currentThread().getContextClassLoader();
        }
        return loader;
    }

    private static ClassLoader getCustomClassLoader() {
        ProcessEngineConfigurationImpl processEngineConfiguration = Context.getProcessEngineConfiguration();
        if (processEngineConfiguration != null) {
            final ClassLoader classLoader = processEngineConfiguration.getClassLoader();
            if (classLoader != null) {
                return classLoader;
            }
        }
        return null;
    }


    public static Class<?> loadClass(String className) {
        Class<?> clazz = null;
        ClassLoader classLoader = getCustomClassLoader();

        // First exception in chain of classloaders will be used as cause when no class is found in any of them
        Throwable throwable = null;

        if(classLoader != null) {
            try {
                LOG.trace("Trying to load class with custom classloader: {}", className);
                clazz = loadClass(classLoader, className);
            } catch(Throwable t) {
                throwable = t;
            }
        }
        if(clazz == null) {
            try {
                LOG.trace("Trying to load class with current thread context classloader: {}", className);
                clazz = loadClass(Thread.currentThread().getContextClassLoader(), className);
            } catch(Throwable t) {
                if(throwable == null) {
                    throwable = t;
                }
            }
            if(clazz == null) {
                try {
                    LOG.trace("Trying to load class with local classloader: {}", className);
                    clazz = loadClass(ReflectUtil.class.getClassLoader(), className);
                } catch(Throwable t) {
                    if(throwable == null) {
                        throwable = t;
                    }
                }
            }
        }

        if(clazz == null) {
            throw new TprException(className, throwable);
        }
        return clazz;
    }


    private static Class loadClass(ClassLoader classLoader, String className) throws ClassNotFoundException {
        ProcessEngineConfigurationImpl processEngineConfiguration = Context.getProcessEngineConfiguration();
        boolean useClassForName = processEngineConfiguration == null ||
                processEngineConfiguration.isUseClassForNameClassLoading();
        return useClassForName ? Class.forName(className, true, classLoader) : classLoader.loadClass(className);
    }
}
