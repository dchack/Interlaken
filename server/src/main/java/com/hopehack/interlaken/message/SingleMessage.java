package com.hopehack.interlaken.message;

import lombok.Data;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/20 9:11 PM
 */
@Data
public class SingleMessage extends Message{

    private String userId;

    private String receiverId;

    private String content;

    private int type;

}
