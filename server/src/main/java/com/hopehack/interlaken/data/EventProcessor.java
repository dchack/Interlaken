package com.hopehack.interlaken.data;

import io.netty.channel.ChannelHandlerContext;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/20 1:45 PM
 */
public interface EventProcessor {

    /**
     * process event
     * @param context
     */
    void process(EventContext context);

}
