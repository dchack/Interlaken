package com.hopehack.interlaken.data;

import com.hopehack.interlaken.common.protobuf.Msg;
import io.netty.channel.ChannelHandlerContext;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/23 3:06 PM
 */
public class EventContext {

    private ChannelHandlerContext context;

    private Msg msg;

    public EventContext(ChannelHandlerContext context, Msg msg) {
        this.context = context;
        this.msg = msg;
    }

    public EventContext(ChannelHandlerContext context) {
        this.context = context;
    }

    public ChannelHandlerContext getContext() {
        return context;
    }

    public Msg getMsg() {
        return msg;
    }
}
