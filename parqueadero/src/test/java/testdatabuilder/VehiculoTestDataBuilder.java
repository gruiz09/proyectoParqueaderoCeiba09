package testdatabuilder;

import com.ejercicio.parqueadero.modelo.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private static final String PLACA = "ART546";
	private static final String COLOR = "azul";
	private static final int CC = 250;
	
	private String placa;
	private String color;
	private int cc;

	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.color = COLOR;
		this.cc = CC;
	}

	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public VehiculoTestDataBuilder conColor(String color) {
		this.color = color;
		return this;
	}
	
	public VehiculoTestDataBuilder conCC(int cc) {
		this.cc = cc;
		return this;
	}


	public Vehiculo build() {
		return new Vehiculo(this.placa, this.color, this.cc);
	}

}
