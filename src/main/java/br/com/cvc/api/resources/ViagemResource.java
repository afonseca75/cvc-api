package br.com.cvc.api.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViagemResource {

	@GetMapping("/viagens")
	public String getIt() {

		return "Got it!";
	}
}
