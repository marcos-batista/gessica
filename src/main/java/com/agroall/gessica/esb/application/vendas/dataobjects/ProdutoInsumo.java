package com.agroall.gessica.esb.application.vendas.dataobjects;

import com.agroall.gessica.dataobjects.aspects.Persistent;

public class ProdutoInsumo extends com.agroall.gessica.dataobjects.ProdutoInsumo implements Persistent<String> {
	
	private String id;
	private Double precoCalculado;
	private Long dataValidade;
	private boolean agrotoxico;
	private ProdutoEstoque estoque;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Double getPrecoCalculado() {
		return this.precoCalculado;
	}
	
	public void setPrecoCalculado(Double precoCalculado) {
		this.precoCalculado = precoCalculado;
	}
	
	public Long getDataValidade() {
		return dataValidade;
	}
	
	public void setDataValidade(Long dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public boolean isAgrotoxico() {
		return agrotoxico;
	}
	
	public void setAgrotoxico(boolean agrotoxico) {
		this.agrotoxico = agrotoxico;
	}
	
	public ProdutoEstoque getEstoque() {
		return estoque;
	}
	
	public void setEstoque(ProdutoEstoque estoque) {
		this.estoque = estoque;
	}
	
}
