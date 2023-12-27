package com.adison.os.configuration;

import com.adison.os.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("developer")
public class DeveloperConfiguration {
    @Autowired
    private DBService dbService;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;
    @Bean
    public Void instanciaDB(){
        if (ddl.equals("create")){
            this.dbService.instanciaDB();
        }
        return null;
    }
}
