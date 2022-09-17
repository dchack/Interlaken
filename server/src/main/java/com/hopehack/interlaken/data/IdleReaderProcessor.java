package com.hopehack.interlaken.data;

import com.hopehack.interlaken.session.SessionContainer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/20 2:48 PM
 */
@Component
public class IdleReaderProcessor extends EventIntProcessor{

    @Override
    public void process(EventContext ctx) {
        // todo remove more user info
        ChannelHandlerContext channelHandlerContext = ctx.getContext();
        Channel channel = channelHandlerContext.channel();
        SessionContainer.remove((NioSocketChannel) channel);
        channel.close();
    }
}
