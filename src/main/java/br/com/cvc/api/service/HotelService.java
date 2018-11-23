package br.com.cvc.api.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.api.model.Hotel;

@Component
public class HotelService {
	private static final String BASIC_URL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	RestTemplate template = new RestTemplate();

	public Hotel findById(int idHotel) {
		String url = BASIC_URL + idHotel;
		return template.getForObject(url, Hotel[].class)[0];
	}

	public Hotel[] findAllAvailableByIdCidade(int idCidade) {
		String url = BASIC_URL + "avail/" + idCidade;
		return template.getForObject(url, Hotel[].class);
	}
}