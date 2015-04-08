package com.advoops.assignment4;

public class Character {

	private int unicodeValue;
	
	public Character(int unicode) {			
			this.unicodeValue=unicode;
	}

	public char getChar(){
		return (char)this.unicodeValue;
	}

}
