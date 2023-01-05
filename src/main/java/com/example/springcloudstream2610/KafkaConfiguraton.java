package com.example.springcloudstream2610;

import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfiguraton {

    @Bean
    ListenerContainerCustomizer<AbstractMessageListenerContainer<?, ?>> customizer() {
        return (container, destinationName, group) -> {
            final var backOff = new FixedBackOff();
            backOff.setMaxAttempts(3);
            container.setCommonErrorHandler(new DefaultErrorHandler(null, backOff));
        };
    }
}
