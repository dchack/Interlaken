package com.hopehack.interlaken;

import com.hopehack.interlaken.message.MessageSender;
import com.hopehack.interlaken.scanner.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * service start from here
 *
 * @author dongchao
 * @Date 2022/6/12 11:03 AM
 */
@SpringBootApplication
public class InterlakenServerApplication implements CommandLineRunner {

    @Autowired
    MessageSender messageSender;

    public static void main(String[] args) {
        SpringApplication.run(InterlakenServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(messageSender) ;
        Thread thread = new Thread(scanner);
        thread.setName("scanner-thread");
        thread.start();
    }
}
