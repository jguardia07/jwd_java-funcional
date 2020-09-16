package com.mitocode.javaweb.funcional._07_api_stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Persona {

	private String nombres;
	private LocalDate fechaNacimiento;
	private Integer salario;
	private List<String> lenguajesDeProgramacion;
	
	
	


	public Persona() {
		this.lenguajesDeProgramacion = new ArrayList<>();
	}
	
	

	public Persona(String nombres) {
		super();
		this.nombres = nombres;
		this.lenguajesDeProgramacion = new ArrayList<>();
	}



	public Persona(String nombres, LocalDate fechaNacimiento) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.lenguajesDeProgramacion = new ArrayList<>();
	}

	public Persona(String nombres, LocalDate fechaNacimiento, Integer salario) {
		super();
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
		this.lenguajesDeProgramacion = new ArrayList<>();
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
	

	public List<String> getLenguajesDeProgramacion() {
		return lenguajesDeProgramacion;
	}



	public void setLenguajesDeProgramacion(List<String> lenguajesDeProgramacion) {
		this.lenguajesDeProgramacion = lenguajesDeProgramacion;
	}

	 
	public static int compararPorFechaNacimiento(Persona p1, Persona p2) {
		return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
	}
	
	public Integer getEdad() {
		if (fechaNacimiento != null) {
			return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
		}else {
			return -1;
		}
		
		
	}
	
	public int ordenarPorEdad(Persona otraPersona) {
		return this.getEdad().compareTo(otraPersona.getEdad())* -1;//* -1 para que orden de forma invertida
	}

	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + ", Edad=" + getEdad() + "]";
	}

	

}
