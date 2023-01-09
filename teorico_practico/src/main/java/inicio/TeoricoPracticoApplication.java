package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


// @EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TeoricoPracticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeoricoPracticoApplication.class, args);
	}

}
