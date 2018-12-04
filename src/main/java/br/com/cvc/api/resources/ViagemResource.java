package br.com.cvc.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cvc.api.service.HotelService;

@Path("viagens")
public class ViagemResource {

	@Autowired
	private HotelService hotelService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt(@QueryParam("CityCode") int cityCode, @QueryParam("Checkin") String checkin,
			@QueryParam("Checkout") String checkout, @QueryParam("qtdAdult") int qtdAdult,
			@QueryParam("qtdChild") int qtdChild) {

		System.out.println(hotelService);
		System.out.println("cityCode:"+cityCode);
		System.out.println("checkin:"+checkin);
		System.out.println("checkout:"+checkout);
		System.out.println("qtdAdult:"+qtdAdult);
		System.out.println("qtdChild:"+qtdChild);
		return "Got it!";
	}
}
