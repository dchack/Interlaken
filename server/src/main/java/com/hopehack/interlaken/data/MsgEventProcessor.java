package com.hopehack.interlaken.data;

import com.hopehack.interlaken.common.msg.CommandType;
import com.hopehack.interlaken.common.protobuf.Msg;
import com.hopehack.interlaken.message.MessageSender;
import com.hopehack.interlaken.message.SingleMessage;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/23 3:13 PM
 */
@Component
public class MsgEventProcessor extends EventIntProcessor{

    @Autowired
    private MessageSender messageSender;

    @Override
    public void process(EventContext context) {
        Msg msg = context.getMsg();
        Msg.Message message = msg.getMessage();
        CommandType commandType = CommandType.getByType(msg.getMessage().getType());
        if (commandType == null) {
            return;
        }
        Channel channel = context.getContext().channel();

        switch (commandType) {
            case SINGLE_MESSAGE:
                SingleMessage singleMessage = new SingleMessage();
//                singleMessage.setUserId(message.get());
                singleMessage.setContent(message.getContent());
                singleMessage.setReceiverId(message.getTarget());
                messageSender.send(singleMessage);
                break;
            default:
                return;
        }

    }
}
