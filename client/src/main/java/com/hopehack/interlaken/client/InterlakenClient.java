package com.hopehack.interlaken.client;

import com.hopehack.interlaken.common.protobuf.Msg;
import com.hopehack.interlaken.init.InterlakenInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * TODO
 *
 * @author hopehack
 * @Date 2022/6/12 10:58 AM
 */
@Slf4j
@Component
public class InterlakenClient {

    @Autowired
    private ClientConfig clientConfig;

    @PostConstruct
    public void start() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup g = new NioEventLoopGroup(1);
        bootstrap.group(g).channel(NioSocketChannel.class)
                .handler(new InterlakenInitializer());

        ChannelFuture future = null;
        try {
            future = bootstrap.connect("localhost", 8082).sync();
            NioSocketChannel channel = (NioSocketChannel) future.channel();
            Msg.Login loginMsg = Msg.Login.newBuilder().setUserId(clientConfig.getUserId())
                    .setAppVersion("102")
                    .setOsVersion("Android")
                    .build();
            channel.writeAndFlush(Msg.newBuilder().setType(Msg.Type.LOGIN).setLogin(loginMsg).build());
            Session.setChannel(channel);
        }finally {

        }

    }
}
