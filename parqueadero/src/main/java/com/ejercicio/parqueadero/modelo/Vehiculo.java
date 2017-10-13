package com.ejercicio.parqueadero.modelo;

public class Vehiculo {
	
	private String placa;
	private String color;
	private int cc;
	
	public Vehiculo(String placa, String color, int cc) {
		super();
		this.placa = placa;
		this.color = color;
		this.cc = cc;
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

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	

}
