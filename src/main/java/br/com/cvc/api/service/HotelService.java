package br.com.cvc.api.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.api.model.Hotel;

@Component
public class HotelService {
	RestTemplate template = new RestTemplate();

	public Hotel findById(int idHotel) {
		String url = "https://cvcbackendhotel.herokuapp.com/hotels/" + idHotel;
		return template.getForObject(url, Hotel[].class)[0];
	}

	public Hotel[] findAllAvailableByIdCidade(int idCidade) {
		String url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/" + idCidade;
		return template.getForObject(url, Hotel[].class);
	}
}