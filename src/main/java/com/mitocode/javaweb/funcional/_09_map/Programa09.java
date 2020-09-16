package com.mitocode.javaweb.funcional._09_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Programa09 {

	
	public static void main(String[] args) {
		Map<Integer, String> hostings = new HashMap<>();
		hostings.put(1, "mitocode.com");
		hostings.put(2, "heroku.com");
		hostings.put(3, "aws.console.amazon.com");
		hostings.put(4, "digitalocean.com");
		hostings.put(5, "aws.amazon.com");
		hostings.put(6, "aws2.amazon.com");
		
		// antes de java8
		String valor = "";
		for (Entry<Integer, String> hosting : hostings.entrySet()) {
			if(hosting.getValue().contains("aws")) {
				valor = hosting.getValue();
				break;
			}
		}
		System.out.println("Valor: " + valor);
		
		// Con API Stream
		valor = hostings.entrySet().stream() // Stream<EntrySet<Integer,String>>
			.filter(entry -> entry.getValue().contains("aws")) // Stream<EntrySet<Integer,String>>
			.map(entry -> entry.getValue()) // Stream<String>
			.collect(Collectors.joining(","));
		
		System.out.println("Valor2: " + valor);
		
	}
}
