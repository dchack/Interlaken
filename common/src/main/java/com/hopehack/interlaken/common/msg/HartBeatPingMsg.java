package com.hopehack.interlaken.common.msg;

import com.hopehack.interlaken.common.protobuf.Msg;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/24 11:34 PM
 */
public class HartBeatPingMsg {

    private static Msg hartBeatPingMsg = Msg.newBuilder().setType(Msg.Type.PING).build();

    public static Msg getMsg(){
        return hartBeatPingMsg;
    }
}
