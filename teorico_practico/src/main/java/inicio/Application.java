package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;



@EntityScan(basePackages = {"model"})
@ComponentScan(basePackages = {"controller","service","dao"})
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/* Activa la libreria Ribbon para acceder al servicio utilizando eureka y zuul*/
	@LoadBalanced
	@Bean	
	public RestTemplate crearTemplate() {
		BasicAuthenticationInterceptor interceptor  = new BasicAuthenticationInterceptor("admin", "admin");
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getInterceptors().add(interceptor);
		
		return restTemplate;
	}
}
