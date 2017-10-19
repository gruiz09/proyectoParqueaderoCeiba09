package persistencia.repositorio;

import com.ejercicio.parqueadero.repositorio.IParqueadero;

public class Parqueadero implements IParqueadero {

	int cupos_disponibles_carro = 0;
	int cupos_disponibles_moto = 0;

	public Parqueadero(int cupos_disponibles_carro, int cupos_disponibles_moto) {
		this.cupos_disponibles_carro = cupos_disponibles_carro;
		this.cupos_disponibles_moto = cupos_disponibles_moto;
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
	public boolean agregarVehiculo(Parqueadero parqueadero, String tipo_vehiculo) {

		if (tipo_vehiculo.equals("carro")) {
			parqueadero.setCupos_disponibles_carro(parqueadero.cupos_disponibles_carro-1);
			System.out.println("ingresado, cupos disp. carro : "+parqueadero.cupos_disponibles_carro  + "\n" );
			return true;
		} else {
			parqueadero.setCupos_disponibles_moto(parqueadero.cupos_disponibles_moto-1);
			System.out.println("ingresado, cupos disp. moto: "+parqueadero.cupos_disponibles_moto  + "\n" );

			return true;
		}
	}

	@Override
	public boolean retirarVehiculo(Parqueadero parqueadero, String tipo_vehiculo) {

		if (tipo_vehiculo.equals("carro")) {
			parqueadero.setCupos_disponibles_carro(parqueadero.cupos_disponibles_carro+1);
			System.out.println("retirado, cupos disp. carro : "+parqueadero.cupos_disponibles_carro  + "\n" );

			return true;
		} else {
			parqueadero.setCupos_disponibles_carro(parqueadero.cupos_disponibles_moto+1);
			System.out.println("retirado, cupos disp. moto : "+parqueadero.cupos_disponibles_carro  + "\n" );
			return true;
		}
	}

	@Override
	public boolean validarCupoLibre(Parqueadero parqueadero, String tipo_vehiculo) {

		if (tipo_vehiculo.equals("carro")) {
			System.out.println("validar cupo carro dispo:" + parqueadero.getCupos_disponibles_carro());
			return parqueadero.getCupos_disponibles_carro() > 0;
		} else {
			System.out.println("validar cupo moto dispo:" + parqueadero.getCupos_disponibles_moto());
			return parqueadero.getCupos_disponibles_moto() > 0;
		}

	}

}
