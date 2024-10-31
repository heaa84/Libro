package com.cobacha.libro.principal;

import com.cobacha.libro.model.Datos;
import com.cobacha.libro.model.DatosLibro;
import com.cobacha.libro.service.ConsumoAPI;
import com.cobacha.libro.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private final ConsumoAPI consumoAPI=new ConsumoAPI();
    private final ConvierteDatos conversor =new ConvierteDatos();
    private final Scanner teclado=new Scanner(System.in);

    public void muestraMenu(){
        var json=consumoAPI.obtenerDatos(URL_BASE);
        //System.out.println(json);// muestra el json sin mapear

        /*Mapea todos los datos del json de estan en los record
        * los record no tienen todos los datos del json solo tienen los que solicitamos
        * los datos mapeados se  guardan en: var datos
        * conversor.obtenerDatos se encarga de mappear:
        * (json, Datos.class) que son el json y el record Datos
        * */
        var datos= conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 de libros mas descargados
        System.out.println("TOP 10 de libros mas descargados" );
        datos.libros().stream()// accedemos a la lista de libros y aplicamos stream
                /*.sorted Odenamos los elementos de menor a mayor de numero de descagas
                * .reversed invertimos el orden de mayo a menor*/
                .sorted(Comparator.comparing(DatosLibro::numeroDeDescargas).reversed())
                .limit(10) // limitamos el contenido a 10 elementos
                        .map(l->l.titulo().toUpperCase())// Convertimos los titulosen mayusculas
                .forEach(System.out::println);

        //Busqueda de libro por nombre
        System.out.println("Ingrese el nombre del libro a Buscar");
        var tituloLibro=teclado.nextLine();
        json= consumoAPI.obtenerDatos(URL_BASE+"?search="+tituloLibro.replace(" ","+"));
        var datosBusqueda=conversor.obtenerDatos(json,Datos.class);
        /*Optional es un clase ya definida en java: dependiendo si encuentra o no un resultado lo almasena en un conteiner y se hace un tratamiento de datos:
        * Container:Optional<DatosLibro>libroBuscado=datosBusqueda
        * Tratamiento:datosBusqueda.libros().stream()
        * */
        Optional<DatosLibro>libroBuscado=datosBusqueda.libros().stream()
                .filter(l->l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))//itera sobre titulo en mayusculas y busca el titulo en matusculas
                .findFirst();//solo el primer resultado
        if (libroBuscado.isPresent()){
            System.out.println("Libro Encontrado");
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }

        //trabajando con estadisticas
        /*Checamos que tipo de variable es numero de descargas, que es donde vamos a enfocar las estadisticas, en este caso es un double
         *y usamos: DoubleSummaryStatistics lo guartamos en est
         *
         */
        DoubleSummaryStatistics est =datos.libros().stream()
                .filter(d->d.numeroDeDescargas()>0)//filtramos solo descargar mallores a 0
                .collect(Collectors.summarizingDouble(DatosLibro::numeroDeDescargas));//" .collect(Collectors.summarizingDouble" mos ayuda a generar nustas estalisticas de las descargas
        System.out.println("Cantidad media de descargas; "+est.getAverage());
        System.out.println("Cantidad maxima de descargas; "+est.getMax());
        System.out.println("Cantidad minima de descargas; "+est.getMin());
        System.out.println("Cantidad de registros evaluados ; "+est.getCount());

    }
}
