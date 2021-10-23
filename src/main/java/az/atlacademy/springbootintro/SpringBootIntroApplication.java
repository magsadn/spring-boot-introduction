package az.atlacademy.springbootintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
//@Controller -- eger Rest yox sadece controller yazsaq onda asagida Getmapping-den sonra ResponseBody yazmaliyiq
public class SpringBootIntroApplication {

/* Lesson_52
    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @GetMapping("/hello")
    //@ResponseBody
    public String getHello(){
        return "Hello World!";
    }

    @GetMapping("/now")
    public String getNow(){
        String localDateTime = LocalDateTime.now().toString();
        return String.format("<h1>%s</h1>",localDateTime);
    }*/

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootIntroApplication.class, args);
        //displayAllBeans(context);
    }

    public static void displayAllBeans(ConfigurableApplicationContext context){
        String[] allBeanNames = context.getBeanDefinitionNames();
        for (String beanName : allBeanNames){
            System.out.println(beanName);
        }
    }




}
