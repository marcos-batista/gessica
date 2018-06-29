package com.agroall.gessica.esb.application.vendas.dataobjects;

import java.util.List;

import com.agroall.gessica.dataobjects.aspects.Persistent;

public class Venda extends com.agroall.gessica.dataobjects.Venda implements Persistent<String> {
	
	private String id;
	private Double precoCalculado;
	
	private List<ItemVenda> itens;
	private Cliente cliente;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Double getPrecoCalculado() {
		return precoCalculado;
	}
	
	public void setPrecoCalculado(Double precoCalculado) {
		this.precoCalculado = precoCalculado;
	}
	
	public List<ItemVenda> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
