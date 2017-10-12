package com.ejercicio.parqueadero.modelo;

public class Moto extends Vehiculo {

	private int tipoEncendido;

	public Moto(String placa, String color, int cc, int tipoEncendido) {
		super(placa, color, cc);
		this.tipoEncendido = tipoEncendido;
	}

	public int getTipoEncendido() {
		return tipoEncendido;
	}

	public void setTipoEncendido(int tipoEncendido) {
		this.tipoEncendido = tipoEncendido;
	}


}
