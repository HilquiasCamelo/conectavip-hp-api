package com.conectavip_hp.conectavip_hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.conectavip_hp")
public class ConectavipHpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectavipHpApplication.class, args);
	}

}
