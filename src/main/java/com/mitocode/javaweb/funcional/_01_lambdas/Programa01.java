package com.mitocode.javaweb.funcional._01_lambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Programa01 {

	public static void main(String[] args) {

		comparetorConObjetos();
	}

	private static void comparetorConObjetos() {

		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona("Jorge", LocalDate.now(), 1500));
		lista.add(new Persona("Ruben", LocalDate.of(2000, 8, 10), 2000));
		lista.add(new Persona("Jose Luis", LocalDate.of(1995, 4, 15), 1850));
		lista.add(new Persona("Bryan", LocalDate.of(2005, 10, 20), 1900));

		for (Persona persona : lista) {
			System.out.println(persona);
		}

		/* CONVIRTIENDO A EXPRESIÓN LAMBDA */

		// EXPRESION REGULAR
//		Collections.sort(lista, new Comparator<Persona>() {
//
//			@Override
//			public int compare(Persona o1, Persona o2) {
//				return o1.getNombres().compareTo(o2.getNombres());
//			}
//
//		});

		// EXP 2 (FUNCIONA)
//		Collections.sort(lista, (Persona o1, Persona o2) -> {
//
//			return o1.getSalario().compareTo(o2.getSalario());
//		});

		// EXP 3 (FUNCIONA)
//		Collections.sort(lista, (o1, o2) -> {
//
//			return o1.getSalario().compareTo(o2.getSalario());
//		});

		// EXP 4 (FUNCIONA)
		Collections.sort(lista, (o1, o2) -> o1.getSalario().compareTo(o2.getSalario()));

		System.out.println("Lista ordenada");
		for (Persona persona : lista) {
			System.out.println(persona);
		}

	}

	private static void comparetorInicial() {
		String[] colores = { "negro", "amarillo", "verde", "azul", "violeta" };
		List<String> lista = Arrays.asList(colores);

		System.out.println(lista);

//		Collections.sort(lista);
		System.out.println("Lista ascendente");
		System.out.println(lista);

//		Collections.reverse(lista);
		System.out.println(lista);

		Comparator<String> comparador = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o2.compareTo(o1);
			}

		};

		Collections.sort(lista, comparador);// Collections.sort => ordenamiento
		System.out.println("Lista con comparador");
		System.out.println(lista);
	}

}
