package team444.funcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FunCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunCourseApplication.class, args);
    }

}
