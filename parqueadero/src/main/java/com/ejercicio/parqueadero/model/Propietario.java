package com.ejercicio.parqueadero.model;

public class Propietario extends Persona {

	private String direccion;
	private String correo;
	
	public Propietario(String nombre, String apellido, String telefono, String direccion, String correo) {
		super(nombre, apellido, telefono);
		this.direccion = direccion;
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
