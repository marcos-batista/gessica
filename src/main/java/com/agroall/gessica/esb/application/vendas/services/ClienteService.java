package com.agroall.gessica.esb.application.vendas.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.agroall.gessica.esb.application.Addresses;
import com.agroall.gessica.esb.application.vendas.dataobjects.Cliente;
import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpring;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpringImpl;

@Service
public class ClienteService {
	
	public Collection<Cliente> listClientes(){
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	public Cliente getNewCliente() {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/cliente")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(Cliente.class);
		Object cliente = restTemplate.consumes();
		return (Cliente) cliente;
	}
	
	public Cliente getCliente(String idCliente) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/cliente/".concat(idCliente))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(Cliente.class);
		Object cliente = restTemplate.consumes();
		return (Cliente) cliente;
	}
	
	public Cliente saveNewCliente(Cliente cliente) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		restTemplate
			.post()
			.resource("/cliente")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
			.settingBodyObject(cliente)
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Cliente.class);
		cliente = (Cliente) restTemplate.consumes();
		return cliente;
		
	}
	
	public Cliente updateCliente(Cliente cliente) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		String idCliente = cliente.getId();
		restTemplate
			.put()
			.resource("/cliente/".concat(idCliente))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
			.settingBodyObject(cliente)
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Cliente.class);
		restTemplate.consumes();
		
		return getCliente(idCliente);
	}
	
	public Cliente deleteCliente(String idCliente) {
//		RestTemplate restTemplate = new RestTemplateSpringImpl();
//		restTemplate
//			.delete()
//			.resource("/cliente/".concat(idCliente))
//			.inHost(Addresses.MODULE_VENDAS)
//			.addingRequestProperty("Accept", "application/json")
//			.addingRequestProperty("Content-Type", "application/json")
//			.addingUrlParameter("id", idCliente)
//		;
//		restTemplate.consumes();
		return getNewCliente();
	}
	
}
