package com.hopehack.interlaken.session;

import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/14 10:46 PM
 */
public class SessionContainer {

    private static final ConcurrentHashMap<String, NioSocketChannel> sessionMap = new ConcurrentHashMap<>();

    public static void put(String uId, NioSocketChannel channel) {
        sessionMap.put(uId, channel);
    }

    public static void remove(String uId) {
        sessionMap.remove(uId);
    }

    public static NioSocketChannel get(String uId) {
        return sessionMap.get(uId);
    }

    public static List<NioSocketChannel> getAll() {
        return new ArrayList<>(sessionMap.values());
    }

    public static void remove(NioSocketChannel channel) {
        sessionMap.entrySet().stream().filter(entry -> entry.getValue() == channel)
                .forEach(entry -> sessionMap.remove(entry.getKey()));
    }

}
