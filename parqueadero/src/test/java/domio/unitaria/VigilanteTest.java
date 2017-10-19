package domio.unitaria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ejercicio.parqueadero.modelo.Registro;
import com.ejercicio.parqueadero.modelo.Vigilante;

import persistencia.entidad.RegistroEntity;
import persistencia.entidad.VehiculoEntity;
import persistencia.repositorio.Parqueadero;
import testdatabuilder.CarroTestDataBuilder;
import testdatabuilder.MotoTestDataBuilder;

import org.junit.Test;


public class VigilanteTest {
	
	
	
	@Test
	public void PlacaCarroRestringidaEnDiaPermitido(){
		
		//arrange
		CarroTestDataBuilder carroTestDataBuilder = new CarroTestDataBuilder();
		
		VehiculoEntity vehiculo = carroTestDataBuilder.conPlaca("ACR456").build(); 
		
		Vigilante vigilante =  new Vigilante();
		
		//act
		boolean placaValida = vigilante.validarPlaca(vehiculo.getPlaca(),3);

		//assert
		assertTrue(placaValida);
		
	}
	
	@Test
	public void PlacaCarroRestringidaEnDiaNoPermitido(){
		
		//arrange
		CarroTestDataBuilder vehiculoTestDataBuilder = new CarroTestDataBuilder();
		
		VehiculoEntity vehiculo = vehiculoTestDataBuilder.conPlaca("ACR456").build();  
		
		Vigilante vigilante = new Vigilante();
		
		//act
		boolean placaInvalida = vigilante.validarPlaca(vehiculo.getPlaca(),5);

		//assert
		assertFalse(placaInvalida);
		
	}
	
	@Test
	public void PlacaValidaMoto(){
		
		//arrange
		MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder();
		
		VehiculoEntity vehiculo = motoTestDataBuilder.conPlaca("REC545").build();  
		
		Vigilante vigilante = mock(Vigilante.class);
		
		//act
		boolean placaValida = vigilante.validarPlaca(vehiculo.getPlaca(),2);
		
		//assert
		assertTrue(placaValida);
		
	}
	
	@Test
	public void PlacaInvalidaMoto(){
		
		//arrange
		CarroTestDataBuilder vehiculoTestDataBuilder = new CarroTestDataBuilder();
		
		VehiculoEntity vehiculo = vehiculoTestDataBuilder.conPlaca("OIK884").build();  
		
		Vigilante vigilante = mock(Vigilante.class);
		
		//act
		boolean placaInvalida = vigilante.validarPlaca(vehiculo.getPlaca(),5);

		//assert
		assertFalse(placaInvalida);
		
	}


	@Test
	public void asignarCupoVehiculo(){
		
		//arrange				
		
		VehiculoEntity vehiculo = new CarroTestDataBuilder().conPlaca("ASA534").
				conCC("230").conColor("azul").build();
		
		String tipo_vehiculo = "carro";
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		//Registro registro = mock(Registro.class);

		when(parqueadero.validarCupoLibre(parqueadero,tipo_vehiculo)).thenReturn(true);
		
		Vigilante vigilante = new Vigilante();
				
		//act
		boolean asignado = vigilante.asignarCupoVehiculo(parqueadero,tipo_vehiculo);
		
		//assert
		assertTrue(asignado);

	}
	
	@Test
	public void retirarCupoVehiculo(){
		
		//arrange			
		VehiculoEntity vehiculo = new CarroTestDataBuilder().conPlaca("ASA534").build();
		
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = mock(Registro.class);
		String tipo_vehiculo = "carro";
			
		Vigilante vigilante = new Vigilante();
							
		//act
		boolean retirado = vigilante.retirarCupoVehiculo(parqueadero,tipo_vehiculo);
		
		
		//assert
		assertTrue(retirado);
		
	}
	
	@Test
	public void calcularCosto(){
		
		//arrange
		CarroTestDataBuilder vehiculoTestDataBuilder = new CarroTestDataBuilder();
				
		Parqueadero parqueadero = mock(Parqueadero.class);
		RegistroEntity registro = mock(RegistroEntity.class);
		String tipo_vehiculo = "carro";
		
		VehiculoEntity vehiculo = vehiculoTestDataBuilder.conPlaca("RES342").build();  
				
		Vigilante vigilante = new Vigilante();
					
		//when(registro.obtener(vehiculo.getPlaca())).thenReturn(registro);

		//act
		double valor =vigilante.cobrar(registro,tipo_vehiculo);
		
		//assert
		assertThat(valor);
		
	}
	
	@Test
	public void validarCupoLibre(){
		
		

	}
	
	@Test
	public void cobrar(){
		
		

	}
	

	@Test
	public void determinarTiempo(){
		
		

	}
	
	@Test
	public void determinarCostoTotal(){
		
		

	}
	
	@Test
	public void validarCc(){
		
		

	}
	
	
	
	

}
