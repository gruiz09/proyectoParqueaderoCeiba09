package com.ejercicio.parqueadero.repositorio;

import persistencia.repositorio.Parqueadero;

public interface IParqueadero {
	
	
	final int VALOR_HORA_CARRO = 1000;
	final int VALOR_HORA_MOTO = 500;
	final int VALOR_DIA_CARRO = 8000;
	final int VALOR_DIA_MOTO = 600;
	final int VALOR_ADICIONAL_MOTO = 2000;
	
	final int CUPOS_MAX_CARRO = 20;
	final int CUPOS_MAX_MOTO = 10;

	/**
	 * Permite obtener los vehiculos que estan en el parqueadero
	 * @param
	 * @return
	 */
	//ArrayList<Vehiculo> obtenerVehiculosParqueadero();

	
	/**
	 * Permite agregar un vehiculo al parqueadero
	 * @param vehiculo
	 */
	boolean agregarVehiculo(Parqueadero parqueadero, String tipo_vehiculo);
	
	
	/**
	 * Permite agregar un vehiculo al parqueadero
	 * @param vehiculo
	 */
	boolean retirarVehiculo(Parqueadero parqueadero, String tipo_vehiculo);
	
	
	/**
	 * Permite validar que hay cupo para moto o carro en el parqueadero
	 * @param
	 */
	boolean validarCupoLibre(Parqueadero parqueadero, String tipo_vehiculo);
	
	
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
	//Vehiculo obtenerVehiculoPorPlaca(String placa);
}
