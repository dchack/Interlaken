package com.hopehack.interlaken.data;

import com.hopehack.interlaken.common.msg.HartBeatPingMsg;
import com.hopehack.interlaken.common.msg.HartBeatPongMsg;
import com.hopehack.interlaken.common.msg.MsgType;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/20 2:48 PM
 */
@Component
public class IdleWriterProcessor extends EventIntProcessor{

    @Override
    public void process(EventContext ctx) {
        ctx.getContext().channel().writeAndFlush(HartBeatPingMsg.getMsg());
    }
}
