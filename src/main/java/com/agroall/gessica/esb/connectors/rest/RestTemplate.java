package com.agroall.gessica.esb.connectors.rest;

public interface RestTemplate {
	
	public RestTemplate get();
	
	public RestTemplate post();
	
	public RestTemplate put();
	
	public RestTemplate delete();
	
	public RestTemplate resource(String resourcePath);
	
	public RestTemplate inHost(String host);
	
	public RestTemplate addingRequestProperty(String propertyName, String propertyValue);

	public RestTemplate settingBodyObject(Object bodyObject);
	
	public RestTemplate addingUrlParameter(String parameterName, String parameterValue);
	
	public RestTemplate addingQueryParameter(String parameterName, String parameterValue);
	
	public Object consumes();
	
}
