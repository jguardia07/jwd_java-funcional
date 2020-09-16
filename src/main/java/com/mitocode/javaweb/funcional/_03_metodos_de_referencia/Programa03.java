package com.mitocode.javaweb.funcional._03_metodos_de_referencia;

import java.net.InterfaceAddress;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa03 {

	private List<Persona> lista = new ArrayList<>();

	public Programa03() {
		super();
		lista.add(new Persona("Jorge", LocalDate.now(), 1500));
		lista.add(new Persona("Ruben", LocalDate.of(2000, 8, 10), 2000));
		lista.add(new Persona("Jose Luis", LocalDate.of(1995, 4, 15), 1850));
		lista.add(new Persona("Bryan", LocalDate.of(2005, 10, 20), 1900));
	}

	public static void main(String[] args) {

		Programa03 programa = new Programa03();
		programa.imprimirLista("Lista Original");

//		programa.referenciaAEstatico();
//		programa.referenciaAMetodoDeInstancia();
//		programa.referenciaAMetodoDeInstanciaObjetoArbitrario();
		programa.referenciaAConstructor();

		// ejemplo de como acceder a variables de clase (static) e instancia
		// De instancia
		UtilitarioPersona util = new UtilitarioPersona();
		util.variable = 1;
		// De clase
		UtilitarioPersona.variable2 = -1;

	}

	private void referenciaAConstructor() {

//		IPersona interfaz = (nombres, fechaNacimiento) -> new Persona(nombres, fechaNacimiento);
		IPersona interfaz = Persona::new;
		lista.add(interfaz.crearPersona("Joao", LocalDate.of(1988, 12, 7)));

//		IPersona2 interfaz2 = (nombres, fechaNacimiento, salario) -> new Persona(nombres, fechaNacimiento, salario);
		IPersona2 interfaz2 = Persona::new;
		lista.add(interfaz2.crearPersona("Max", LocalDate.of(1995, 10, 10), 2300));
		
		
		imprimirLista("Seagregó persona");

	}

	public void referenciaAMetodoDeInstanciaObjetoArbitrario2() {

		String[] estudiantes = { "Max", "Ruben", "Jose", "Joao", "Kenia" };

		Arrays.sort(estudiantes, String::compareToIgnoreCase);
		System.out.println(estudiantes);
//		Arrays.sort(estudiantes, (nombre1, nombre2) -> nombre1.compareTo(nombre2));

	}

	public void referenciaAMetodoDeInstanciaObjetoArbitrario() {

//		lista.sort((persona1, persona2) -> persona1.ordenarPorEdad(persona2));
		lista.sort(Persona::ordenarPorEdad);
		imprimirLista("Ordenado por EDAD");
	}

	public void referenciaAMetodoDeInstancia() {
		// llamando metodo de instancia
		UtilitarioPersona util = new UtilitarioPersona();

//		lista.sort((persona1, persona2) -> persona1.getNombres().compareTo(persona2.getNombres()));

//		lista.sort((persona1, persona2) -> util.compararPorNombre(persona1, persona2));
		lista.sort(util::compararPorNombre);
		imprimirLista("Ordenamiento por nombre");

//		lista.sort((persona1, persona2)-> util.compararPorSalario(persona1, persona2));
		lista.sort(util::compararPorSalario);
		imprimirLista("Ordenamiento por salario");

		lista.sort(util::compararPorFechaNacimiento);
		imprimirLista("Ordenamiento por fecha de nacimiento");

	}

	public void referenciaAEstatico() {

//		lista.sort((persona1, persona2) -> persona1.getFechaNacimiento().compareTo(persona2.getFechaNacimiento()));
//		lista.sort((persona1, persona2) -> Persona.compararPorFechaNacimiento(persona1, persona2));
		lista.sort(Persona::compararPorFechaNacimiento);

		imprimirLista("Ordenamiento por metodo Estatico");
	}

	private void imprimirLista(String mensaje) {
		System.out.println(mensaje);
		for (Persona persona : lista) {
			System.out.println(persona);
		}
	}
}

interface IPersona {
	Persona crearPersona(String nombre, LocalDate fechaNacimiento);
}

interface IPersona2 {
	Persona crearPersona(String nombre, LocalDate fechaNacimiento, Integer salario);
}
