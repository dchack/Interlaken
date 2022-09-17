package com.hopehack.interlaken.common.msg;

import com.hopehack.interlaken.common.protobuf.Msg;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/24 11:34 PM
 */
public class HartBeatPongMsg {

    private static Msg hartBeatPongMsg = Msg.newBuilder().setType(Msg.Type.PONG).build();

    public static Msg getMsg(){
        return hartBeatPongMsg;
    }
}
