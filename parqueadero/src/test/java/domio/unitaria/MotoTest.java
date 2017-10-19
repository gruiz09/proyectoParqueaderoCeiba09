package domio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import persistencia.entidad.VehiculoEntity;
import testdatabuilder.MotoTestDataBuilder;;

public class MotoTest {

	private static final String ID = "2";
	private static final String TIPO_VEHICULO = "moto";
	private static final String PLACA = "TGJ675";
	private static final String COLOR = "negro";
	private static final String CC = "550";
	private static final String TIPO_ENCENDIDO = "electrico";
	


	@Test
	public void crearMotoTest() {
		
		// arrange
		MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().
				conId(ID).
				conPlaca(PLACA).
				conColor(COLOR).
				conCC(CC).
				conTipoVehiculo(TIPO_VEHICULO).
				conTipoEncendido(TIPO_ENCENDIDO);

		// act
		VehiculoEntity vehiculo = motoTestDataBuilder.build();

		// assert
		assertEquals(ID, vehiculo.getId());
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(COLOR, vehiculo.getColor());
		assertEquals(CC, vehiculo.getCc());
		assertEquals(TIPO_VEHICULO, vehiculo.getTipo_vehiculo());
		assertEquals(TIPO_ENCENDIDO, vehiculo.getTipo_encendido());
	}
	
}
