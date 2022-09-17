package com.hopehack.interlaken.message;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/21 10:21 PM
 */
public enum MessageTypeEnum {

    TEXT(1, "文本");

    private int type;
    private String desc;

    MessageTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
