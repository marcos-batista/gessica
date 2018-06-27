package com.agroall.gessica.esb.todelete;

import com.agroall.gessica.esb.connectors.rest.RestTemplate;
import com.agroall.gessica.esb.connectors.rest.RestTemplateSingleHttpImpl;

public class Test {
	
	public static void main(String[] args) {
//		RestTemplate restTemplate = new RestTemplate();
//		Cliente cliente = restTemplate.getForObject("https://gessica-module-vendas.herokuapp.com/cliente/5b2581af4e62170004dda81a", Cliente.class);
//		System.out.println(cliente.toString());
		
		RestTemplate rest = new RestTemplateSingleHttpImpl();
		rest
			.get()
			.resource("/produto/5b302e5a20ce601524e26bcf")
			.inHost("https://gessica-module-estoque.herokuapp.com")
			.addingRequestProperty("Accept", "application/json")
		;
		
		Object response = rest.consumes();
		String responseAsString = (String) response;
		
		System.out.println(responseAsString);
		
	}
	
}
