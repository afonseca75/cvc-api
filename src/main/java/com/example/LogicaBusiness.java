package com.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cvc.api.model.Hotel;
import br.com.cvc.api.model.PriceDetail;
import br.com.cvc.api.model.Room;

public class LogicaBusiness {

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

	private Hotel[] findAllAvailableHotelsByCityCode(int cityCode) {
		try {
			return new ObjectMapper().readValue(realAllAvailabelToStrings(cityCode), Hotel[].class);
		} catch (IOException e) {
			return null;
		}
	}

	private String realAllAvailabelToStrings(int cityCode) {
		try {
			String filePath = cityCode + ".json";
			Path path = Paths.get(Testa.class.getClassLoader().getResource(filePath).toURI());
			Stream<String> lines = Files.lines(path);
			String data = lines.collect(Collectors.joining("\n"));
			lines.close();
			return data;
		} catch (URISyntaxException | IOException e) {
			return null;
		}
	}
}
