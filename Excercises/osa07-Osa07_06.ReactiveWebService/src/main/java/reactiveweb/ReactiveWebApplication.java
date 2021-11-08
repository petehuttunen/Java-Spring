package reactiveweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveWebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
        SpringApplication.run(ReactiveWebApplication.class, args);
        
        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        
        System.out.println(">> message = " +greetingClient.getMessage().block());
    }
}
