package com.hopehack.interlaken.message;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/20 9:08 PM
 */
public interface MessageSender {

    /**
     * 发送单个消息
     * @param message
     * @return
     */
    void send(SingleMessage message);

    /**
     *
     * @param message
     */
    void sendAll(SingleMessage message);
}
