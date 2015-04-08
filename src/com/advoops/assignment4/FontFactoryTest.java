package com.advoops.assignment4;

import static org.junit.Assert.*;
import java.awt.Font;
import org.junit.Test;

public class FontFactoryTest {

	@Test
	public void fontCreationTest() {
		
		FontFactory testFontFactory=FontFactory.instance();	
		Font fontA=testFontFactory.getFontFromFactory("Arial", Font.BOLD, 10);
		Font fontB=new Font("Arial", Font.BOLD, 10);
			
		assertEquals(fontA, fontB);
		
	}
	
	@Test
	public void factorySinglePointOfAccessTest() {
		//Testing the factory by comparing its memory location 
		//to confirm that ONLY one instance of the FontFactory exists
		FontFactory testFontFactory=FontFactory.instance();
		FontFactory testFontFactory2=FontFactory.instance();
		
		assertEquals(testFontFactory.toString(), testFontFactory2.toString());
		
	}

}
