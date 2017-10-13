package com.ejercicio.parqueadero.modelo;

import java.util.Calendar;

import com.ejercicio.parqueadero.repositorio.IParqueadero;
import com.ejercicio.parqueadero.repositorio.IRegistro;

public class Vigilante {

	public static final String NO_HAY_CUPO_DISPONIBLE = "No hay cupo disponible para {0}";

	private IParqueadero parqueadero;
	private IRegistro registroVehiculos;

	public Vigilante(IParqueadero parqueadero, IRegistro registro) {
		this.parqueadero = parqueadero;
		this.registroVehiculos = registro;
	}

	public boolean asignarCupoVehiculo(Vehiculo vehiculo) {

		parqueadero.agregarVehiculo(vehiculo);
		Registro registro = new Registro(vehiculo);
		registroVehiculos.agregar(registro);
		return true;
	}

	public boolean retirarCupoVehiculo(String placa) {

		return true;
	}

	public double calcularCosto(String placa) {

		return 0;
	}

	public boolean validarPlaca(String placa){
		
		int dia = Calendar.DAY_OF_WEEK;
		char primerLetraPlaca = placa.toUpperCase().charAt(0);
		
		if (primerLetraPlaca == 'A'){
			if (dia != 2 | dia != 7){
				return false;
			}
		}
		
		return true;
		
	}

	public boolean validarCcMoto(String placa) {

		return true;
	}

}
