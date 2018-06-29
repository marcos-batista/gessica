package com.agroall.gessica.esb.connectors.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.web.client.RestClientException;

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
	public RestTemplate settingBodyObject(Object bodyObject) {
		super.settingBodyObject(bodyObject);
		return this;
	}

	@Override
	public <T> RestTemplateSpring setResponseType(Class<T> responseType) {
		this.responseType = responseType;
		return this;
	}
	
	@Override
	public Object consumes() {
		switch (getMethod())
		{
			case GET: return getForObject();
			case POST: return postForObject(getBodyObject());
			case PUT: return put(getBodyObject());
			case DELETE: return delete(getBodyObject());
			default: throw new RuntimeException("Http method was not identified.");
		}
	}
	
	private Object getForObject() {
		org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
		String endpoint = getHost().concat(getResourcePath());
		Object responseObject = restTemplate.getForObject(endpoint, this.responseType);
		return responseObject;
	}

	private <T> Object postForObject(T object) {
		org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
		String endpoint = getHost().concat(getResourcePath());
		Object responseObject = restTemplate.postForObject(endpoint, object, object.getClass());
		return responseObject;
	}
	
	private <T> Object put(T object) {
		org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
		String endpoint = getHost().concat(getResourcePath());
		restTemplate.put(endpoint, object);
		return object;
	}
	
	private <T> Object delete(T object) {
		org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
//		Map<String, String> urlParameters = getUrlParameters();
		String endpoint = getHost().concat(getResourcePath());
//		restTemplate.delete(endpoint, urlParameters);
		try
		{
			restTemplate.delete(new URI(endpoint));
		}
		catch(RestClientException | URISyntaxException e)
		{
			throw new RuntimeException(e);
		}
		return object;
	}
	
}
