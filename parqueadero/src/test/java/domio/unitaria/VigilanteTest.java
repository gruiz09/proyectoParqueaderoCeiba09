package domio.unitaria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ejercicio.parqueadero.modelo.Registro;
import com.ejercicio.parqueadero.modelo.Vehiculo;
import com.ejercicio.parqueadero.modelo.Vigilante;

import persistencia.entidad.RegistroEntity;
import persistencia.entidad.VehiculoEntity;
import persistencia.repositorio.Parqueadero;
import testdatabuilder.VehiculoTestDataBuilder;

import org.junit.Test;


public class VigilanteTest {
	
	
	
	@Test
	public void validarPlaca(){
		
		//arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.conPlaca("TFD435").build();  
		
		//Parqueadero parqueadero = mock(Parqueadero.class);
		//Registro registro = mock(Registro.class);
		
		Vigilante vigilante = new Vigilante();
		
		//act
		boolean placaValida = vigilante.validarPlaca(vehiculo.getPlaca());
		
		//assert
		assertTrue(placaValida);
		
	}
	
	@Test
	public void validarPlacaInvalida(){
		
		//arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		
		Vehiculo vehiculo = vehiculoTestDataBuilder.conPlaca("ACR456").build();  
		
		//Parqueadero parqueadero = mock(Parqueadero.class);
		//Registro registro = mock(Registro.class);
		
		Vigilante vigilante = new Vigilante();
		
		
		//act
		boolean placaInvalida = vigilante.validarPlaca(vehiculo.getPlaca());
		
		//assert
		assertFalse(placaInvalida);
		
	}


	@Test
	public void asignarCupoVehiculo(){
		
		//arrange				
		
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca("ASA534").
				conCC(2300).conColor("azul").build();
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		//Registro registro = mock(Registro.class);

		when(parqueadero.validarCupoLibre()).thenReturn(true);
		
		Vigilante vigilante = new Vigilante();
				
		//act
		boolean asignado = vigilante.asignarCupoVehiculo(vehiculo);
		
		//assert
		assertTrue(asignado);

	}
	
	@Test
	public void retirarCupoVehiculo(){
		
		//arrange			
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca("ASA534").build();
		
		//Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
			
		Vigilante vigilante = new Vigilante();
							
		//act
		boolean retirado = vigilante.retirarCupoVehiculo(vehiculo.getPlaca());
		
		
		//assert
		assertTrue(retirado);
		
	}
	
	@Test
	public void calcularCosto(){
		
		//arrange
		//VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
				
		//Parqueadero parqueadero = mock(Parqueadero.class);
		RegistroEntity registro = mock(RegistroEntity.class);
		
		//Vehiculo vehiculo = vehiculoTestDataBuilder.build();  
				
		Vigilante vigilante = new Vigilante();
					
		//when(registro.obtener(vehiculo.getPlaca())).thenReturn(registro);

		//act
		double valor =vigilante.calcularCosto(registro);
		
		//assert
		assertThat(valor);
		
	}
	

}
