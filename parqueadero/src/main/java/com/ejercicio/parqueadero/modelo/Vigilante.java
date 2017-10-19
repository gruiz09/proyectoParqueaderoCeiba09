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
    
    Parqueadero parqueadero;


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

		Calendar calendarInicio = Calendar.getInstance();
		Calendar calendarFin = Calendar.getInstance();
		long milis1, milis2, diff;
		
		Date fechaSalida = new Date("10/23/2017 13:45"); //para ejemplo
		
		
		calendarFin.setTime(fechaSalida);
		
		String fecha = formatoFecha.format(registro.getFecha_ingreso()) + " " + formatoHora.format(registro.getFecha_ingreso());
		
		Date fechaIngreso = new Date(fecha);
		
		calendarInicio.setTime(fechaIngreso);
		
		
		milis1 = calendarInicio.getTimeInMillis();
		 
        milis2 = calendarFin.getTimeInMillis();

        diff = milis2-milis1;
        
        //long minutos =  Math.abs (diff / (60 * 1000));
        long horas =   (diff / (60 * 60 * 1000));
        long dias = Math.abs ( diff / (24 * 60 * 60 * 1000) );
  
        horas -= dias * 24;
        
        if(tipo_vehiculo.equals("carro")){
	        if(horas >= 9){
	        	++dias;
	        	horas = 0;
	        }
        }
        
        //minutos -= horas * 60 + (dias * 1440);
    

		double valor = determinarCostoTotal(tipo_vehiculo, dias, horas);
		
		return valor;
	}
	
	public double determinarCostoTotal(String tipo_vehiculo, long dias, long horas) {

		
		double total = 0;	
		
		if(tipo_vehiculo.equals("carro")){
			
			/*if (minutos>30)
				horas++;*/
			
			total = (dias * Parqueadero.VALOR_DIA_CARRO) + (horas * Parqueadero.VALOR_HORA_CARRO);  
			
		}else{
			
			/*if (minutos>30)
				horas++;*/
			
			total = (dias * Parqueadero.VALOR_DIA_MOTO) + (horas * Parqueadero.VALOR_HORA_MOTO);
			
		}
		
		System.out.println("tiempo a cobrar: dias " + dias + ", horas " + horas);

		
		return total;
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
		
		if(vehiculo.getTipo_vehiculo().equals("moto")){
			if (Integer.parseInt(vehiculo.getCc()) > 500){
				return 2000;
			}
		}
		
		return 0;
	}

}
