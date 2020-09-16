package com.mitocode.javaweb.funcional._08_optional;

import java.util.Optional;

public class Programa08 {

	public static void main(String[] args) {
		Programa08 programa = new Programa08();
		programa.optionalIntro();
	}
	
	private void optionalIntro() {
		Optional<String> curso = Optional.of("Java Web Developer");
		Optional<String> curso2 = Optional.ofNullable(null);
		
		System.out.println("Optional: " + curso);
		System.out.println("Optional value: " + curso.get());
		System.out.println("Optional isPresent: " + curso.isPresent());
		curso.ifPresent( x -> System.out.println("Optional ifPresent es: " + x));
		
		System.out.println();
		System.out.println("Optional2: " + curso2);
		System.out.println("Optional2 value: " + curso2.orElse("No hay valor"));
		System.out.println("Optional2 isPresent: " + curso2.isPresent());
		curso2.ifPresent( x -> System.out.println("Optional2 ifPresent es: " + x));
		
		System.out.println();
		System.out.println("Optional EMPTY " + Optional.empty());
		
	}
}
