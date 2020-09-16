package com.mitocode.javaweb.funcional._02_scopes;

public class Programa02 {

	static double suma = 50; // variable global
	
	public static void main(String[] args) {
		// code
		int total = 100; // variable local
//		total = 50; // no se puede modificar una variable local considerado final
		suma = 30; // solo se pueden modifcar las vaiable globales o de instancia
		IOperaciones interfaz = (x, y) -> {
			return x + y + total + suma;
		};
		
		System.out.println("Operacion: " + interfaz.operacion(4,6));

	}
}

interface IOperaciones {
	double operacion(double a, double b);
}
