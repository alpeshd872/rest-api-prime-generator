package com.primegenerator.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*This is the entry point of spring boot application.
 * Here it will first all the properties define by you and set them all then the request will be passed to controller.
 * */
@SpringBootApplication
public class PrimegeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimegeneratorApplication.class, args);
	}

}
