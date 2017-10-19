package domio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import persistencia.entidad.VehiculoEntity;
import testdatabuilder.CarroTestDataBuilder;

public class CarroTest {


		private static final String ID = "1";
		private static final String PLACA = "ART546";
		private static final String COLOR = "azul";
		private static final String CC = "250";
		private static final String TIPO_VEHICULO = "carro";
		private static final String NUMERO_PUERTAS = "4";
		private static final String TIPO_CARRO = "Automovil";

		@Test
		public void crearCarroTest() {
			
			// arrange
			CarroTestDataBuilder carroTestDataBuilder = new CarroTestDataBuilder().
					conId(ID).
					conPlaca(PLACA).
					conColor(COLOR).
					conCC(CC).
					conTipoVehiculo(TIPO_VEHICULO).
					conNumeroPuertas(NUMERO_PUERTAS).
					conTipoCarro(TIPO_CARRO);

			// act
			VehiculoEntity vehiculo = carroTestDataBuilder.build();

			// assert
			assertEquals(ID, vehiculo.getId());
			assertEquals(PLACA, vehiculo.getPlaca());
			assertEquals(COLOR, vehiculo.getColor());
			assertEquals(CC, vehiculo.getCc());
			assertEquals(TIPO_VEHICULO, vehiculo.getTipo_vehiculo());
			assertEquals(NUMERO_PUERTAS, vehiculo.getNumero_puertas());
			assertEquals(TIPO_CARRO, vehiculo.getTipo_carro());
		}

}
