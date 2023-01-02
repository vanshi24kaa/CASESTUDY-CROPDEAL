package com.cropdeal.cropservice;

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

import com.cropdeal.cropservice.controller.CropController;
import com.cropdeal.cropservice.model.Crop;
import com.cropdeal.cropservice.repository.CropRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
class CropServiceApplicationTests 
{

	@Autowired
	private CropController service;
	

	@MockBean
	private CropRepository croprepo;
	
	@Test
	void addcropTest() {
		Crop crop = new Crop(111,"abcc","organic","5kg",null,"500");
		when(croprepo.insert(crop)).thenReturn(crop);
		Crop res =service.addcrop(crop);
		assertEquals(crop.getId(),res.getId());
	}
	@Test
	 void getCropTest() {
		when(croprepo.findAll()).thenReturn(Stream.of(new Crop(123,"abcd","organic","3kg", null,"700"),
				new Crop(321,"cba","organic","6kg", null,"600"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getcrop().size());
	}
	

	//@Test
	//public void addcropTest() {
		//Crop crop = new Crop(999, "def","def@33", "234567",null,null);
		//when(croprepo.insert(crop)).thenReturn(crop);
		//assertEquals(crop, service.addcrop(crop));
	//}
	

	@Test
	 void deleteCropbyidTest() {
		String crop = Farmer(999, "def","def@33", "234567",null,null);
		service.deletecrop(999);
		verify(croprepo, times(1)).deleteById(999);
	}

	private String Farmer(int id, String string, String string2, String string3, Object object1,Object object2) {
	// TODO Auto-generated method stub
	return null;
}
	
	
	@Test
	 void getCropByIdTest() {
		int id=2;
		service.getcropById(id);
	    verify(croprepo).findById(id);
	}

}
