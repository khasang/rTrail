package io.khasang.rtrail.config;

import io.khasang.rtrail.model.Message;
import io.khasang.rtrail.model.impl.MessageImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Message message(){
        return new MessageImpl("HelloWorld!");
    }

}
