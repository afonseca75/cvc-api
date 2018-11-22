package br.com.cvc.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api.properties")
public class PropertiesConfig {

	private String basicEndpoint;

	public String getBasicEndpoint() {
		return basicEndpoint;
	}

	public void setBasicEndpoint(String basicEndpoint) {
		this.basicEndpoint = basicEndpoint;
	}

}
