package com.cropdeal.dealerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cropdeal.dealerservice.models.Dealer;
import com.cropdeal.dealerservice.repository.DealerRepository;
import com.cropdeal.dealerservice.resource.DealerResource;

@RunWith(SpringRunner.class)
@SpringBootTest
class DealerServiceApplicationTests {

	@Autowired
	private DealerResource service;
	

	@MockBean
	private DealerRepository dealerrepo;
	
	@Test
	public void adddealerTest() {
		Dealer dealer = new Dealer("1","abc","abc@gmail.com","12412414","12244",null);
		when(dealerrepo.insert(dealer)).thenReturn(dealer);
		//Dealer res=service.adddealer(dealer);
		assertEquals(dealer,service.adddealer(dealer));
	}
	@Test
	public void getdealerTest() {
		when(dealerrepo.findAll()).thenReturn(Stream
				.of(new Dealer("1","abc","abc@gmail.com","12412414","12244",null)).collect(Collectors.toList()));
		assertEquals(1, service.getdealer().size());
	}
	



	@Test
	public void deletedealerbyidTest() {
		String dealer = Dealer("1","abc","abc@gmail.com","12412414","12244",null);
		service.deleteDealer(dealer);
		verify(dealerrepo, times(1)).deleteById(dealer);
	}

	private String Dealer(String string, String string2, String string3, String string4, String string5,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Test
	public void getdealerByIdTest() {
		String id="1";
		service.getdealer(id);
	    verify(dealerrepo).findById(id);
	}


}
