package com.agroall.gessica.esb.application.vendas.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.agroall.gessica.dataobjects.Produto;
import com.agroall.gessica.esb.application.Addresses;
import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpring;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpringImpl;

@Service
public class ProdutoService {
	
	public Collection<Produto> listProdutos(){
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	public Produto getNewProduto() {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/produto")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(Produto.class);
		Object produto = restTemplate.consumes();
		return (Produto) produto;
	}
	
	public Produto getProduto(String idProduto) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/produto/".concat(idProduto))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(Produto.class);
		Object produto = restTemplate.consumes();
		return (Produto) produto;
	}
	
	public Produto saveNewProduto(Produto produto) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		//TODO: descobrir como setar o payload no RestTemplate
		restTemplate
			.post()
			.resource("/produto")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Produto.class);
		produto = (Produto) restTemplate.consumes();
		return produto;
		
	}
	
	public Produto updateProduto(Produto produto) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		//TODO: descobrir como setar o payload no RestTemplate
		restTemplate
			.put()
			.resource("/produto")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Produto.class);
		produto = (Produto) restTemplate.consumes();
		return produto;
	}
	
	public Produto deleteProduto(String idProduto) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		restTemplate
			.delete()
			.resource("/produto/".concat(idProduto))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Produto.class);
		Object produto = (Produto) restTemplate.consumes();
		return (Produto) produto;
	}
	
}
