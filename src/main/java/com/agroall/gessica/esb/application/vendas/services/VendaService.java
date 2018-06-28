package com.agroall.gessica.esb.application.vendas.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.agroall.gessica.esb.application.Addresses;
import com.agroall.gessica.esb.application.vendas.dataobjects.Venda;
import com.agroall.gessica.esb.application.vendas.dataobjects.Venda;
import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpring;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpringImpl;

@Service
public class VendaService {
	
	public Collection<Venda> listVendas(){
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	public Venda getNewVenda() {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/venda")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(Venda.class);
		Object venda = restTemplate.consumes();
		return (Venda) venda;
	}
	
	public Venda getVenda(String idVenda) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/venda/".concat(idVenda))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(Venda.class);
		Object venda = restTemplate.consumes();
		return (Venda) venda;
	}
	
	public Venda saveNewVenda(Venda venda) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		//TODO: descobrir como setar o payload no RestTemplate
		restTemplate
			.post()
			.resource("/venda")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Venda.class);
		venda = (Venda) restTemplate.consumes();
		return venda;
		
	}
	
	public Venda updateVenda(Venda venda) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		//TODO: descobrir como setar o payload no RestTemplate
		restTemplate
			.put()
			.resource("/venda")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Venda.class);
		venda = (Venda) restTemplate.consumes();
		return venda;
	}
	
	public Venda deleteVenda(String idVenda) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		restTemplate
			.delete()
			.resource("/venda/".concat(idVenda))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Venda.class);
		Object venda = (Venda) restTemplate.consumes();
		return (Venda) venda;
	}
	
}
