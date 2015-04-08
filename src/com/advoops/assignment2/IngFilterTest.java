package com.advoops.assignment2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IngFilterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHasNext() {
		
		Heap heap=new Heap(new MinHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}		
		IngFilter fil=new IngFilter(heap.iterator());
		
		boolean[] expectedOutput={true,true,true,false};
		boolean actualOutput;
		
		actualOutput=fil.hasNext();
		assertEquals(expectedOutput[0],actualOutput);
		fil.next();
		actualOutput=fil.hasNext();
		assertEquals(expectedOutput[1],actualOutput);
		fil.next();
		actualOutput=fil.hasNext();
		assertEquals(expectedOutput[2],actualOutput);
		fil.next();
		actualOutput=fil.hasNext();
		assertEquals(expectedOutput[3],actualOutput);
	
	}

	@Test	
	public void testNext() {
		Heap heap=new Heap(new MinHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}		
		IngFilter fil=new IngFilter(heap.iterator());
		
		String[] expectedOutput={"refactoring","programming","diving"};
		String actualOutput;
			
		actualOutput=fil.next();
		assertEquals(expectedOutput[0],actualOutput);
		actualOutput=fil.next();
		assertEquals(expectedOutput[1],actualOutput);
		actualOutput=fil.next();
		assertEquals(expectedOutput[2],actualOutput);
	}
}
