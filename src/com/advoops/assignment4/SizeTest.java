package com.advoops.assignment4;

import java.awt.Font;
import org.junit.Test;

public class SizeTest {
	
	private final String testString="CS 635 Advanced Object-Oriented Design "
			+ "& Programming Spring Semester, 2014 Doc 19 "
			+ "Facade & Mediator April 24, 2014 Copyright ©, "
			+ "All rights reserved. 2014 SDSU & Roger Whitney, 5500 "
			+ "Campanile Drive, San Diego, CA 92182-7700 USA.OpenContent "
			+ "(http://www.opencontent.org/opl.shtml) license defines the "
			+ "copyright on this document.";
	
	private final char[] testChars=testString.toCharArray();

	  @Test
	  public void testObjectSizeWithFlyWeight() {
		

		
	  	System.out.printf("The average size using flyweights is %.1f bytes%n", 
	  	new SizeofUtil()
	  	{
		    Object obj = null;
	
		    @Override
		    protected int create() 
		    {	    	 
			    FontFactory fontFactory=FontFactory.instance();	  
			    Font fontA=fontFactory.getFontFromFactory("Times New Roman", Font.BOLD, 12);
			    Font fontB=fontFactory.getFontFromFactory("Arial", Font.BOLD, 16);
					
		        Character[] CharacterFlyWeightArray=new Character[326];
		        CharacterFactory charFactory=CharacterFactory.instance();
		          
		        for(int i=0;i<325;i++)
		        {   
		          CharacterFlyWeightArray[i]=charFactory.getCharFromFactory((int)testChars[i]);       	  
		        }
				
		        RunArray testRun=new RunArray();
		        testRun.addRun(0, 115, fontA);
				testRun.appendRun(211, fontB);
					
			    obj = new Object();
			    return 1;
		      }
	    }.averageBytes());
	  
  }
	  
	  
	  
	  @Test
	  public void testObjectSizeWithoutFlyWeight(){
		  
		  System.out.printf("The average size without using Flyweights is %.1f bytes%n",
		  new SizeofUtil()
		  {
			Object obj = null;
			@Override
			protected int create()
			{		    	  
				CharacterWithFont[] tempArray=new CharacterWithFont[326];
				Font fontA,fontB;
								       
				for(int i=0;i<115;i++)
				{
					fontA=new Font("Times New Roman",Font.BOLD,14);
					tempArray[i]=new CharacterWithFont((int)testChars[i],fontA); 
				}
							       
				for(int i=115;i<325;i++)
				{
					fontB=new Font("Arial",Font.BOLD,10);
					tempArray[i]=new CharacterWithFont((int)testChars[i],fontB); 
				}
							       		       		
					obj = new Object();
					return 1;
			}
		}.averageBytes());  
	  }
		
}
