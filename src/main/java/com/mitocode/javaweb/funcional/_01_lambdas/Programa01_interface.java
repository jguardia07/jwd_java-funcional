package com.mitocode.javaweb.funcional._01_lambdas;

public class Programa01_interface {

	public static void main(String[] args) {
		
		IOperaciones operacion = new IOperaciones() {
			
			@Override
			public int operacion(int a, int b) {
				return a + b;
			}
		};
		
		System.out.println(("Suma: " + operacion.operacion(3, 5)));
		
		IOperaciones operacion2 = (a,b) -> a + b;
		IOperaciones operacion3 = (a,b) -> a - b;
		IOperaciones operacion4 = (a,b) -> a * b;
		
		System.out.println("Suma Interfaces: " + operacion2.operacion(4, 3));
		System.out.println("Resta Interfaces: " + operacion3.operacion(4, 3));
		System.out.println("Mult. Interfaces: " + operacion4.operacion(4, 3));
		
		operacion2.confirmacion();
	}
	
}

interface IOperaciones{
	
	int operacion (int a, int b);
	
	default void confirmacion() {
		System.out.println("Metodo default");
	}
}