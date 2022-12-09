package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"controller", "service"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//CREACION DEL OBJETO: RestTemplate
	/*Da igual que nombre se le ponga a la funcion, la anotacion 
	 * @Bean delante de un metodo hace que spring llame a los metodos y 
	 * se los guarde al iniciarse -> Ya es inyectable.
	 * Tarea de configuracion.*/
	@Bean
	public RestTemplate crearTemplate() {
		return new RestTemplate();
	}
	
}
