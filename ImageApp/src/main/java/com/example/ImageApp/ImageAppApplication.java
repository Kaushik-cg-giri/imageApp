package com.example.ImageApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.ImageApp")
public class ImageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageAppApplication.class, args);
	}

}
