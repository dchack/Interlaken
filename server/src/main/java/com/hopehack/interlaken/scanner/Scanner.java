package com.hopehack.interlaken.scanner;

import com.hopehack.interlaken.message.MessageSender;
import com.hopehack.interlaken.message.SingleMessage;

/**
 * TODO
 *
 * @author dongchao
 * @Date 2022/7/21 10:30 PM
 */
public class Scanner implements Runnable {

    MessageSender messageSender = null;

    public Scanner(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void run() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();
            SingleMessage singleMessage = new SingleMessage();
            singleMessage.setUserId("2022");
            singleMessage.setContent(msg);
            messageSender.send(singleMessage);
        }
    }
}
