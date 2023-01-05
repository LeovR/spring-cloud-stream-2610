package com.example.springcloudstream2610;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class BodyConsumer {

    @Bean
    public Consumer<Message<Body>> messageConsumer() {
        return message -> {
            throw new RuntimeException("Original exception");
        };
    }
}
