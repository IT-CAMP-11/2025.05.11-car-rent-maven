package com.comarch.szkolenia.car.rent.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.comarch.szkolenia.car.rent.authentication",
        "com.comarch.szkolenia.car.rent.core",
        "com.comarch.szkolenia.car.rent.database",
        "com.comarch.szkolenia.car.rent.gui"
})
public class AppConfiguration {
}
