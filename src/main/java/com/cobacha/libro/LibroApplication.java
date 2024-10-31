package com.cobacha.libro;


import com.cobacha.libro.principal.Principal;
import com.cobacha.libro.service.ConsumoAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.transform.Result;
import java.util.Arrays;

@SpringBootApplication
public class LibroApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(LibroApplication.class, args);}


	@Override
	public void run(String... args) throws Exception {
		Principal principal=new Principal();
		principal.muestraMenu();
	}
}
