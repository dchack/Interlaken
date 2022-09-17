package com.hopehack.interlaken;

import com.hopehack.interlaken.client.ClientConfig;
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
public class InterlakenClientApplication implements CommandLineRunner {

    @Autowired
    ClientConfig clientConfig;

    public static void main(String[] args) {
        SpringApplication.run(InterlakenClientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(clientConfig) ;
        Thread thread = new Thread(scanner);
        thread.setName("scanner-thread");
        thread.start();
    }
}
