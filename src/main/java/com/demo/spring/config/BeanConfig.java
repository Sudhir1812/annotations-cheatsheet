package com.demo.spring.config;


import com.demo.spring.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }

}
