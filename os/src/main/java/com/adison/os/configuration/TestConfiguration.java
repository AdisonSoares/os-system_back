package com.adison.os.configuration;

import com.adison.os.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
    @Autowired
    private DBService dbService;
    @Bean
    public Void instanciaDB(){
        this.dbService.instanciaDB();
        return null;
    }
}
