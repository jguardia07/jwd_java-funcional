package com.mitocode.javaweb.funcional._06_function;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;

public class Programa06 {

	public static void main(String[] args) {
		
		Function<String, Integer> funcionObeterTamaño = cadena -> cadena.length();
		System.out.println(funcionObeterTamaño.apply("Java WEb Developer"));
		
		Function<Integer, Boolean> esDivisibleEntre17 = entero -> entero % 17 == 0;
		System.out.println("Numero 45349899 es divisible entre 17: " + esDivisibleEntre17.apply(45349899));
		
		System.out.println("============");
		
		String[] estudiantes = { "Max", "Ruben", "Jose", "Joao", "Kenia" };
		Function<String, String> funcionHash = nombre -> DigestUtils.sha256Hex(nombre);
		
		Map<String, String> mapaHash = new HashMap<>();
		for (String estudiante : estudiantes) {
			mapaHash.put(estudiante, funcionHash.apply(estudiante));
		}
		for (Entry<String, String> elementoMapa : mapaHash.entrySet()) {
			System.out.println(elementoMapa.getKey() + ": " + elementoMapa.getValue());
		}
		
	}
}
