package com.mitocode.javaweb.funcional._00_intro;

public class Programa00 {

	private Integer sumatoria = 0;

	public static void main(String[] args) {

		Programa00 programa = new Programa00();
		System.out.println(programa.suma2(3, 5));
		System.out.println(programa.suma2(3, 5));
		System.out.println(programa.suma2(3, 5));
		System.out.println(programa.suma2(3, 5));
		System.out.println(programa.suma2(3, 5));
	}

	// Funcion pura: recibiendo los mismos valores de parametro,
	// se obtendrá el mismo resultado, llamada n veces
	public int suma(int a, int b) {
		return a + b;
	}

	// Funcion impura: Es cuando tiene un resultado diferente para los mismo
	// parametros
	public int suma2(int a, int b) {
		sumatoria += suma(a, b);// -> sumatoria = sumatoria + suma(a,b);
		return sumatoria;
	}

}
