package com.hopehack.interlaken.init;

import com.hopehack.interlaken.common.protobuf.Msg;
import com.hopehack.interlaken.handler.HartBeatHandler;
import com.hopehack.interlaken.handler.MsgHandler;
import io.netty.channel.Channel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;


/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/12 11:49 AM
 */
public class InterlakenInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        // TODO Configuration change
        pipeline.addLast(new HartBeatHandler(10, 5, 0))
         .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(Msg.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new MsgHandler());
    }
}
