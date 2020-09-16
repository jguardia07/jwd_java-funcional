package com.mitocode.javaweb.funcional._07_api_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Programa07_intro {

	public static void main(String[] args) {

		Programa07_intro programa = new Programa07_intro();

//		programa.introStream();
//		programa.intStream();
//		programa.mapStream();
//		programa.mapStream2();
//		programa.summaryStatistics();
		programa.flatMap();
	}
	
	public void flatMap() {
		Persona persona1 = new Persona("Joao");
		persona1.getLenguajesDeProgramacion().add("Java");
		persona1.getLenguajesDeProgramacion().add("Python");
		persona1.getLenguajesDeProgramacion().add("PHP");
		persona1.getLenguajesDeProgramacion().add("Kotlin");
		
		Persona persona2 = new Persona("Brenda");
		persona2.getLenguajesDeProgramacion().add("GoLang");
		persona2.getLenguajesDeProgramacion().add("Scala");
		persona2.getLenguajesDeProgramacion().add("Java");
		persona2.getLenguajesDeProgramacion().add("PHP");
		
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(persona1);
		lista.add(persona2);
		
		lista.stream()//Stream<Persona>
				.map(persona -> persona.getLenguajesDeProgramacion())//Stream<List<String>> ->Stream<String>
				.flatMap(lenguajes -> lenguajes.stream())//Stream<String>
				.distinct()
				.forEach(System.out::println);
		
	}
	
	public void summaryStatistics() {
		//obtener promedios, numero mayor, cantidad, etc
		IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,10,999,100).summaryStatistics();
//		System.out.println(summary);
		
		//ahora con objetos
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(new Persona("Jorge", LocalDate.now(), 1300));
		lista.add(new Persona("Ruben", LocalDate.of(2000, 8, 10), 1500));
		lista.add(new Persona("Jose Luis", LocalDate.of(1995, 4, 15), 3000));
		lista.add(new Persona("Bryan", LocalDate.of(1995, 10, 20), 4500));
		
		IntSummaryStatistics num =		lista.stream()//Stream<Persona>
			 	.mapToInt(persona -> persona.getEdad())//Stream<Integer> = IntStream
			 	.summaryStatistics();
			 	
			 	System.out.println(num);
	}

	// onvertir un string en objeto
	public void mapStream2() {
		try {
			// Files para lectura de archivos
			Stream<String> nombresStream = Files.lines(Paths.get("src/main/resources/students.txt"));
//					.filter(nombre -> nombre.contains("h"));

			List<Persona> listaPersonas = nombresStream // Stream<String>
					.filter(nombre -> nombre.contains("h"))
					.map(Persona::new)// Stream <Persona>
					.collect(Collectors.toList());// List<Persona>

			listaPersonas.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		}

	}

	public void mapStream() {
		// Convierte un objeto en otro
		String[] names = { "Elar", "Jorge", "Jessy", "Mauricio", "Zanier", "Jaime", "Sebastian", "Christian", "Alan",
				"Martin", "Jahiro", "Carlos", "Jean" };

		Arrays.stream(names) // Stream<String>
				.map(nombre -> nombre.length()) // Stream<Integer>
				.filter(tamanioNombre -> tamanioNombre < 5) // Stream<Integer>
				.forEach(System.out::println);

		System.out.println("========");
		Arrays.stream(names) // Stream<String>
				.map(nombre -> nombre.toUpperCase()) // Stream<String>
				.filter(nombreMayusculas -> nombreMayusculas.contains("AN")) // Stream<Integer>
				.sorted().forEach(System.out::println);

	}

	public void intStream() {
		IntStream numeros = IntStream.range(1, 900).skip(5);
		numeros.forEach(System.out::println);

		IntStream suma = IntStream.range(1, 900);
		System.out.println(suma.sum());
	}

	public void introStream() {
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(new Persona("Jorge", LocalDate.now(), 1300));
		lista.add(new Persona("Ruben", LocalDate.of(2000, 8, 10), 1500));
		lista.add(new Persona("Jose Luis", LocalDate.of(1995, 4, 15), 3000));
		lista.add(new Persona("Bryan", LocalDate.of(1995, 10, 20), 4500));

		for (Persona persona : lista) {
			System.out.println(persona);
		}

		System.out.println("===CON STREAM===");

//		lista.forEach(persona -> System.out.println("Impresion: " + persona)); //sin Stream
		lista.stream().forEach(persona -> System.out.println("Impresion: " + persona));// con Stream

		System.out.println("===CON FILTROS===");
		lista.stream()// stream source
				.filter(persona -> persona.getEdad() >= 18)// operaciones intermedia
				.filter(persona -> persona.getNombres().contains("B"))// operacion intermedia
				.forEach(System.out::println);// operaciones terminal

		System.out.println("===CON REFERE====");
		lista.forEach(System.out::println);

		System.out.println("=================");
		// Como guardar en una variable
		List<Persona> lista2 = lista.stream()// devuelve Stream<Persona>
				.filter(persona -> persona.getEdad() >= 18)// devuelve Stream<Persona>
				.collect(Collectors.toList());// devuelve List<Persona>

		lista2.stream().forEach(System.out::println);

	}

}
