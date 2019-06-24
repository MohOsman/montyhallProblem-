package com.tele2.montyhall;

import com.tele2.montyhall.service.SimulationService;
import com.tele2.montyhall.service.SimulationServiceIpml;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MontyhallApplication{



	public static void main(String[] args) {
		SpringApplication.run(MontyhallApplication.class, args);


	}

	@Bean
	public  static SimulationService gameService(){
		return  new SimulationServiceIpml();

	}


}
