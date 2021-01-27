
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableCaching
@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.example"})
public class Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(Application.class, args);
    }
}
