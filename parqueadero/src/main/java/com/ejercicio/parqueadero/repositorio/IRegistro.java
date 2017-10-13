package com.ejercicio.parqueadero.repositorio;

import java.util.ArrayList;

import com.ejercicio.parqueadero.modelo.Registro;

public interface IRegistro {

		/**
		 * Permite obtener todos los Registros de un vehiculo dada una placa
		 * @param placa
		 * @return
		 */
		ArrayList<Registro>	obtenerRegistrosPorPlaca(String placa);
		
		/**
		 * Permite agregar un registro al repositorio de registros de vehiculos
		 * @param registro
		 */
		void agregar(Registro registro);
		
		/**
		 * Permite obtener el registro mas reciente por la placa de un vehiculo
		 * @param placa
		 */
		Registro obtener(String placa);


}
