package com.hopehack.interlaken.handler;

import com.hopehack.interlaken.data.EventContext;
import com.hopehack.interlaken.data.IdleReaderProcessor;
import com.hopehack.interlaken.data.IdleWriterProcessor;
import com.hopehack.interlaken.spring.SpringBeanSupport;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/13 11:21 PM
 */
@Slf4j
public class HartBeatHandler extends IdleStateHandler {

    public HartBeatHandler(int readerIdleTimeSeconds, int writerIdleTimeSeconds, int allIdleTimeSeconds) {
        super(readerIdleTimeSeconds, writerIdleTimeSeconds, allIdleTimeSeconds);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        if (evt.state() == IdleState.READER_IDLE) {
            SpringBeanSupport.getBean(IdleReaderProcessor.class).process(new EventContext(ctx));
        } else if (evt.state() == IdleState.WRITER_IDLE) {
            SpringBeanSupport.getBean(IdleWriterProcessor.class).process(new EventContext(ctx));
        }

        super.channelIdle(ctx, evt);
    }


}
