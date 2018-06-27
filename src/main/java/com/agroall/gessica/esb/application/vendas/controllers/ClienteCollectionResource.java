package com.agroall.gessica.esb.application.vendas.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agroall.gessica.controllers.DataCollectionResourceControllerImpl;
import com.agroall.gessica.dataobjects.Cliente;
import com.agroall.gessica.services.Service;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteCollectionResource extends DataCollectionResourceControllerImpl<Cliente> {
	
//	@Autowired private ClienteService service;
	
	@Override
	protected Service<Cliente> getService() {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Cliente> doList() {
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
}
