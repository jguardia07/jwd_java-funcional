package com.mitocode.javaweb.funcional._03_metodos_de_referencia;

import java.io.ObjectInputStream.GetField;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {

	private String nombres;
	private LocalDate fechaNacimiento;
	private Integer salario;
	
	
	public Persona(String nombres, LocalDate fechaNacimiento) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(String nombres, LocalDate fechaNacimiento, Integer salario) {
		super();
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	 
	public static int compararPorFechaNacimiento(Persona p1, Persona p2) {
		return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
	}
	
	public Integer getEdad() {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	
	public int ordenarPorEdad(Persona otraPersona) {
		return this.getEdad().compareTo(otraPersona.getEdad())* -1;//* -1 para que orden de forma invertida
	}

	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + ", Edad=" + getEdad() + "]";
	}

	

}
