package br.com.cvc.api.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.api.model.Hotel;
import br.com.cvc.api.model.PriceDetail;
import br.com.cvc.api.model.Room;

@Component
public class HotelService {
	private static final String BASIC_URL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	RestTemplate template = new RestTemplate();

	public Hotel findById(int idHotel) {
		String url = BASIC_URL + idHotel;
		return template.getForObject(url, Hotel[].class)[0];
	}

	public Hotel[] findAllAvailableHotelsByCityCode(int idCidade) {
		String url = BASIC_URL + "avail/" + idCidade;
		return template.getForObject(url, Hotel[].class);
	}
	
	public List<Hotel> calculaResultado(int cityCode, String checkin, String checkout, int qtdAdult, int qtdChild) {

		long daysToStay = calculateDaysBetweenCheckinAndCheckout(checkin, checkout);

		List<Hotel> resultados = new ArrayList<>();
		Hotel[] availableHotels = findAllAvailableHotelsByCityCode(cityCode);
		for (Hotel h : availableHotels) {
			Hotel hotel = new Hotel();
			hotel.setId(h.getId());
			hotel.setCityName(h.getCityName());
			List<Room> rooms = new ArrayList<>();
			for (Room r : h.getRooms()) {
				Room room = new Room();
				PriceDetail priceDetail = new PriceDetail();
				double pricePerDayAdult = r.getPrice().getAdult() * qtdAdult * daysToStay;
				double pricePerDayChild = r.getPrice().getChild() * qtdChild * daysToStay;
				double totalPrice = (pricePerDayAdult / 0.7) + (pricePerDayChild / 0.7);
				priceDetail.setPricePerDayAdult(pricePerDayAdult);
				priceDetail.setPricePerDayChild(pricePerDayChild);
				room.setTotalPrice(totalPrice);
				rooms.add(room);
			}
			hotel.setRooms(rooms);
			resultados.add(hotel);
		}

		return resultados;
	}
	
	private long calculateDaysBetweenCheckinAndCheckout(String checkin, String checkout) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate checkinDay = LocalDate.parse(checkin, formatter);
		LocalDate checkoutDay = LocalDate.parse(checkout, formatter);
		return ChronoUnit.DAYS.between(checkinDay, checkoutDay);
	}

}