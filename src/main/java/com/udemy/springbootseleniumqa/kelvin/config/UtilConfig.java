package com.udemy.springbootseleniumqa.kelvin.config;

import com.github.javafaker.Faker;
import com.udemy.springbootseleniumqa.kelvin.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class UtilConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }

}
