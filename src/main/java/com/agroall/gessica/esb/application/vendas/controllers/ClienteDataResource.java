package com.agroall.gessica.esb.application.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agroall.gessica.dataobjects.Cliente;
import com.agroall.gessica.esb.application.vendas.services.ClienteService;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteDataResource {

	@Autowired private ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Cliente doGet() {
		Cliente newCliente = (Cliente) this.service.getNewCliente();
		return newCliente;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Cliente doPost(@RequestBody Cliente cliente) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cliente doGet(@PathVariable(value = "id") String id) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Cliente doPut(@PathVariable(value = "id") String id, @RequestBody Cliente cliente) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public Cliente doDelete(Cliente cliente) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
}
