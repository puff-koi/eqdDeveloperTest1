package com.springboot.eqd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= {"com.springboot.eqd"})
public class EqdApplication {

	public static void main(String[] args) {
		SpringApplication.run(EqdApplication.class, args);
	}

}
