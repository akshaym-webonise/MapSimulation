package com.webonise.config;

import com.webonise.controllers.MainScreenController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.webonise")
public class AppConfig {
    @Bean
    public MainScreenController mainScreenController() {
        return new MainScreenController();
    }
}
