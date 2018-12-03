package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cvc.api.service.HotelService;

@SpringBootTest
public class Testa {

	@Autowired
	HotelService hotelService;

	@Test
	public void testa() {
		int cityCode = 1032;
		String checkin = "20/05/2017";
		String checkout = "25/05/2017";
		int qtdAdult = 2;
		int qtdChild = 1;
		
		System.out.println(hotelService);

	}

	// public static void main(String[] args) throws Exception {
	// // calculaResultado(1032, "20/05/2017", "25/05/2017", 2, 1);
	// // testa1();
	//
	//
	//
	//
	//
	//// LogicaBusiness logica = new LogicaBusiness();
	//// int cityCode = 1032;
	//// String checkin = "20/05/2017";
	//// String checkout = "25/05/2017";
	//// int qtdAdult = 2;
	//// int qtdChild = 1;
	//// List<Hotel> resultados = logica.calculaResultado(cityCode, checkin,
	// checkout, qtdAdult, qtdChild);
	//// for (Hotel resultadoServico1 : resultados) {
	//// System.out.println(resultadoServico1.getCityName());
	//// }
	//
	// }

}
