package com.advoops.assignment4;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterFactoryTest {

	@Test
	public void characterCreationTest() {
		
		CharacterFactory testCharacterFactory=CharacterFactory.instance();	
		Character a=testCharacterFactory.getCharFromFactory((int)'a');
		Character aCopy=new Character((int)'a');
				
		assertEquals(a.getChar(), aCopy.getChar());
		
	}
	
	@Test
	public void factorySinglePointOfAccessTest() {
		//Testing the factory by comparing its objects memory location 
		//to confirm that ONLY one instance of the CharacterFactory exists
		CharacterFactory testCharacterFactory=CharacterFactory.instance();
		CharacterFactory testCharacterFactory2=CharacterFactory.instance();
		
		assertEquals(testCharacterFactory.toString(), testCharacterFactory2.toString());
		
	}

}
