package com.tp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Modemapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
