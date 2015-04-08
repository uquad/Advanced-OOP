package com.advoops.assignment4;

import java.util.HashMap;

public class CharacterFactory {
	
	private HashMap<Integer,Character> characterMap = new HashMap<Integer,Character>();
	
	private CharacterFactory(){	
	}

	
	private static class SingletonCharacterHolder 
	{
		 private final static CharacterFactory INSTANCE = new CharacterFactory();
	}
	
	
	public static CharacterFactory instance()
	{
		 return SingletonCharacterHolder.INSTANCE;
	}
	
	public Character getCharFromFactory(int unicode)
	{
	    if(characterMap.containsKey(unicode))
	    {	    	
	    	return characterMap.get(unicode);
	    }
	    else
	    {    	 
	    	Character newCharacter=new Character(unicode);	 
	    	characterMap.put(unicode,newCharacter);
	    	return newCharacter;    	
	    }		
	}
}
