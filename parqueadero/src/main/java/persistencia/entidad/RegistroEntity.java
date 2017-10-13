package persistencia.entidad;

import java.util.Date;

import com.ejercicio.parqueadero.modelo.Vehiculo;

public class RegistroEntity {
	
		private String id;
		private Date fecha_ingreso;
		private Date fecha_salida;
		private int hora_ingreso;
		private int hora_salida;
		private Vehiculo vehiculo;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Date getFecha_ingreso() {
			return fecha_ingreso;
		}

		public void setFecha_ingreso(Date fecha_ingreso) {
			this.fecha_ingreso = fecha_ingreso;
		}

		public Date getFecha_salida() {
			return fecha_salida;
		}

		public void setFecha_salida(Date fecha_salida) {
			this.fecha_salida = fecha_salida;
		}

		public int getHora_ingreso() {
			return hora_ingreso;
		}

		public void setHora_ingreso(int hora_ingreso) {
			this.hora_ingreso = hora_ingreso;
		}

		public int getHora_salida() {
			return hora_salida;
		}

		public void setHora_salida(int hora_salida) {
			this.hora_salida = hora_salida;
		}

		public Vehiculo getVehiculo() {
			return vehiculo;
		}

		public void setVehiculo(Vehiculo vehiculo) {
			this.vehiculo = vehiculo;
		}
	

}