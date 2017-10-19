package com.ejercicio.parqueadero.modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import persistencia.entidad.RegistroEntity;
import persistencia.entidad.VehiculoEntity;
import persistencia.repositorio.Parqueadero;


import java.util.Date;

public class Vigilante {

	public static final String NO_HAY_CUPO_DISPONIBLE = "No hay cupo disponible para {0}";

	DateFormat formatoHora = new SimpleDateFormat("HH:mm");
    DateFormat formatoFecha = new SimpleDateFormat("MM/dd/yyyy");
 
	public Vigilante() {
		
	}

	public boolean asignarCupoVehiculo(Parqueadero parqueadero, String tipo_vehiculo) {

		return parqueadero.agregarVehiculo(parqueadero,tipo_vehiculo);
		
	}

	public boolean retirarCupoVehiculo(Parqueadero parqueadero, String tipo_vehiculo) {
		
		return parqueadero.retirarVehiculo(parqueadero, tipo_vehiculo);
		
	}
	
	public boolean validarCupoLibre(Parqueadero parqueadero, String tipo_vehiculo) {
		
		return parqueadero.validarCupoLibre(parqueadero,tipo_vehiculo);

	}
	

	public double cobrar(RegistroEntity registro, String tipo_vehiculo) {

		long tiempo [] = determinarTiempo(registro.getFecha_ingreso(), registro.getFecha_salida(), tipo_vehiculo);
  
		long horas = tiempo[0];
		long dias = tiempo[1];
		
        horas -= dias * 24;
        
        if(tipo_vehiculo.equals("carro")){
	        if(horas >= 9){
	        	++dias;
	        	horas = 0;
	        }
        }

		double valor = determinarCostoTotal(tipo_vehiculo, dias, horas);
		
		return valor;
	}
	
	public long[] determinarTiempo(Date fechaIngreso, Date fechaSalida, String tipo_vehiculo) {
		
		long fechaInicioMili, fechaFinMili, diferenciaMili;
		
		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFin = Calendar.getInstance();
		
		String fechaIngresoFormateada = formatoFecha.format(fechaIngreso) + " " + formatoHora.format(fechaIngreso);
		String fechaSalidaFormateada = formatoFecha.format(fechaSalida) + " " + formatoHora.format(fechaSalida);

		//fechaSalida = new Date("10/23/2017 23:45"); //para ejemplo
		fechaSalida = new Date(fechaSalidaFormateada);
		fechaIngreso = new Date(fechaIngresoFormateada);
		
		calendarInicio.setTime(fechaIngreso);
		calendarFin.setTime(fechaSalida);
		
		fechaInicioMili = calendarInicio.getTimeInMillis();
		fechaFinMili = calendarFin.getTimeInMillis();
        diferenciaMili = fechaFinMili-fechaInicioMili;
        
        long horas =   (diferenciaMili / (60 * 60 * 1000));
        long dias = Math.abs ( diferenciaMili / (24 * 60 * 60 * 1000) );
		
		long tiempo [] = {horas,dias}; 
		
		return tiempo;
	}
	
	
	public double determinarCostoTotal(String tipo_vehiculo, long dias, long horas) {

		double total = 0;	
		
		if(tipo_vehiculo.equals("carro")){
			total = (dias * Parqueadero.VALOR_DIA_CARRO) + (horas * Parqueadero.VALOR_HORA_CARRO);  		
		}else{
			total = (dias * Parqueadero.VALOR_DIA_MOTO) + (horas * Parqueadero.VALOR_HORA_MOTO);	
		}
		
		System.out.println("tiempo a cobrar: dias " + dias + ", horas " + horas);
		
		return total;
	}
	
	

	public boolean validarPlaca(String placa, int dia){
		
		char primerLetraPlaca = placa.toUpperCase().charAt(0);
		
		if (primerLetraPlaca == 'A'){
			if (dia != 2 || dia != 7){
				return false;
			}
		}
		
		return true;
		
	}

	
	
	public double validarCc(VehiculoEntity vehiculo) {
		
		if(vehiculo.getTipo_vehiculo().equals("moto")){
			if (Integer.parseInt(vehiculo.getCc()) > 500){
				return 2000;
			}
		}
		
		return 0;
	}

}
