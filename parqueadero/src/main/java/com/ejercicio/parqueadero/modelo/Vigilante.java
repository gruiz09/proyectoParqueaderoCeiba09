package com.ejercicio.parqueadero.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ejercicio.parqueadero.repositorio.IParqueadero;
import com.ejercicio.parqueadero.repositorio.IRegistro;

import persistencia.entidad.RegistroEntity;
import persistencia.entidad.VehiculoEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vigilante {

	public static final String NO_HAY_CUPO_DISPONIBLE = "No hay cupo disponible para {0}";

	DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");


	public Vigilante() {

	}

	public boolean asignarCupoVehiculo(Vehiculo vehiculo) {

		
		
		return true;
	}

	public boolean retirarCupoVehiculo(String placa) {

		return true;
	}

	public double calcularCosto(RegistroEntity registro) {

		Date fechaSalida = new Date();
        //Date fechaIngreso = registro.getFecha_ingreso(); arreglar
		Date fechaIngreso = new Date();
		
        //formatoHora.format(registro.getFecha_ingreso()+" de fecha: "+formatoFecha.format(registro.getFecha_ingreso()));

      //  formatoHora.format(registro.getFecha_ingreso()+" de fecha: "+formatoFecha.format(registro.getFecha_ingreso()));

        long diferenciaFechas = fechaSalida.getTime() - fechaIngreso.getTime();
        long dias = diferenciaFechas / (1000 * 60 * 60 * 24);
       
        String hora_min_ingreso[] = formatoHora.format(fechaSalida).toString().split(":");
        String hora_min_salida[] = formatoHora.format(fechaIngreso).toString().split(":");

        int horas = Integer.parseInt(hora_min_ingreso[0]) - Integer.parseInt(hora_min_salida[0]);
        int minutos = Integer.parseInt(hora_min_ingreso[1]) - Integer.parseInt(hora_min_salida[1]);

		double valor = determinarCostoTotal(dias, horas, minutos);
		
		return valor;
	}
	
	public double determinarCostoTotal(long dias, int horas, int minutos) {

		
		
		return 52000;
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

	public double validarCc(VehiculoEntity vehiculo) {
		
		if (Integer.parseInt(vehiculo.getCc()) > 500){
			return 2000;
		}

		return 0;
	}

}
