package persistencia.entidad;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ejercicio.parqueadero.modelo.Vehiculo;

@Document(collection = "Registro")
public class RegistroEntity {
	
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		private String id;
		private Date fecha_ingreso;
		private Date fecha_salida;
		private double valor;

		
		//@CascadeSave
		@DBRef
		private VehiculoEntity vehiculo;

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
		
		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public VehiculoEntity getVehiculo() {
			return vehiculo;
		}

		public void setVehiculo(VehiculoEntity vehiculo) {
			this.vehiculo = vehiculo;
		}
	

}
