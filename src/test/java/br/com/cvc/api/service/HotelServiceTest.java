package br.com.cvc.api.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
			return mock(HotelService.class);
		}
	}

	@Autowired
	HotelService hotelService;

	@Test
	public void test_hotelEncontrado() {
		final int idHotel = 1;
		Hotel h = mock(Hotel.class);
		when(hotelService.findById(idHotel)).thenReturn(h);
	}
	
	@Test
	public void test_hotelNaoEncontrado() {
		final int idHotel = 2;
		Hotel h = mock(Hotel.class);
		when(hotelService.findById(idHotel)).thenReturn(h);
	}
	
//	@Test
//	public void testAllAvailable() {
////		Hotel[] hoteis = hotelService.findAllAvailableByIdCidade(1032);
//		
//	}

}
