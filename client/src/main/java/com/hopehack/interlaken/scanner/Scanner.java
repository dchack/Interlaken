package com.hopehack.interlaken.scanner;

import com.hopehack.interlaken.client.ClientConfig;
import com.hopehack.interlaken.client.Session;
import com.hopehack.interlaken.common.msg.CommandType;
import com.hopehack.interlaken.common.protobuf.Msg;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/21 10:30 PM
 */
public class Scanner implements Runnable {

    private ClientConfig clientConfig;

    public Scanner(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    @Override
    public void run() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();

            NioSocketChannel channel = Session.getChannel();

            Msg.Message message = Msg.Message.newBuilder().setTarget(clientConfig.getTarget())
                    .setContent(msg)
                    .setType(CommandType.SINGLE_MESSAGE.getType())
                    .build();
            channel.writeAndFlush(Msg.newBuilder().setType(Msg.Type.MESSAGE).setMessage(message).build());
        }
    }
}
