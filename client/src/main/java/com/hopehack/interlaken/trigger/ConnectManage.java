package com.hopehack.interlaken.trigger;

import com.hopehack.interlaken.client.InterlakenClient;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/26 11:57 PM
 */
@Component
public class ConnectManage {

    @Autowired
    private InterlakenClient interlakenClient;

    private void reConnect(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();

        if (!channel.isActive()) {
            try {
                interlakenClient.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
