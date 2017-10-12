package com.ejercicio.parqueadero.model;

public class Parqueadero {
	
	private int cupos_disponibles_carro;
	private int cupos_disponibles_moto;
	
	public Parqueadero(int cupos_disponibles_carro, int cupos_disponibles_moto) {
		super();
		this.cupos_disponibles_carro = cupos_disponibles_carro;
		this.cupos_disponibles_moto = cupos_disponibles_moto;
	}

	public int getCupos_disponibles_carro() {
		return cupos_disponibles_carro;
	}

	public void setCupos_disponibles_carro(int cupos_disponibles_carro) {
		this.cupos_disponibles_carro = cupos_disponibles_carro;
	}

	public int getCupos_disponibles_moto() {
		return cupos_disponibles_moto;
	}

	public void setCupos_disponibles_moto(int cupos_disponibles_moto) {
		this.cupos_disponibles_moto = cupos_disponibles_moto;
	}
	
	

}
