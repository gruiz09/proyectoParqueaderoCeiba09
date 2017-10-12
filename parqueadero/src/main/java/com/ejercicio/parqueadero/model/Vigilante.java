package com.ejercicio.parqueadero.model;

public class Vigilante extends Persona{

	private double sueldo;
	private String hora_entrada;
	private String hora_salida;
	private Parqueadero parqueadero;
	
	
	public Vigilante(String nombre, String apellido, String telefono, double sueldo, String hora_entrada, String hora_salida, Parqueadero parqueadero ) {
		super(nombre, apellido, telefono);
		this.sueldo = sueldo;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.parqueadero = parqueadero;
	}


	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public String getHora_entrada() {
		return hora_entrada;
	}


	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}


	public String getHora_salida() {
		return hora_salida;
	}


	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}


	public Parqueadero getParqueadero() {
		return parqueadero;
	}


	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	
	

	

}
