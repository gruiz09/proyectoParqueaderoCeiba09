
package persistencia.entidad;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Vehiculo")
public class VehiculoEntity {
	
	//Base Vehiculo
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private String id; 
	private String placa;
	private String color;
	private String cc;
	//Especificacion Moto
	private int tipo_encendido;
	//Especificacion Carro
	private int numero_puertas;
	private String tipo_carro;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTipo_encendido() {
		return tipo_encendido;
	}

	public void setTipo_encendido(int tipo_encendido) {
		this.tipo_encendido = tipo_encendido;
	}

	public int getNumero_puertas() {
		return numero_puertas;
	}

	public void setNumero_puertas(int numero_puertas) {
		this.numero_puertas = numero_puertas;
	}

	public String getTipo_carro() {
		return tipo_carro;
	}

	public void setTipo_carro(String tipo_carro) {
		this.tipo_carro = tipo_carro;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "VehiculoEntity [id=" + id + ", placa=" + placa + ", color=" + color + ", cc=" + cc + ", tipo_encendido="
				+ tipo_encendido + ", numero_puertas=" + numero_puertas + ", tipo_carro=" + tipo_carro + "]";
	}


	

	


}
