package com.agroall.gessica.esb.connectors.rest;

public class RestTemplateSpringImpl extends RestTemplateImpl implements RestTemplateSpring {
	
	private Class<?> responseType;
	
	@Override
	public RestTemplateSpring get() {
		super.get();
		return this;
	}
	
	@Override
	public RestTemplateSpring post() {
		super.post();
		return this;
	}

	@Override
	public RestTemplateSpring put() {
		super.put();
		return this;
	}

	@Override
	public RestTemplateSpring delete() {
		super.delete();
		return this;
	}

	@Override
	public RestTemplateSpring resource(String resourcePath) {
		super.resource(resourcePath);
		return this;
	}

	@Override
	public RestTemplateSpring inHost(String host) {
		super.inHost(host);
		return this;
	}

	@Override
	public RestTemplateSpring addingRequestProperty(String propertyName, String propertyValue) {
		super.addingRequestProperty(propertyName, propertyValue);
		return this;
	}

	@Override
	public <T> RestTemplateSpring setResponseType(Class<T> responseType) {
		this.responseType = responseType;
		return this;
	}
	
	@Override
	public Object consumes() {
		org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
		String endpoint = getHost().concat(getResourcePath());
		Object responseObject = restTemplate.getForObject(endpoint, this.responseType);
		return responseObject;
	}
	
}
