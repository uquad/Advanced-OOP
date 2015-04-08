

package com.advoops.assignment3;

import static org.junit.Assert.*;
import org.junit.Test;

public class InventoryTest {


	@Test
	public void addMovieTest() {
		Inventory invent=new Inventory();
		boolean expectedOutput=true;
		boolean actualOutput=invent.add("Gladiator", 200, 3);	
		assertEquals(expectedOutput,actualOutput);
	}

	@Test
	public void addNewCopyTest() {
		
		Inventory invent=new Inventory();
		invent.add("Gladiator", 200, 3);		
		boolean expectedOutput=true;
		boolean actualOutput=invent.addNewCopy("Gladiator", 10);	
		assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void sellMovieTest() {
		
		Inventory invent=new Inventory();
		invent.add("Gladiator", 200, 20);
		boolean expectedOutput=true;
		boolean actualOutput=invent.sell("Gladiator", 5);	
		assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void setPriceTest() {
		
		Inventory invent=new Inventory();
		invent.add("Gladiator", 200, 20);	
		boolean expectedOutput=true;
		boolean actualOutput=invent.setPrice("Gladiator", 500);
		assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void findPriceByNameTest() {
		
		Inventory invent=new Inventory();
		invent.add("Gladiator", 200, 20);		
		float expectedMoviePriceOutput=200;
		float actualMoviePriceOutput=invent.findPrice("Gladiator");
		assertEquals(expectedMoviePriceOutput, actualMoviePriceOutput,0.0002);		
	}
	
	@Test
	public void findPriceByIdTest() {
		
		Inventory invent=new Inventory();
		invent.add("Gladiator", 200, 20);		
		float expectedMoviePriceOutput=200;
		float actualMoviePriceOutput=invent.findPrice(1);	
		assertEquals(expectedMoviePriceOutput, actualMoviePriceOutput,0.0002);	
	}
	
	@Test
	public void findQuantityByNameTest() {
		
		Inventory invent=new Inventory();
		invent.add("Gladiator", 200, 3);	
		int expectedMovieQuantityOutput=3;
		int actualMovieQuantityOutput=invent.findQuantity("Gladiator");	
		assertEquals(expectedMovieQuantityOutput,actualMovieQuantityOutput);
	}
	
	@Test
	public void findQuantityByIdTest() {
		
		Inventory invent=new Inventory();
		invent.add("Gladiator", 200, 3);	
		int expectedMovieQuantityOutput=3;
		int actualMovieQuantityOutput=invent.findQuantity(1);	
		assertEquals(expectedMovieQuantityOutput,actualMovieQuantityOutput);

	}
	

}
