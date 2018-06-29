package com.agroall.gessica.esb.application.vendas.dataobjects;

public class ItemVenda extends com.agroall.gessica.dataobjects.ItemVenda {
	
	private Double margemLucroItem;
	private Double descontoItem;
	
	private ProdutoComercial produtoComercial;
	
	public Double getMargemLucroItem() {
		return margemLucroItem;
	}
	
	public void setMargemLucroItem(Double margemLucroItem) {
		this.margemLucroItem = margemLucroItem;
	}
	
	public Double getDescontoItem() {
		return descontoItem;
	}
	
	public void setDescontoItem(Double descontoItem) {
		this.descontoItem = descontoItem;
	}
	
	public ProdutoComercial getProdutoComercial() {
		return this.produtoComercial;
	}
	
	public void setProdutoComercial(ProdutoComercial produtoComercial) {
		this.produtoComercial = produtoComercial;
	}
	
}
