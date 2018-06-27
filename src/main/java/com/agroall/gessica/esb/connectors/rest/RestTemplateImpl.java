package com.agroall.gessica.esb.connectors.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;

public abstract class RestTemplateImpl implements RestTemplateSingleHttp {
	
	private String host;
	private String resourcePath;
	private HttpMethod method;
	private Map<String, String> requestProperties;
	
	protected String getHost() {
		return host;
	}
	
	protected String getResourcePath() {
		return resourcePath;
	}
	
	protected HttpMethod getMethod() {
		return method;
	}
	
	protected Map<String, String> getRequestProperties() {
		if(this.requestProperties == null) { this.requestProperties = factoryMapRequestProperties(); }
		return requestProperties;
	}
	
	@Override
	public RestTemplate get() {
		this.method = HttpMethod.GET;
		return this;
	}

	@Override
	public RestTemplate post() {
		this.method = HttpMethod.POST;
		return this;
	}

	@Override
	public RestTemplate put() {
		this.method = HttpMethod.PUT;
		return this;
	}

	@Override
	public RestTemplate delete() {
		this.method = HttpMethod.DELETE;
		return this;
	}

	@Override
	public RestTemplate resource(String resourcePath) {
		this.resourcePath = resourcePath;
		return this;
	}

	@Override
	public RestTemplate inHost(String host) {
		this.host = host;
		return this;
	}
	
	@Override
	public RestTemplate addingRequestProperty(String propertyName, String propertyValue) {
		if(this.requestProperties == null) { this.requestProperties = factoryMapRequestProperties(); }
		this.requestProperties.put(propertyName, propertyValue);
		return this;
	}
	
	protected Map<String, String> factoryMapRequestProperties() {
		return new HashMap<String, String>();
	}
	
}
