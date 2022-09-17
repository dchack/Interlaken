package com.hopehack.interlaken.client;

import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.channels.Channel;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/23 4:40 PM
 */
public final class Session {

    private static NioSocketChannel nioSocketChannel;

    public static void setChannel(NioSocketChannel channel) {
        nioSocketChannel = channel;
    }

    public static NioSocketChannel getChannel() {
        return nioSocketChannel;
    }
}
