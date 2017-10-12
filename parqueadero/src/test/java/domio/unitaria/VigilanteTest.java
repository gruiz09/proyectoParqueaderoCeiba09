package domio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
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
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();  
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
		
		Vigilante vigilante = new Vigilante(parqueadero, registro);
		
		//act
		boolean motoValida = vigilante.validarCcMoto();
		
		//assert
		assertTrue(motoValida);
		
	}

	@Test
	public void asignarCupoVehiculo(){
		
		//arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();  
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
		
		when(parqueadero.validarCupoLibre()).thenReturn(true);
		
		Vigilante vigilante = new Vigilante(parqueadero, registro);
		
		//when(vigilante.validarPlaca(vehiculo.getPlaca())).thenReturn(true);
			
		//act
		parqueadero.agregarVehiculo(vehiculo);
		
		//assert
		//assertEquals(parqueadero.obtenerVehiculoPorPlaca(vehiculo.getPlaca()),vehiculo.getPlaca());
	}
	
	@Test
	public void retirarCupoVehiculo(){
		
		//arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();  
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
		
				
		Vigilante vigilante = new Vigilante(parqueadero, registro);
					
		//act
		parqueadero.retirarVehiculo(vehiculo);
		
		//assert
		parqueadero.obtenerVehiculoPorPlaca(vehiculo.getPlaca());
		
	}
	

}
