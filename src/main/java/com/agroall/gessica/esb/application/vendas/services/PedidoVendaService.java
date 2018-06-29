package com.agroall.gessica.esb.application.vendas.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroall.gessica.esb.application.Addresses;
import com.agroall.gessica.esb.application.vendas.dataobjects.ItemVenda;
import com.agroall.gessica.esb.application.vendas.dataobjects.ProdutoComercial;
import com.agroall.gessica.esb.application.vendas.dataobjects.ProdutoEstoque;
import com.agroall.gessica.esb.application.vendas.dataobjects.ProdutoInsumo;
import com.agroall.gessica.esb.application.vendas.dataobjects.Venda;
import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpring;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSpringImpl;

@Service
public class PedidoVendaService {
	
	@Autowired private OrdemVendaService ordemVendaService;
	
	public Collection<Venda> listVendas(){
		throw new RuntimeException("NOT IMPLEMENTED YET");
	}
	
	public Venda getNewVenda() {
		return this.ordemVendaService.getNewVenda();
	}
	
	public Venda getVenda(String idVenda) {
		return this.ordemVendaService.getVenda(idVenda);
	}
	
	public Venda saveNewVenda(Venda venda) {
		verificarDisponibilidadeProduto(venda);
		return this.ordemVendaService.saveNewVenda(venda);
	}
	
	private void verificarDisponibilidadeProduto(Venda venda) {
		RestTemplate restTemplate = new RestTemplateSpringImpl();
		
		List<ItemVenda> itensVenda = venda.getItens();
		for (ItemVenda itemVenda : itensVenda) {
			ProdutoComercial produtoComercial = itemVenda.getProdutoComercial();
			if(produtoComercial == null) continue;
			
			String codigoProdutoComercial = produtoComercial.getCodigo();
			restTemplate
				.get()
				.resource("/produto/".concat(codigoProdutoComercial))
				.inHost(Addresses.MODULE_ESTOQUE)
				.addingRequestProperty("Accept", "application/json")
			;
			
			((RestTemplateSpring) restTemplate).setResponseType(ProdutoInsumo.class);
			Object retorno = restTemplate.consumes();
			
			if(retorno == null) {
				throw new RuntimeException("Não foi encontrado no estoque nenhum produto com id " + codigoProdutoComercial);
			}
			
			ProdutoInsumo produtoInsumo = (ProdutoInsumo) retorno;
			ProdutoEstoque estoque = produtoInsumo.getEstoque();
			
			if(estoque == null) { continue; }
			if(estoque.getQuantidadeAtual() <= 0) {
				throw new RuntimeException("Não há produtos disponíveis no estoque para atender a este pedido.");
			}
			
		}
	}
	
	public Venda updateVenda(Venda venda) {
		return this.ordemVendaService.updateVenda(venda);
	}
	
	public Venda deleteVenda(String idVenda) {
		return this.ordemVendaService.deleteVenda(idVenda);
	}
	
}
