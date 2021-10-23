package az.atlacademy.springbootintro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyTestClass myTestClass(){
        return new MyTestClass();
    }
}
