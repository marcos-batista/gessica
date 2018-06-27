package com.agroall.gessica.esb.application.vendas.services;

import org.springframework.stereotype.Service;

import com.agroall.gessica.esb.application.Addresses;
import com.agroall.gessica.esb.application.vendas.dataobjects.Cliente;
import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpring;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpringImpl;

@Service
public class ClienteService {
	
	public Cliente getNewCliente() {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get().resource("/cliente")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(Cliente.class);
		Object cliente = restTemplate.consumes();
		return (Cliente) cliente;
	}
	
}
