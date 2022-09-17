package com.hopehack.interlaken.message.impl;

import com.hopehack.interlaken.common.protobuf.Msg;
import com.hopehack.interlaken.message.MessageSender;
import com.hopehack.interlaken.message.SingleMessage;
import com.hopehack.interlaken.session.SessionContainer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/20 9:13 PM
 */
@Service
public class MessageSenderImpl implements MessageSender {


    @Override
    public void send(SingleMessage message) {
        NioSocketChannel channel = SessionContainer.get(message.getReceiverId());
        if (channel != null) {
            Msg.Message msg = Msg.Message.newBuilder().setContent(message.getContent())
//                    .setTarget("2022")
                    .build();
            channel.writeAndFlush(Msg.newBuilder().setType(Msg.Type.MESSAGE).setMessage(msg).build());
        }

    }

    @Override
    public void sendAll(SingleMessage message) {
        List<NioSocketChannel> allChannel = SessionContainer.getAll();
        for (NioSocketChannel channel : allChannel) {
            Msg.Message msg = Msg.Message.newBuilder().setContent(message.getContent())
                    .build();
            channel.writeAndFlush(Msg.newBuilder().setType(Msg.Type.MESSAGE).setMessage(msg).build());
        }
    }
}
