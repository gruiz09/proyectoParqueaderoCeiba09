package testdatabuilder;

import persistencia.entidad.VehiculoEntity;

public class MotoTestDataBuilder {
	
		private static final String ID = "2";
		private static final String TIPO_VEHICULO = "moto";
		private static final String PLACA = "TGJ675";
		private static final String COLOR = "negro";
		private static final String CC = "550";
		private static final String TIPO_ENCENDIDO = "electrico";
	
		private String id;
		private String tipo_vehiculo;
		private String placa;
		private String color;
		private String cc;
		private String tipo_encendido;
		
		
		public MotoTestDataBuilder() {
			this.id = ID;
			this.tipo_vehiculo = TIPO_VEHICULO;
			this.placa = PLACA;
			this.color = COLOR;
			this.cc = CC;
			this.tipo_encendido = TIPO_ENCENDIDO;
		}

		public MotoTestDataBuilder conId(String id) {
			this.id = id;
			return this;
		}
		
		public MotoTestDataBuilder conPlaca(String placa) {
			this.placa = placa;
			return this;
		}

		public MotoTestDataBuilder conColor(String color) {
			this.color = color;
			return this;
		}
		
		public MotoTestDataBuilder conCC(String cc) {
			this.cc = cc;
			return this;
		}
		
		public MotoTestDataBuilder conTipoVehiculo(String tipo_vehiculo) {
			this.tipo_vehiculo = tipo_vehiculo;
			return this;
		}

		public MotoTestDataBuilder conTipoEncendido(String tipo_encendido) {
			this.tipo_encendido = tipo_encendido;
			return this;
		}
		
		

		public VehiculoEntity build() {
			VehiculoEntity vehiculo = new VehiculoEntity();
			vehiculo.setId(this.id);
			vehiculo.setPlaca(this.placa);
			vehiculo.setColor(this.color);
			vehiculo.setCc(this.cc);
			vehiculo.setTipo_encendido(this.tipo_encendido);
			vehiculo.setTipo_vehiculo(this.tipo_vehiculo);
			return vehiculo;
		}


}
