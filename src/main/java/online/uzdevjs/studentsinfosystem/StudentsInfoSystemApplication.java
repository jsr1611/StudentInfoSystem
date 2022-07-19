package online.uzdevjs.studentsinfosystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student Info System API", version = "1.0", description = "X University Student Info System"))
public class StudentsInfoSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsInfoSystemApplication.class, args);
    }

}
