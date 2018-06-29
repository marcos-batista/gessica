package com.agroall.gessica.esb.application.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agroall.gessica.esb.application.vendas.dataobjects.Venda;
import com.agroall.gessica.esb.application.vendas.services.OrdemVendaService;

@RestController
@CrossOrigin
@RequestMapping("/venda")
public class OrdemVendaDataResource {
	
	@Autowired private OrdemVendaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Venda doGet() {
		com.agroall.gessica.esb.application.vendas.dataobjects.Venda newVenda = this.service.getNewVenda();
		return newVenda;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Venda doPost(@RequestBody Venda ordemVenda) {
		Venda savedOrdemVenda = this.service.saveNewVenda(ordemVenda);
		return savedOrdemVenda;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Venda doGet(@PathVariable(value = "id") String id) {
		Venda foundVenda = this.service.getVenda(id);
		return foundVenda;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Venda doPut(@PathVariable(value = "id") String id, @RequestBody Venda venda) {
		Venda updatedVenda = this.service.updateVenda(venda);
		return updatedVenda;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public Venda doDelete(Venda ordemVenda) {
		String idVenda = ordemVenda.getId();
		Venda newVenda = this.service.deleteVenda(idVenda);
		return newVenda;
	}
	
}
