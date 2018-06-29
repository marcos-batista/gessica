package com.agroall.gessica.esb.application.vendas.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.agroall.gessica.esb.application.Addresses;
import com.agroall.gessica.esb.application.vendas.dataobjects.ProdutoComercial;
import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpring;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpringImpl;

@Service
public class ProdutoService {
	
	public Collection<ProdutoComercial> listProdutos(){
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	public ProdutoComercial getNewProduto() {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/produto")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(ProdutoComercial.class);
		Object produto = restTemplate.consumes();
		return (ProdutoComercial) produto;
	}
	
	public ProdutoComercial getProduto(String idProduto) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.get()
			.resource("/produto/".concat(idProduto))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
		;
		((RestTemplateSpring) restTemplate).setResponseType(ProdutoComercial.class);
		Object produto = restTemplate.consumes();
		return (ProdutoComercial) produto;
	}
	
	public ProdutoComercial saveNewProduto(ProdutoComercial produto) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		restTemplate
			.post()
			.resource("/produto")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
			.settingBodyObject(produto)
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(ProdutoComercial.class);
		produto = (ProdutoComercial) restTemplate.consumes();
		return produto;
		
	}
	
	public ProdutoComercial updateProduto(ProdutoComercial produto) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		String idProduto = produto.getId();
		restTemplate
			.put()
			.resource("/produto/".concat(idProduto))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
			.settingBodyObject(produto)
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(ProdutoComercial.class);
		restTemplate.consumes();
		
		return getProduto(idProduto);
	}
	
	public ProdutoComercial deleteProduto(String idProduto) {
//		RestTemplate restTemplate = new RestTemplateSpringImpl();
//		restTemplate
//			.delete()
//			.resource("/produto/".concat(idProduto))
//			.inHost(Addresses.MODULE_VENDAS)
//			.addingRequestProperty("Accept", "application/json")
//			.addingRequestProperty("Content-Type", "application/json")
//			.addingUrlParameter("id", idProduto)
//		;
//		restTemplate.consumes();
		return getNewProduto();
	}
	
}
