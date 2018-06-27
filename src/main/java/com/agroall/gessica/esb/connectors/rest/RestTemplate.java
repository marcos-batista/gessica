package com.agroall.gessica.esb.connectors.rest;

public interface RestTemplate {
	
	public RestTemplate get();
	
	public RestTemplate post();
	
	public RestTemplate put();
	
	public RestTemplate delete();
	
	public RestTemplate resource(String resourcePath);
	
	public RestTemplate inHost(String host);
	
	public RestTemplate addingRequestProperty(String propertyName, String propertyValue);
	
	public Object consumes();
	
}
