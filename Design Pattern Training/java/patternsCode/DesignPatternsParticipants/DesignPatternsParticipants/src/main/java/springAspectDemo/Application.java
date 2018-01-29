package springAspectDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void mainForSpringAspectDemo (String[] args) {
    	ApplicationContext ctx = SpringApplication.run(Application.class, args);
    	Cache c = ctx.getBean(Cache.class);
    	c.setCacheSize(1);
    }
}
