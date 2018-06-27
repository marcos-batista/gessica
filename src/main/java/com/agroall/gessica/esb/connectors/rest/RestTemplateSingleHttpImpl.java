package com.agroall.gessica.esb.connectors.rest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestTemplateSingleHttpImpl extends RestTemplateImpl implements RestTemplateSingleHttp {
	
	private URL endpoint;
	
	protected URL getEndpoint() {
		return this.endpoint;
	}
	
	@Override
	public RestTemplate resource(String resourcePath) {
		super.resource(resourcePath);
		factoryEndpoint();
		return this;
	}

	@Override
	public RestTemplate inHost(String host) {
		super.inHost(host);
		factoryEndpoint();
		return this;
	}
	
	private void factoryEndpoint() {
		try
		{
			if(getHost() == null || getHost().trim().isEmpty()) return;
			String endpoint = getHost();
			
			if(getResourcePath() == null || getResourcePath().trim().isEmpty()) return;
			endpoint = getHost().concat(getResourcePath());
			
			this.endpoint = new URL(endpoint);
			
		}
		catch (MalformedURLException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object consumes() {
		try
		{
			HttpURLConnection httpURLConnection = (HttpURLConnection) this.endpoint.openConnection();
			httpURLConnection.setRequestMethod(getMethod().toString());
			
			for (String propertyName : getRequestProperties().keySet()) {
				String propertyValue = getRequestProperties().get(propertyName);
				httpURLConnection.setRequestProperty(propertyName, propertyValue);
			}
			
			//if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
			//    throw new RuntimeException("Failed : HTTP error code : " + httpURLConnection.getResponseCode());
			//}
			
			Reader reader = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
			StringBuilder response = new StringBuilder();
			
			char[] tmp = new char[1024]; int l;
            
			while ((l = reader.read(tmp)) != -1) {
                response.append(tmp, 0, l);
            }
			
			httpURLConnection.disconnect();
			
			return response.toString();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
}
