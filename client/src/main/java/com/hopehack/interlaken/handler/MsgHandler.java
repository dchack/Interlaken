package com.hopehack.interlaken.handler;

import com.hopehack.interlaken.common.msg.HartBeatPingMsg;
import com.hopehack.interlaken.common.msg.HartBeatPongMsg;
import com.hopehack.interlaken.common.msg.MsgType;
import com.hopehack.interlaken.common.protobuf.Msg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/13 11:21 PM
 */
@Slf4j
public class MsgHandler extends SimpleChannelInboundHandler<Msg> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Msg msg) throws Exception {
        if (msg.getType() == Msg.Type.PING) {
            ctx.writeAndFlush(HartBeatPongMsg.getMsg()).addListener((future) -> {
                if(future.isSuccess()) {
                    log.info("client writer idle send ping success");
                }
            });
        } else if (msg.getType() == Msg.Type.PONG) {
            log.info("client receive pong msg");
        } else if (msg.getType() == Msg.Type.MESSAGE) {
            String content = msg.getMessage().getContent();
            log.info("receive message : {}", content);
        }
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt ;

            if (idleStateEvent.state() == IdleState.WRITER_IDLE){
                ctx.writeAndFlush(HartBeatPingMsg.getMsg()).addListener((future) -> {
                    if (future.isSuccess()) {
                        log.info("client writer idle send ping success");
                    }
                });
            }
        }

        super.userEventTriggered(ctx, evt);
    }
}
