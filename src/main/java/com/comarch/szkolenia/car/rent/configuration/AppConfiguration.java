package com.comarch.szkolenia.car.rent.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = {
        "com.comarch.szkolenia.car.rent.authentication",
        "com.comarch.szkolenia.car.rent.core",
        "com.comarch.szkolenia.car.rent.database",
        "com.comarch.szkolenia.car.rent.gui"
})
//@ImportResource("beans.xml")
public class AppConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
