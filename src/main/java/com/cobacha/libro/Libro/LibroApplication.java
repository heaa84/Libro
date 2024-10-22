package com.cobacha.libro.Libro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibroApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(LibroApplication.class, args);}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola");
	}
}
