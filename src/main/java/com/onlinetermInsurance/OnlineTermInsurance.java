package com.onlinetermInsurance;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class OnlineTermInsurance {

	public static void main(String[] args) {		
		SpringApplication.run(OnlineTermInsurance.class, args);
		System.out.println("Connected to the Database...");
	}
}
