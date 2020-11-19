package com.pm.course.config;

import com.pm.course.util.ApiRetriever;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ApiRetriever getApiRetriever(){
        return new ApiRetriever();
    }

}
