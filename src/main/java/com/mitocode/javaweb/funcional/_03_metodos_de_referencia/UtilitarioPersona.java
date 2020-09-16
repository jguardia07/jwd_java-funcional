package com.mitocode.javaweb.funcional._03_metodos_de_referencia;

public class UtilitarioPersona {

	public int variable; // variable de instancia
	public static int variable2; // variable de clase
		

	public int compararPorNombre(Persona p1, Persona p2) {
		return p1.getNombres().compareTo(p2.getNombres());
	}
	
	public int compararPorFechaNacimiento(Persona p1, Persona p2) {
		return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
	}
	
	public int compararPorSalario(Persona p1, Persona p2) {
		return p1.getSalario().compareTo(p2.getSalario());
	}
	
}
