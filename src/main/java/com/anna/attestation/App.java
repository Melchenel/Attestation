package com.anna.attestation;

import com.twilio.Twilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        Twilio.init("ACc76c5a11f7589784ebeaedffe30ebb75",
                "651cd1fea5ff92ebaa83b80305192872");
    }
}
