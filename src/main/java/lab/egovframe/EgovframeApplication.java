package lab.egovframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EgovframeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgovframeApplication.class, args);
	}

}
