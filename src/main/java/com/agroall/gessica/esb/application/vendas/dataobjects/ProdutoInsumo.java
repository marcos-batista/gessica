package com.agroall.gessica.esb.application.vendas.dataobjects;

import com.agroall.gessica.dataobjects.aspects.Persistent;

public class ProdutoInsumo extends com.agroall.gessica.dataobjects.ProdutoInsumo implements Persistent<String> {
	
	private String id;
	private Double custoUnitario;
	private ProdutoEstoque estoque;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Double getCustoUnitario() {
		return custoUnitario;
	}
	
	public void setCustoUnitario(Double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	
	public ProdutoEstoque getEstoque() {
		return estoque;
	}
	
	public void setEstoque(ProdutoEstoque estoque) {
		this.estoque = estoque;
	}
	
}
