package com.agroall.gessica.esb.connectors.rest;

public interface RestTemplateSpring extends RestTemplate {
	
	@Override
	public RestTemplateSpring get();
	
	@Override
	public RestTemplateSpring post();
	
	@Override
	public RestTemplateSpring put();
	
	@Override
	public RestTemplateSpring delete();
	
	@Override
	public RestTemplateSpring resource(String resourcePath);
	
	@Override
	public RestTemplateSpring inHost(String host);
	
	@Override
	public RestTemplateSpring addingRequestProperty(String propertyName, String propertyValue);
	
	public <T> RestTemplateSpring setResponseType(Class<T> responseType);
	
}
