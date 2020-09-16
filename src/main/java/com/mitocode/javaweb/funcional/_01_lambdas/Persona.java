package com.mitocode.javaweb.funcional._01_lambdas;

import java.time.LocalDate;

public class Persona {

	private String nombres;
	private LocalDate fechaNacimiento;
	private Integer salario;

	
	public Persona(String nombres, LocalDate fechaNacimiento, Integer salario) {
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

	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + "]";
	}

	

}
