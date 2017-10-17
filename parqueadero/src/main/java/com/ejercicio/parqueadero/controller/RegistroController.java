package com.ejercicio.parqueadero.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.parqueadero.modelo.Vigilante;

import persistencia.entidad.RegistroEntity;
import persistencia.entidad.VehiculoEntity;
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
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody String idVehiculo) {
		System.out.println("Entra a esta peticion Save registro");
		
		//VehiculoEntity vh = new VehiculoEntity();
		VehiculoEntity vh = vehiculoRepository.findById("59e671dae9d9ce1e58efd34f");
		//vh.setId("59e617fde9d9ce18f0cf79f7");
		//vh.setPlaca("ADR567");
		//vh.setTipo_carro("Automovil");
		
		RegistroEntity registro = new RegistroEntity();
		registro.setVehiculo(vh);

		boolean aceptado = vigilante.validarPlaca(registro.getVehiculo().getPlaca());

		if (aceptado) {
			registro.setFecha_ingreso(new Date());
			registroRepository.save(registro);
		}else{
			System.out.println("Placa Invalida");
		}
	}

	// read
	@RequestMapping(value = "/{placa}")
	public ResponseEntity<RegistroEntity> read(@PathVariable("placa") String placa) {
		
		System.out.println("Entra a esta peticion Read Registro");

		RegistroEntity registro = registroRepository.findOne(placa);
		
		if(registro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(registro, HttpStatus.OK);
        }
		
	}

	// read
	@RequestMapping(value = "/all")
	public List<RegistroEntity> readAll() {
		System.out.println("Entra a esta peticion all Registro");
		return registroRepository.findAll();
	}

	// update
	@RequestMapping(value = "/salida/{placa}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("placa") String placa) {
		System.out.println("Entra a esta peticion Update");
	
		RegistroEntity registro = registroRepository.findById(placa);
		
		VehiculoEntity vehiculo = vehiculoRepository.findByPlaca(placa);
		
		//double adicional = vigilante.validarCc(vehiculo);
		
		registro.setFecha_salida(new Date());
		
		double valor = vigilante.calcularCosto(registro);
		
		//registro.setValor(valor + adicional);
		registro.setValor(valor + 0);
		
		registroRepository.save(registro);
		
		
	}

	// delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		System.out.println("Entra a esta peticion Delete");
		registroRepository.delete(id);
	}

}
