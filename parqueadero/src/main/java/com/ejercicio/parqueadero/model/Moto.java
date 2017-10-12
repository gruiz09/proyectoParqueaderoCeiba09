package com.ejercicio.parqueadero.model;

public class Moto extends Vehiculo {

	private int cc;
	
	public Moto(String placa, String color, Propietario propietario, int cc) {
		super(placa, color, propietario);
		this.cc = cc;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
	
	

}
