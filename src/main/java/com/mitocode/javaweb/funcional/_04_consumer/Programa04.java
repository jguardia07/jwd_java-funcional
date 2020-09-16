package com.mitocode.javaweb.funcional._04_consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Programa04 {

	public static void main(String[] args) {

		consumer();
//		biConsumer();

	}

	private static void biConsumer() {
		BiConsumer<Integer, Integer> operacion = (x, y) -> System.out.println(x + y);
		BiConsumer<Integer, Integer> operacion2 = (x, y) -> System.out.println(x - y);
		BiConsumer<Integer, Integer> operacion3= (x, y) -> System.out.println(x * y);
		BiConsumer<Integer, Integer> operacion4= (x, y) -> System.out.println(x / y);
		
		operar(5, 9, (a,b)->System.out.println(a+b));
		operar(5, 9, (a,b)->System.out.println(a-b));
		operar(5, 9, (a,b)->System.out.println(a*b));
		operar(9, 5, (a,b)->System.out.println(a/b));
	
	}
	
	//metodo de orden superior
	private static void operar(int x, int y, BiConsumer<Integer, Integer> consumerOperacion) {
		consumerOperacion.accept(x, y);
	}

	private static void consumer() {
		String[] estudiantes = { "Max", "Ruben", "Jose", "Joao", "Kenia" };

				
		Consumer<List<String>> consumidorImpresion = (lista) -> {
			for (String dato : lista) {
				System.out.println("Hola: " + dato);
			}

		};
//		consumidorImpresion.accept(Arrays.asList(estudiantes));

		System.out.println("=============");

		Consumer<List<String>> consumidorAfter = (lista) -> {
			for (int i = 0; i < lista.size(); i++) {
				lista.set(i, (i + 1) + " - " + lista.get(i));
			}
		};

		consumidorAfter.andThen(consumidorImpresion).accept(Arrays.asList(estudiantes));
	}

}
