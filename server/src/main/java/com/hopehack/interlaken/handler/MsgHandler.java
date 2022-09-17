package com.hopehack.interlaken.handler;

import com.hopehack.interlaken.common.msg.MsgType;
import com.hopehack.interlaken.common.msg.HartBeatPongMsg;
import com.hopehack.interlaken.common.protobuf.Msg;
import com.hopehack.interlaken.data.EventContext;
import com.hopehack.interlaken.data.IdleWriterProcessor;
import com.hopehack.interlaken.data.MsgEventProcessor;
import com.hopehack.interlaken.session.SessionContainer;
import com.hopehack.interlaken.spring.SpringBeanSupport;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/24 11:28 PM
 */
public class MsgHandler extends SimpleChannelInboundHandler<Msg> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Msg msg) {
        if (msg.getType() == Msg.Type.PING) {
            ctx.channel().writeAndFlush(HartBeatPongMsg.getMsg());
        } else if (msg.getType() == Msg.Type.LOGIN) {
            Msg.Login body = msg.getLogin();
            String uId = body.getUserId();
            SessionContainer.put(uId, (NioSocketChannel) ctx.channel());
        } else if (msg.getType() == Msg.Type.LOGINOUT) {
            Msg.LoginOut body = msg.getLoginOut();
            String uId = body.getUserId();
            SessionContainer.remove(uId);
        } else if (msg.getType() == Msg.Type.MESSAGE) {
            SpringBeanSupport.getBean(MsgEventProcessor.class).process(new EventContext(ctx, msg));
        }
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionContainer.remove((NioSocketChannel) ctx.channel());
        ctx.channel().close();
    }
}
