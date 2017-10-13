package com.ejercicio.parqueadero.modelo;


import com.ejercicio.parqueadero.repositorio.IParqueadero;
import com.ejercicio.parqueadero.repositorio.IRegistro;

public class Vigilante {

	public static final String NO_HAY_CUPO_DISPONIBLE = "No hay cupo disponible para {0}";
	
	private IParqueadero parqueadero;
	private IRegistro registroCarros;
	

	public Vigilante(IParqueadero parqueadero, IRegistro registro) {
		this.parqueadero = parqueadero;
		this.registroCarros = registro;
	}

	
	public void asignarCupoVehiculo(String placa){
		
	
	}
	
	public void retirarCupoVehiculo(String placa){
		
	
		
	}
	
	public void calcularCosto(String placa){
		
	
		
	}
	
	public boolean validarPlaca(String placa){
		
		return true;
	}
	
	public boolean validarCcMoto(){
		
		return true;
	}
	
	
	
	
	

	

}
