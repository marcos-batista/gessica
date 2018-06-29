package com.agroall.gessica.esb.connectors.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;

public abstract class RestTemplateImpl implements RestTemplate {
	
	private String host;
	private String resourcePath;
	private HttpMethod method;
	private Map<String, String> requestProperties;
	private Map<String, String> urlParameters;
	private Map<String, String> queryParameters;
	private Object bodyObject;
	
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
	
	protected Map<String, String> getUrlParameters() {
		if(this.urlParameters == null) { this.urlParameters = factoryMapRequestProperties(); }
		return urlParameters;
	}
	
	protected Map<String, String> getQueryParameters() {
		if(this.queryParameters == null) { this.queryParameters = factoryMapRequestProperties(); }
		return queryParameters;
	}
	
	protected Object getBodyObject() {
		return bodyObject;
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
	
	@Override
	public RestTemplate addingUrlParameter(String parameterName, String parameterValue) {
		if(this.urlParameters == null) { this.urlParameters = factoryMapUrlParameters(); }
		this.urlParameters.put(parameterName, parameterValue);
		return this;
	}
	
	protected Map<String, String> factoryMapUrlParameters() {
		return new HashMap<String, String>();
	}
	
	@Override
	public RestTemplate addingQueryParameter(String parameterName, String parameterValue) {
		if(this.queryParameters == null) { this.queryParameters = factoryMapQueryParameters(); }
		this.queryParameters.put(parameterName, parameterValue);
		return this;
	}
	
	protected Map<String, String> factoryMapQueryParameters() {
		return new HashMap<String, String>();
	}
	
	public RestTemplate settingBodyObject(Object bodyObject) {
		this.bodyObject = bodyObject;
		return this;
	}
	
}
