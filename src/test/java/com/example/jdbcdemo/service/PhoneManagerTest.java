package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.jdbcdemo.domain.Phone;
import com.example.jdbcdemo.domain.Part;


public class PhoneManagerTest 
{
	PhoneManager phoneManager = new PhoneManager();
	
	private final static String MODEL_1 = "Microsoft 535 DualSim";
	private final static int MEGAPIXELS_1 = 8;
	private final static double PRICE_1 = 500;
	private final static boolean SOLD_1 = false;
	
	private final static String NAME_1 = "Screen";
	private final static double PRICE_2 = 120;
	
	private final static String NEWMODEL_1 = "Microsoft 635";
	private final static int NEWMEGAPIXELS_1 = 12;
	private final static double NEWPRICE_1 = 900;
	private final static boolean NEWSOLD_1 = true;
	
	@Before 
	public void initialize() 
	{
		Phone phone = new Phone();
		phone.setModel(MODEL_1);
		phone.setPrice(PRICE_1);
		phone.setSold(SOLD_1);
		phone.setMegapixels(MEGAPIXELS_1);
		
		phoneManager.clearPhones();
		phoneManager.clearParts();
		
		phoneManager.addPhone(phone);
	}
	
	@Test
	public void checkConnection()
	{
		assertNotNull(phoneManager.getConnection());
	}
	
	@Test
	public void checkAdding()
	{
		phoneManager.clearPhones();
		Phone phone = new Phone();
		phone.setModel(MODEL_1);
		phone.setPrice(PRICE_1);
		phone.setSold(SOLD_1);
		phone.setMegapixels(MEGAPIXELS_1);
		
		phoneManager.clearPhones();
		phoneManager.clearParts();
		
		assertEquals(1,phoneManager.addPhone(phone));
		List<Phone> phones = phoneManager.getAllPhones();
		Phone phoneRetrieved = phones.get(0);
		
		assertEquals(MODEL_1, phoneRetrieved.getModel());
		assertEquals(PRICE_1, phoneRetrieved.getPrice(), 0.1);
		assertEquals(SOLD_1, phoneRetrieved.getSold());
		assertEquals(MEGAPIXELS_1, phoneRetrieved.getMegapixels());

	}
	
	@Test
	public void checkAddingSecond() 
	{		
		List<Phone> phones = phoneManager.getAllPhones();
		Phone phoneRetrieved = phones.get(0);
		
		Part part = new Part();
		part.setName(NAME_1);
		part.setPrice(PRICE_2);
		part.setOwnerId(phoneRetrieved.getId());
		phoneManager.addPart(phoneRetrieved, part);
		
		Part partRetrived = phoneRetrieved.getParts().get(0);
		assertEquals(NAME_1, partRetrived.getName());
		assertEquals(PRICE_2, partRetrived.getPrice(), 0.1);
	}
	
	@Test
	public void partGet() 
	{
		List<Phone> phones = phoneManager.getAllPhones();
		Phone phoneRetrieved = phones.get(0);
		
		Part part = new Part();
		part.setName(NAME_1);
		part.setPrice(PRICE_2);
		part.setOwnerId(phoneRetrieved.getId());
		phoneManager.addPart(phoneRetrieved, part);
		
		phones = phoneManager.getAllPhones();
		phoneRetrieved = phones.get(0);
		
		List<Part> parts = phoneManager.getAllParts(phoneRetrieved.getId());
		Part partRetrived = parts.get(0);
		assertEquals(1, parts.size());
		assertEquals(NAME_1, partRetrived.getName());
		assertEquals(PRICE_2, partRetrived.getPrice(), 0.1);
	}
	
	@Test
	public void checkEditMain() {
		List<Phone> phones = phoneManager.getAllPhones();
		Phone phoneRetrieved = phones.get(0);
		phoneRetrieved.setModel(NEWMODEL_1);
		phoneRetrieved.setPrice(NEWPRICE_1);
		phoneRetrieved.setMegapixels(NEWMEGAPIXELS_1);
		phoneRetrieved.setSold(NEWSOLD_1);
		phoneManager.editPhone(phoneRetrieved.getId(), phoneRetrieved);
		
		phones = phoneManager.getAllPhones();
		Phone edited = phones.get(0);
		assertEquals(NEWMODEL_1, edited.getModel());
		assertEquals(NEWPRICE_1, edited.getPrice(), 0.01);
		assertEquals(NEWMEGAPIXELS_1, edited.getMegapixels());
		assertEquals(NEWSOLD_1, edited.getSold());
	}

	@Test
	public void PhoneDelete(){

		Phone phone = new Phone();
		phone.setModel(NEWMODEL_1);
		phone.setPrice(NEWPRICE_1);
		phone.setSold(NEWSOLD_1);
		phone.setMegapixels(NEWMEGAPIXELS_1);
		
		phoneManager.addPhone(phone);
		
		List<Phone> phones = phoneManager.getAllPhones();
		Phone phoneRetrieved = phones.get(0);
		
		assertEquals(2, phones.size());
		
		Part part = new Part();
		part.setName(NAME_1);
		part.setPrice(PRICE_2);
		part.setOwnerId(phoneRetrieved.getId());
		phoneManager.addPart(phoneRetrieved, part);

		phones = phoneManager.getAllPhones();
		phoneRetrieved = phones.get(0);

	    phoneManager.deletePhone(phoneRetrieved);
	    phones = phoneManager.getAllPhones();
	    
	    assertEquals(1, phones.size());
	    
	    Phone otherPhone = phones.get(0);
		assertEquals(NEWMODEL_1, otherPhone.getModel());
		assertEquals(NEWPRICE_1, otherPhone.getPrice(), 0.1);
		assertEquals(NEWSOLD_1, otherPhone.getSold());
		assertEquals(NEWMEGAPIXELS_1, otherPhone.getMegapixels());
	}
}
