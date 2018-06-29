package com.agroall.gessica.esb.application.vendas.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agroall.gessica.esb.application.Addresses;
import com.agroall.gessica.esb.application.vendas.dataobjects.ItemVenda;
import com.agroall.gessica.esb.application.vendas.dataobjects.ProdutoComercial;
import com.agroall.gessica.esb.application.vendas.dataobjects.ProdutoInsumo;
import com.agroall.gessica.esb.application.vendas.dataobjects.Venda;
import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpring;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpringImpl;

@Service
public class OrdemVendaService {
	
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
		//---------------------------- UC informar venda realizada ----------------------------//
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		restTemplate
			.post()
			.resource("/venda")
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
			.settingBodyObject(venda)
		;
		((RestTemplateSpring) restTemplate).setResponseType(Venda.class);
		venda = (Venda) restTemplate.consumes();
		debitarEstoque(venda);
		return venda;
	}
	
	private void debitarEstoque(Venda venda) {
		//---------------------------- UC dar baixa no estoque --------------------------------//
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		List<ItemVenda> itensVenda = venda.getItens();
		for (ItemVenda itemVenda : itensVenda) {
			ProdutoComercial produtoComercial = itemVenda.getProdutoComercial();
			if(produtoComercial == null) continue;
			String codigoProdutoComercial = produtoComercial.getCodigo();
			int quantidadeProdutos = itemVenda.getQuantidadeProdutos();
			restTemplate
				.put()
				.resource("/produto/" + codigoProdutoComercial + "/estoque/debito/" + quantidadeProdutos)
				.inHost(Addresses.MODULE_ESTOQUE)
				.addingRequestProperty("Accept", "application/json")
				.settingBodyObject(new ProdutoInsumo())
			;
			((RestTemplateSpring) restTemplate).setResponseType(ProdutoInsumo.class);
			restTemplate.consumes();
		}
	}
	
	public Venda updateVenda(Venda venda) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		String idVenda = venda.getId();
		restTemplate
			.put()
			.resource("/venda/".concat(idVenda))
			.inHost(Addresses.MODULE_VENDAS)
			.addingRequestProperty("Accept", "application/json")
			.settingBodyObject(venda)
		;
		
		((RestTemplateSpring) restTemplate).setResponseType(Venda.class);
		restTemplate.consumes();
		
		return getVenda(idVenda);
	}
	
	public Venda deleteVenda(String idVenda) {
//		RestTemplate restTemplate = new RestTemplateSpringImpl();
//		restTemplate
//			.delete()
//			.resource("/venda/".concat(idVenda))
//			.inHost(Addresses.MODULE_VENDAS)
//			.addingRequestProperty("Accept", "application/json")
//			.addingRequestProperty("Content-Type", "application/json")
//			.addingUrlParameter("id", idVenda)
//		;
//		restTemplate.consumes();
		return getNewVenda();
	}
	
}
