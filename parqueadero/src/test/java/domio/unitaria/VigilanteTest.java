package domio.unitaria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ejercicio.parqueadero.modelo.Registro;
import com.ejercicio.parqueadero.modelo.Vehiculo;
import com.ejercicio.parqueadero.modelo.Vigilante;

import persistencia.repositorio.Parqueadero;
import testdatabuilder.VehiculoTestDataBuilder;

import org.junit.Test;


public class VigilanteTest {
	
	@Test
	public void validarPlaca(){
		
		//arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();  
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
		
		Vigilante vigilante = new Vigilante(parqueadero, registro);
		
		//act
		boolean placaValida = vigilante.validarPlaca(vehiculo.getPlaca());
		
		//assert
		assertTrue(placaValida);
		
	}
	
	@Test
	public void validarCcMoto(){
		
		//arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.conPlaca("SDG456").build();  
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
		
		Vigilante vigilante = new Vigilante(parqueadero, registro);
		
		//act
		boolean motoValida = vigilante.validarCcMoto(vehiculo.getPlaca());
		
		//assert
		assertTrue(motoValida);
		
	}

	@Test
	public void asignarCupoVehiculo(){
		
		//arrange				
		
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca("ASA534").
				conCC(2300).conColor("azul").build();
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);

		when(parqueadero.validarCupoLibre()).thenReturn(true);
		
		Vigilante vigilante = new Vigilante(parqueadero,registro);
				
		//act
		boolean asignado = vigilante.asignarCupoVehiculo(vehiculo);
		
		//assert
		assertTrue(asignado);

	}
	
	@Test
	public void retirarCupoVehiculo(){
		
		//arrange			
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca("ASA534").build();
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
			
		Vigilante vigilante = new Vigilante(parqueadero, registro);
							
		//act
		boolean retirado = vigilante.retirarCupoVehiculo(vehiculo.getPlaca());
		
		
		//assert
		assertTrue(retirado);
		
	}
	
	@Test
	public void calcularCosto(){
		
		//arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
				
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();  
				
		Vigilante vigilante = new Vigilante(parqueadero, registro);
					
		when(registro.obtener(vehiculo.getPlaca())).thenReturn(registro);

		//act
		double valor =vigilante.calcularCosto(vehiculo.getPlaca());
		
		//assert
		assertThat(valor);
		
	}
	

}
