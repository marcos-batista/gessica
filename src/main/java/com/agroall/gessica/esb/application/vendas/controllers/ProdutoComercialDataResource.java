package com.agroall.gessica.esb.application.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agroall.gessica.dataobjects.Produto;
import com.agroall.gessica.esb.application.vendas.services.ProdutoComercialService;

@RestController
@CrossOrigin
@RequestMapping("/produto")
public class ProdutoComercialDataResource {

	@Autowired private ProdutoComercialService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Produto doGet() {
		Produto newProduto = (Produto) this.service.getNewProduto();
		return newProduto;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Produto doPost(@RequestBody Produto produto) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produto doGet(@PathVariable(value = "id") String id) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Produto doPut(@PathVariable(value = "id") String id, @RequestBody Produto produto) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public Produto doDelete(Produto produto) {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
}
