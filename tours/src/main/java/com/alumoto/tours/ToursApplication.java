package com.alumoto.tours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;


@EnableAutoConfiguration
@SpringBootApplication
public class ToursApplication {

	public static void main(String[] args) {
	SpringApplication.run(ToursApplication.class, args);

	}

}
