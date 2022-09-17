package com.hopehack.interlaken.common.msg;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/23 3:23 PM
 */
public enum CommandType {

    SINGLE_MESSAGE(1, ""),
    ;

    private int type;
    private String desc;
    CommandType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public static CommandType getByType(int type) {
        for (CommandType value : CommandType.values()) {
            if(type == value.getType()) {
                return value;
            }
        }
        return null;
    }
}
