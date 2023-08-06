package com.realitart.accountandmanager.share.mapping.configuration;


import com.realitart.accountandmanager.share.mapping.entity.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public UserMapper UserMapper() {
        return new UserMapper();
    }
}