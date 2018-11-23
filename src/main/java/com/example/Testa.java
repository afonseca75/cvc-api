package com.example;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.api.model.Hotel;

public class Testa {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			Hotel[] hoteis = restTemplate.getForObject("https://cvcbackendhotel.herokuapp.com/hotels/avail/1032", Hotel[].class);
			for (Hotel hotel : hoteis) {
				System.out.println(hotel);
			}
		} catch (RestClientException e) {
			 System.out.println(e.getMessage());
		}
//		System.out.println(hotel);
		

	}

}
