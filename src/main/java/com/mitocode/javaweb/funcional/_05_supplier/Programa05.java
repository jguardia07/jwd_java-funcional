package com.mitocode.javaweb.funcional._05_supplier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class Programa05 {
	
	public static void main(String[] args) {
		
		Supplier<LocalDateTime> supplierDeHora = () -> LocalDateTime.now();
		System.out.println("Hora actual: " + supplierDeHora.get());
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm a");
		Supplier<String> supplierConFormato = () -> formatoFecha.format(LocalDateTime.now());
		System.out.println(supplierConFormato.get());
		
		System.out.println("=================");
		
//		Persona persona1 = new Persona();
		Persona persona1 = getPersona(Persona::new);
		Persona persona2 = getPersona(()-> new Persona("Joao",LocalDate.of(1988, 12, 7)));
		
		System.out.println(persona1);
		System.out.println(persona2);
		
		
	}
	
	public static Persona getPersona(Supplier<Persona> supplier) {
		Persona persona = supplier.get();
		if(persona.getNombres()== null) {
			persona.setNombres("Nombre default");
		}
		if (persona.getFechaNacimiento()== null) {
			persona.setFechaNacimiento(LocalDate.of(2002, 1, 1));
		}
		return persona;
	}
	
}
