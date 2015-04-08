package com.advoops.assignment4;

/* This class is for testing purposes only
 * in order to calculate the size of character 
 * objects when it stores font information
 * as well
 */

import java.awt.Font;


public class CharacterWithFont {

	private int unicodeValue;
	private Font font;
	
	public CharacterWithFont(int unicode,Font newFont) {
		
			this.unicodeValue=unicode;
			this.font=newFont;
	}
	
	public char getChar(){
		return (char)this.unicodeValue;
	}

	public Font getFont(){
		return this.font;
	}


}
