
package persistencia.entidad;

import org.springframework.data.annotation.Id;

public class VehiculoEntity {
	
	//Base Vehiculo
	@Id
	private String id; 
	private String placa;
	private String color;
	//Especificacion Moto
	private int tipo_encendido;
	//Especificacion Carro
	private int numero_puertas;
	private String tipo_carro;
	

	
	public VehiculoEntity(String id, String placa, String color, int tipo_encendido, int numero_puertas,
			String tipo_carro) {
		this.id = id;
		this.placa = placa;
		this.color = color;
		this.tipo_encendido = tipo_encendido;
		this.numero_puertas = numero_puertas;
		this.tipo_carro = tipo_carro;
	}
	
	/*public VehiculoEntity(String id, String placa, String color, int numero_puertas,
			String tipo_carro) {
		super();
		this.id = id;
		this.placa = placa;
		this.color = color;
		this.numero_puertas = numero_puertas;
		this.tipo_carro = tipo_carro;
	}*/
	
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

	@Override
	public String toString() {
		return "VehiculoEntity [id=" + id + ", placa=" + placa + ", color=" + color + ", tipo_encendido="
				+ tipo_encendido + ", numero_puertas=" + numero_puertas + ", tipo_carro=" + tipo_carro + "]";
	}

	


}
