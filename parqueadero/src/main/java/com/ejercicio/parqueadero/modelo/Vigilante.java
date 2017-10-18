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

	DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    
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
	

	public double calcularCosto(RegistroEntity registro, String tipo_vehiculo) {

		System.out.println("entra a calcular costo");
		Date fechaSalida = new Date("10/19/2017 18:00:25"); //rectificar y usar fechas reales
		Date fechaIngreso = new Date();
		//Date fechaIngreso = registro.getFecha_ingreso();
	
        long diferenciaFechas = fechaSalida.getTime() - fechaIngreso.getTime();
        long dias = diferenciaFechas / (1000 * 60 * 60 * 24);
       
        String hora_min_ingreso[] = formatoHora.format(fechaSalida).toString().split(":");
        String hora_min_salida[] = formatoHora.format(fechaIngreso).toString().split(":");

        int horas = Integer.parseInt(hora_min_ingreso[0]) - Integer.parseInt(hora_min_salida[0]);
        int minutos = Integer.parseInt(hora_min_ingreso[1]) - Integer.parseInt(hora_min_salida[1]);

		double valor = determinarCostoTotal(tipo_vehiculo, dias, horas, minutos);
		
		return valor;
	}
	
	public double determinarCostoTotal(String tipo_vehiculo, long dias, int horas, int minutos) {

		System.out.println("entra a determinar costo toal");

		System.out.println("dias " + dias + ", horas " + horas + ", minutos "+ minutos);
		
		double total = 0;	
		
		if(tipo_vehiculo.equals("carro")){
			
			if (minutos>30)
				horas++;
			
			total = (dias * 8000) + (horas * 1000);  
			
		}else{
			
			if (minutos>30)
				horas++;
			
			total = (dias * 600) + (horas * 500);
			
		}
		
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
		System.out.println("valida vehiculo");
		if(vehiculo.getTipo_vehiculo().equals("moto")){
			if (Integer.parseInt(vehiculo.getCc()) > 500){
				return 2000;
			}
		}
		
		return 0;
	}

}
