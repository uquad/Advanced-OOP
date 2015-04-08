package com.advoops.assignment4;

import java.awt.Font;
import java.util.Iterator;
import java.util.ArrayList;

public class FontFactory {
	
	private ArrayList<Font> fontList=new ArrayList<Font>();
	
	private FontFactory(){	
	}

	private static class SingletonFontHolder 
	{
		 private final static FontFactory INSTANCE = new FontFactory();
    }
	

	public static FontFactory instance() 
	{
		 return SingletonFontHolder.INSTANCE;
	}
	
	
	public Font getFontFromFactory(String name,int style,int size)
	{
		Iterator<Font> fontIterator=fontList.iterator();
		
		while(fontIterator.hasNext())
		{
			Font currentFont=fontIterator.next();
				
			if((currentFont.getName().equals(name) && 
			   (currentFont.getStyle()==style) && 
			   (currentFont.getSize()==size)))
					{
						return currentFont;
					}
		}
		
		Font newFont=new Font(name,style,size);		
		fontList.add(newFont);		
		return newFont;		
		
	}
}
