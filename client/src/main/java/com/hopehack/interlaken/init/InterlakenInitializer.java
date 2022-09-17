package com.hopehack.interlaken.init;

import com.hopehack.interlaken.common.protobuf.Msg;
import com.hopehack.interlaken.handler.MsgHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/12 11:49 AM
 */
public class InterlakenInitializer extends ChannelInitializer {


    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline()
        // TODO Configuration change
        .addLast(new IdleStateHandler(0, 5, 0))
          .addLast(new ProtobufVarint32FrameDecoder())
          .addLast(new ProtobufDecoder(Msg.getDefaultInstance()))
                //拆包编码
          .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new MsgHandler());

    }
}
