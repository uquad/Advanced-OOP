package com.advoops.assignment4;

import static org.junit.Assert.*;

import java.awt.Font;

import org.junit.Test;

public class RunArrayTest {

	@Test
	public void testAddRun() {

		RunArray tempTester=new RunArray();
		
	    Font fontA=new Font("Times New Roman", Font.BOLD, 12);
	    Font fontB=new Font("Arial", Font.ITALIC, 16);
	      
		tempTester.addRun(0, 200, fontA);;
		tempTester.addRun(200, 300, fontB);

		
		assertEquals(fontA,tempTester.getFontAt(50));
		assertEquals(fontB,tempTester.getFontAt(300));

	}
	
	@Test
	public void testAppend() {

		RunArray tempTester=new RunArray();
		
	    Font fontA=new Font("Times New Roman", Font.BOLD, 12);
	    Font fontB=new Font("Arial", Font.ITALIC, 16);
	      
		tempTester.addRun(0, 200, fontA);
		tempTester.appendRun(300, fontB);
		tempTester.appendRun(150, fontA);

		
		assertEquals(fontB,tempTester.getFontAt(450));
		assertEquals(fontA,tempTester.getFontAt(600));

	}

}
