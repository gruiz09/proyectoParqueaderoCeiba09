package com.ejercicio.parqueadero.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.parqueadero.modelo.Vigilante;

import persistencia.entidad.RegistroEntity;
import persistencia.entidad.VehiculoEntity;
import persistencia.repositorio.Parqueadero;
import persistencia.repositorio.RegistroRepository;
import persistencia.repositorio.VehiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	@Qualifier("registroJpaRepository")
	RegistroRepository registroRepository;

	@Autowired
	@Qualifier("vehiculoJpaRepository")
	VehiculoRepository vehiculoRepository;

	
	Vigilante vigilante = new Vigilante();

	// create
	@RequestMapping(value = "/{idVehiculo}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@PathVariable("idVehiculo") String idVehiculo) {
		System.out.println("Entra a esta peticion Save registro");
		
		RegistroEntity registro = new RegistroEntity();
		
		Parqueadero parqueadero = establecerParqueadero();
		
		VehiculoEntity vh = vehiculoRepository.findById(idVehiculo);

		boolean cupoLibre = vigilante.validarCupoLibre(parqueadero,vh.getTipo_vehiculo());

		if(cupoLibre){
			boolean placaAceptada = vigilante.validarPlaca(vh.getPlaca());
			if (placaAceptada) {
				registro.setVehiculo(vh);
				registro.setFecha_ingreso(new Date());
				registroRepository.save(registro);
				vigilante.asignarCupoVehiculo(parqueadero,vh.getTipo_vehiculo());
			}else{
				System.out.println("Placa Invalida para este dia");
			}
		}else{
			System.out.println("No hay Cupo para " + vh.getTipo_vehiculo());
		}
	}

	// read
	@RequestMapping(value = "/{id}")
	public ResponseEntity<RegistroEntity> read(@PathVariable("id") String id) {

		System.out.println("Entra a esta peticion Read Registro");

		RegistroEntity registro = registroRepository.findOne(id);

		if (registro == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(registro, HttpStatus.OK);
		}

	}

	// read
	@RequestMapping(value = "/all")
	public List<RegistroEntity> readAll() {
		System.out.println("Entra a esta peticion All Registro");

		return registroRepository.findAll();
	}

	// update
	@RequestMapping(value = "/salida/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") String id) {
		
		Parqueadero parqueadero = establecerParqueadero();

		System.out.println("Entra a esta peticion Update");

		RegistroEntity registro = registroRepository.findById(id);

		VehiculoEntity vehiculo = vehiculoRepository.findByPlaca(registro.getVehiculo().getPlaca());
		
		double adicional = vigilante.validarCc(vehiculo);

		registro.setFecha_salida(new Date());

		double valor = vigilante.cobrar(registro, vehiculo.getTipo_vehiculo());

		registro.setValor(valor + adicional);

		registroRepository.save(registro);
		
		vigilante.retirarCupoVehiculo(parqueadero,vehiculo.getTipo_vehiculo());

	}

	// delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		System.out.println("Entra a esta peticion Delete");
		registroRepository.delete(id);
	}

	public Parqueadero establecerParqueadero() {
		
		int cuposOcupadosMoto = 0;
		int cuposOcupadosCarro = 0;
		
		List<RegistroEntity> listaRegistros = registroRepository.findAll();
		
		for (RegistroEntity registroEntity : listaRegistros) {
			
			if (registroEntity.getFecha_salida() == null){
				
				if(registroEntity.getVehiculo().getTipo_vehiculo().equals("carro")){
					++cuposOcupadosCarro;
				}else{
					++cuposOcupadosMoto;
				}
			}
		}
		
		Parqueadero parqueadero = new Parqueadero(Parqueadero.CUPOS_MAX_CARRO-cuposOcupadosCarro,Parqueadero.CUPOS_MAX_MOTO-cuposOcupadosMoto);
		System.out.println("cupos disponibles Carro: " + parqueadero.getCupos_disponibles_carro() + 
				" - cupos disponibles Moto :" + parqueadero.getCupos_disponibles_moto() + "\n" );
		return parqueadero;
	}

}
