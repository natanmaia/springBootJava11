package com.estudo.spring.configs;

import com.estudo.spring.services.db.DBServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBServiceTest dbServiceTest;

    @Bean
    public void criarBaseTeste(){
        this.dbServiceTest.criarBaseTeste();
    }
}
