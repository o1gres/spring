package com.prova.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.prova")
public class MainServices {

	public static void main(String[] args) 
	{
		SpringApplication.run(MainServices.class, args);
	}

}
