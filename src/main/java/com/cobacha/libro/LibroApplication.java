package com.cobacha.libro;

import com.cobacha.libro.model.DatosLibros;
import com.cobacha.libro.service.ConsumoAPI;
import com.cobacha.libro.service.ConversorDatos;
import com.cobacha.libro.service.IConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibroApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(LibroApplication.class, args);}


	@Override
	public void run(String... args) throws Exception {
		var consumoAPI= new ConsumoAPI();
		var json=consumoAPI.obtonoerDatos("https://gutendex.com/books/?languages=es");
		System.out.println(json);
		ConversorDatos conversor=new ConversorDatos();
		var datos=conversor.obtenerDatos(json, DatosLibros.class);
		System.out.println(datos);
	}
}
