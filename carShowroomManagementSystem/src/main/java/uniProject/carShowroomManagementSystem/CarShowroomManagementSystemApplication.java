package uniProject.carShowroomManagementSystem;//bu temel paket

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CarShowroomManagementSystemApplication {

	//disaridan argumanlar verebilirsin, serverPort( noktali propertyleri vs.. verebilirsin) 
	public static void main(String[] args) {
		//uygulama ayağa kaldırma:
		SpringApplication.run(CarShowroomManagementSystemApplication.class, args);
		//CarShowroomManagementSystemApplication.class --> spring benim class path imi aramaya baslayacak
		//CarShowroomManagementSystemApplication.class tum ust class lari tarar
		//spring e: class pati taradığında entire class ın budur
		//uniProject.carShowroomManagementSystem ın(base package) altında kaç sınıf varsa hepsini tarayacak
		
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

}
