package br.com.cvc.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.api.model.Hotel;
import br.com.cvc.api.service.HotelService;

@RestController
@RequestMapping("/viagens")
public class ViagemResource {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/valores")
	public List<Hotel> getIt(@RequestParam("CityCode") int cityCode, @RequestParam("Checkin") String checkin,
			@RequestParam("Checkout") String checkout, @RequestParam("qtdAdult") int qtdAdult,
			@RequestParam("qtdChild") int qtdChild) {

		return hotelService.calculaResultado(cityCode, checkin, checkout, qtdAdult, qtdChild);
	}
}