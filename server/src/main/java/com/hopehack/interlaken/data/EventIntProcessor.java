package com.hopehack.interlaken.data;

import org.springframework.beans.factory.InitializingBean;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/20 2:00 PM
 */
public abstract class EventIntProcessor implements EventProcessor, InitializingBean {

    private EventProcessor eventProcessor;

    @Override
    public void afterPropertiesSet() {
        eventProcessor = this;
    }

    public EventProcessor get() {
        return eventProcessor;
    }
}
