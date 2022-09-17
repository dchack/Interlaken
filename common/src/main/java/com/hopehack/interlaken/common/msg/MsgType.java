package com.hopehack.interlaken.common.msg;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/6/24 11:36 PM
 */
public enum MsgType {
    LOGIN(1, ""),
    LOGIN_OUT(2, ""),
    HART_BEAT_PING(3, ""),
    HART_BEAT_PONG(4, "")
    ;

    private int type;
    private String desc;
    MsgType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public MsgType getByType(int type) {
        for (MsgType value : MsgType.values()) {
            if(type == value.getType()) {
                return value;
            }
        }
        return null;
    }
}
