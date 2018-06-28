package com.agroall.gessica.esb.application.vendas.dataobjects;

public class ItemVenda extends com.agroall.gessica.dataobjects.ItemVenda {
	
	private ProdutoComercial produto;
	
	public ProdutoComercial getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutoComercial produto) {
		this.produto = produto;
	}
	
}
