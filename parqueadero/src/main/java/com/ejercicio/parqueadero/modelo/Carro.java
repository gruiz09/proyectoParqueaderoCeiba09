package com.ejercicio.parqueadero.modelo;

public class Carro extends Vehiculo{

	private int numero_puertas;
	private String tipo_carro;

	public Carro(String placa, String color, int cc, int numero_puertas, String tipo_carro) {
		super(placa, color, cc);
		this.numero_puertas = numero_puertas;
		this.tipo_carro = tipo_carro;
	}

	public int getNumero_puertas() {
		return numero_puertas;
	}

	public void setNumero_puertas(int numero_puertas) {
		this.numero_puertas = numero_puertas;
	}

	public String getTipo_carro() {
		return tipo_carro;
	}

	public void setTipo_carro(String tipo_carro) {
		this.tipo_carro = tipo_carro;
	}
	
	
	

}
