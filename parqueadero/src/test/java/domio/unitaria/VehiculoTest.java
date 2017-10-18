package domio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import persistencia.entidad.VehiculoEntity;
import testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {


		private static final String ID = "1";
		private static final String PLACA = "ART546";
		private static final String COLOR = "azul";
		private static final String CC = "250";
		private static final String TIPO_VEHICULO = "carro";
		private static final String NUMERO_PUERTAS = "4";
		private static final String TIPO_CARRO = "Automovil";

		@Test
		public void crearVehiculoTest() {
			
			// arrange
			VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().
					conId(ID).
					conPlaca(PLACA).
					conColor(COLOR).
					conCC(CC).
					conTipoVehiculo(TIPO_VEHICULO).
					conNumeroPuertas(NUMERO_PUERTAS).
					conTipoCarro(TIPO_CARRO);

			// act
			VehiculoEntity vehiculo = vehiculoTestDataBuilder.build();

			// assert
			assertEquals(ID, vehiculo.getId());
			assertEquals(PLACA, vehiculo.getPlaca());
			assertEquals(COLOR, vehiculo.getColor());
			assertEquals(CC, vehiculo.getCc());
			assertEquals(PLACA, vehiculo.getTipo_vehiculo());
			assertEquals(COLOR, vehiculo.getNumero_puertas());
			assertEquals(CC, vehiculo.getTipo_carro());
		}

}
