package com.hopehack.interlaken.server;

import com.hopehack.interlaken.config.ServerProperties;
import com.hopehack.interlaken.data.EventProcessor;
import com.hopehack.interlaken.data.IdleReaderProcessor;
import com.hopehack.interlaken.init.InterlakenInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

/**
 * TODO
 *
 * @author hopehack
 * @Date 2022/6/12 10:58 AM
 */
@Slf4j
@Component
public class InterlakenServer {

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private IdleReaderProcessor idleReaderProcessor;

    @PostConstruct
    public void start() throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup(serverProperties.getBossEventLoopThreadCount());
        EventLoopGroup work = new NioEventLoopGroup(serverProperties.getWordEventLoopThreadCount());
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(serverProperties.getPort()))
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new InterlakenInitializer());

        ChannelFuture future = bootstrap.bind().sync();
        if (future.isSuccess()) {
            log.info("start Interlaken server success!!!");
        }

//        idleReaderProcessor.process(null);
    }


}
