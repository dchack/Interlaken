package com.hopehack.interlaken.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/12 11:12 AM
 */
@Getter
@Setter
@Configuration
public class ServerProperties {

    /**
     * netty server bind port
     */
    @Value("${port:8082}")
    private int port;

    /**
     * boss event loop thread count
     */
    @Value("${bossEventLoopThreadCount:1}")
    private int bossEventLoopThreadCount;

    /**
     * work event loop thread count
     */
    @Value("${wordEventLoopThreadCount:1}")
    private int wordEventLoopThreadCount;

}
