package com.example.buns.spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:myApp.properties")
//@Component("spring_introduction")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean(){
        return new Cat();
    }


    @Bean
    public Person personBean(){
        return new Person(catBean());
    }

}
