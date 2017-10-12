package persistencia.repositorio;

import java.util.ArrayList;

import com.ejercicio.parqueadero.modelo.Vehiculo;
import com.ejercicio.parqueadero.repositorio.IParqueadero;

public class Parqueadero implements IParqueadero{

	int cupos_disponibles_carro = 0;
	int cupos_disponibles_moto = 0;
	

	public Parqueadero() {
		this.cupos_disponibles_carro = CUPOS_MAX_CARRO;
		this.cupos_disponibles_moto = CUPOS_MAX_MOTO;
	}
	

	public int getCupos_disponibles_carro() {
		return cupos_disponibles_carro;
	}


	public void setCupos_disponibles_carro(int cupos_disponibles_carro) {
		this.cupos_disponibles_carro = cupos_disponibles_carro;
	}



	public int getCupos_disponibles_moto() {
		return cupos_disponibles_moto;
	}



	public void setCupos_disponibles_moto(int cupos_disponibles_moto) {
		this.cupos_disponibles_moto = cupos_disponibles_moto;
	}



	@Override
	public ArrayList<Vehiculo> obtenerVehiculosParqueadero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void retirarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validarCupoLibre() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vehiculo obtenerVehiculoPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
