package com.agroall.gessica.esb.application.vendas.dataobjects;

import com.agroall.gessica.dataobjects.aspects.Persistent;

public class ProdutoComercial extends com.agroall.gessica.dataobjects.ProdutoComercial implements Persistent<String> {
	
	private String id;
	private Double margemLucroUnitario;
	private Double descontoUnitario;
	private Double precoCalculado;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Double getMargemLucroUnitario() {
		return this.margemLucroUnitario;
	}
	
	public void setMargemLucroUnitario(Double margemLucroUnitario) {
		this.margemLucroUnitario = margemLucroUnitario;
	}
	
	public Double getDescontoUnitario() {
		return this.descontoUnitario;
	}
	
	public void setDescontoUnitario(Double descontoUnitario) {
		this.descontoUnitario = descontoUnitario;
	}
	
	public Double getPrecoCalculado() {
		return this.precoCalculado;
	}
	
	public void setPrecoCalculado(Double precoCalculado) {
		this.precoCalculado = precoCalculado;
	}
	
}
