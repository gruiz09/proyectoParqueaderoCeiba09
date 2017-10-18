package com.ejercicio.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

import persistencia.entidad.VehiculoEntity;
import persistencia.repositorio.VehiculoRepository;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

	@GetMapping("/helloworld")
	public @ResponseBody String helloWorld(){
		return "test";
	}
	
	@Autowired
	@Qualifier("vehiculoJpaRepository")
	VehiculoRepository vehiculoRepository;
	
	//create
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody VehiculoEntity vehiculo){
		System.out.println("Entra a esta peticion Save");
		vehiculoRepository.save(vehiculo);
	}
	
	//read
	@RequestMapping(value = "/{id}")
	public VehiculoEntity read(@PathVariable String id){
		System.out.println("Entra a esta peticion Read");
		return vehiculoRepository.findById(id);
	}
	
	//update
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody VehiculoEntity vehiculo){
		System.out.println("Entra a esta peticion Update");
		vehiculoRepository.save(vehiculo);		
	}
	
	//delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id){
		System.out.println("Entra a esta peticion Delete");
		vehiculoRepository.delete(id);
	}
	
}
