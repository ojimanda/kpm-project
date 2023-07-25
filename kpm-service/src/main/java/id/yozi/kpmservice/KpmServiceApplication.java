package id.yozi.kpmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KpmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KpmServiceApplication.class, args);
	}

}
