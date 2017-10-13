package com.ejercicio.parqueadero.repositorio;

import java.util.ArrayList;

import com.ejercicio.parqueadero.modelo.Vehiculo;

public interface IParqueadero {
	
	
	final int VALOR_HORA_CARRO = 1000;
	final int VALOR_HORA_MOTO = 500;
	final int VALOR_DIA_CARRO = 8000;
	final int VALOR_DIA_MOTO = 600;
	final int VALOR_ADICIONAL_MOTO = 600;
	
	final int CUPOS_MAX_CARRO = 20;
	final int CUPOS_MAX_MOTO = 10;

	/**
	 * Permite obtener los vehiculos que estan en el parqueadero
	 * @param
	 * @return
	 */
	ArrayList<Vehiculo> obtenerVehiculosParqueadero();

	
	/**
	 * Permite agregar un vehiculo al parqueadero
	 * @param vehiculo
	 */
	void agregarVehiculo(Vehiculo vehiculo);
	
	
	/**
	 * Permite agregar un vehiculo al parqueadero
	 * @param vehiculo
	 */
	void retirarVehiculo(Vehiculo vehiculo);
	
	
	/**
	 * Permite validar que hay cupo para moto en el parqueadero
	 * @param
	 */
	boolean validarCupoLibre();
	
	
	/*/**
	 * Permite validar si hay cupo para carro en el parqueadero
	 * @param
	 * 
	 * 	boolean validarCupoLibreCarro();
	 * 
	 */
	
	
	/**
	 * Permite obtener un vehiculo apartir de la placa
	 * @param
	 */
	Vehiculo obtenerVehiculoPorPlaca(String placa);
}
