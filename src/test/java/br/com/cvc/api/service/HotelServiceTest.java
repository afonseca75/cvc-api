package br.com.cvc.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.com.cvc.api.model.Hotel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class HotelServiceTest {

	@Configuration
	static class ContextConfiguration {

		@Bean
		public HotelService hotelService() {
			HotelService hotelService = new HotelService();
			return hotelService;
		}
	}

	@Autowired
	HotelService hotelService;

	@Test
	public void testHotelService() {
		System.out.println(hotelService.findById(1));
	}
	
	@Test
	public void testAllAvailable() {
		Hotel[] hoteis = hotelService.findAllAvailableByIdCidade(1032);
		
	}

}
