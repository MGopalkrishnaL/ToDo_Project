package com.Geekster.ToDo_Project.config;

import com.Geekster.ToDo_Project.util.TodoUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    public TodoUtils todoUtils(){
        return new TodoUtils();
    }

}
