package br.com.cvc.api.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViagemResource {

	@GetMapping("/viagens")
	public String getIt(@RequestParam("id") int idTeste) {

		System.out.println("idTeste: "+idTeste);

		// http://localhost:8080/cvc/api/viagens?CityCode=1032&Checkin=20/05/2017&Checkout=25/05/2017&qtdAdult=2&qtdChild=1
		return "opa";
	}
}
