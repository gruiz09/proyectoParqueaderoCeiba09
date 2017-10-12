package com.ejercicio.parqueadero.model;

public class Vehiculo {
	
	private String placa;
	private String color;
	private Propietario propietario;
	
	public Vehiculo(String placa, String color, Propietario propietario) {
		super();
		this.placa = placa;
		this.color = color;
		this.propietario = propietario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	

}
