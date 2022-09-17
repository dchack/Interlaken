package com.hopehack.interlaken.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/23 4:23 PM
 */
@ConfigurationProperties(prefix = "client")
@Configuration
@Data
public class ClientConfig {

    private String userId;

    private String target;

}
