package com.hopehack.interlaken.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/23 5:18 PM
 */
@Component
public class SpringBeanSupport implements ApplicationContextAware {

    private static ApplicationContext context;

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
