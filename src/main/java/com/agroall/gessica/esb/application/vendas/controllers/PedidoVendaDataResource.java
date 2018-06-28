package com.agroall.gessica.esb.application.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agroall.gessica.dataobjects.Venda;
import com.agroall.gessica.esb.application.vendas.services.VendaService;

@RestController
@CrossOrigin
@RequestMapping("/pedido")
public class PedidoVendaDataResource {
	
	@Autowired private VendaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Venda doGet() {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Venda doPost(@RequestBody Venda ordemVenda) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Venda doGet(@PathVariable(value = "id") String id) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Venda doPut(@PathVariable(value = "id") String id, @RequestBody Venda ordemVenda) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public Venda doDelete(Venda ordemVenda) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
}
