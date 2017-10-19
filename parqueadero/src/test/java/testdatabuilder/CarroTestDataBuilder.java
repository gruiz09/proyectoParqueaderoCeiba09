package testdatabuilder;

import persistencia.entidad.VehiculoEntity;

public class CarroTestDataBuilder {
	
	private static final String ID = "1";
	private static final String TIPO_VEHICULO = "carro";
	private static final String PLACA = "ART546";
	private static final String COLOR = "azul";
	private static final String CC = "250";
	private static final String NUMERO_PUERTAS = "4";
	private static final String TIPO_CARRO = "automovil";

	private String id;
	private String tipo_carro;
	private String placa;
	private String color;
	private String cc;
	private String numero_puertas;
	private String tipo_vehiculo;
	
	public CarroTestDataBuilder() {
		this.id = ID;
		this.tipo_carro = TIPO_CARRO;
		this.placa = PLACA;
		this.color = COLOR;
		this.cc = CC;
		this.numero_puertas = NUMERO_PUERTAS;
		this.tipo_vehiculo = TIPO_VEHICULO;	
	}

	public CarroTestDataBuilder conId(String id) {
		this.id = id;
		return this;
	}
	
	public CarroTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public CarroTestDataBuilder conColor(String color) {
		this.color = color;
		return this;
	}
	
	public CarroTestDataBuilder conCC(String cc) {
		this.cc = cc;
		return this;
	}
	
	public CarroTestDataBuilder conTipoVehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
		return this;
	}

	public CarroTestDataBuilder conNumeroPuertas(String numero_puertas) {
		this.numero_puertas = numero_puertas;
		return this;
	}
	
	public CarroTestDataBuilder conTipoCarro(String tipoCarro) {
		this.tipo_carro = tipoCarro;
		return this;
	}

	public VehiculoEntity build() {
		VehiculoEntity vehiculo = new VehiculoEntity();
		vehiculo.setId(this.id);
		vehiculo.setPlaca(this.placa);
		vehiculo.setColor(this.color);
		vehiculo.setCc(this.cc);
		vehiculo.setTipo_carro(this.tipo_carro);
		vehiculo.setTipo_vehiculo(this.tipo_vehiculo);
		vehiculo.setNumero_puertas(this.numero_puertas);
		return vehiculo;
	}

}
