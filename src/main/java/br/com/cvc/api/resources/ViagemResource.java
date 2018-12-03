package br.com.cvc.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cvc.api.service.HotelService;

@Path("viagens")
public class ViagemResource {

	@Autowired
	private HotelService hotelService;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		
		System.out.println(hotelService);
		return "Got it!";
	}
}
