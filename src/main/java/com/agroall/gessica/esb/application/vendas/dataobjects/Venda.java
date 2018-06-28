package com.agroall.gessica.esb.application.vendas.dataobjects;

import java.util.List;

import com.agroall.gessica.dataobjects.aspects.Persistent;

public class Venda extends com.agroall.gessica.dataobjects.Venda implements Persistent<String> {
	
	private String id;
	
	private List<ItemVenda> itens;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<ItemVenda> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
	
}
