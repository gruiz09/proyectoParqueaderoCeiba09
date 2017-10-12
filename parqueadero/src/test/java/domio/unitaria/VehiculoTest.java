package domio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ejercicio.parqueadero.modelo.Vehiculo;

import testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {


		private static final String PLACA = "RFS458";
		private static final String COLOR = "1234";
		private static final int CC = 250;

		@Test
		public void crearVehiculoTest() {
			
			// arrange
			VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().
					conPlaca(PLACA).
					conColor(COLOR).
					conCC(CC);

			// act
			Vehiculo vehiculo = vehiculoTestDataBuilder.build();

			// assert
			assertEquals(PLACA, vehiculo.getPlaca());
			assertEquals(COLOR, vehiculo.getColor());
			assertEquals(CC, vehiculo.getCc());
		}

}
