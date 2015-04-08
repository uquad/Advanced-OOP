package com.advoops.assignment2;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

public class HeapIteratorTest {


	@Test
	public void testHasNext() {
		Heap heap=new Heap(new MinHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		Iterator<String> iter;
		boolean[] expectedOutput={true,true,true,true,true,true,false};
		boolean actualOutput;
			
		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}		
		iter=heap.iterator();
			
		actualOutput=iter.hasNext();
		assertEquals(expectedOutput[0],actualOutput);
		iter.next();
		actualOutput=iter.hasNext();
		assertEquals(expectedOutput[1],actualOutput);
		iter.next();
		actualOutput=iter.hasNext();
		assertEquals(expectedOutput[2],actualOutput);
		iter.next();
		actualOutput=iter.hasNext();
		assertEquals(expectedOutput[3],actualOutput);
		iter.next();
		actualOutput=iter.hasNext();
		assertEquals(expectedOutput[4],actualOutput);
		iter.next();
		actualOutput=iter.hasNext();
		assertEquals(expectedOutput[5],actualOutput);
		iter.next();
		actualOutput=iter.hasNext();
		assertEquals(expectedOutput[6],actualOutput);
		
	}

	@Test
	public void testNext() {
		Heap heap=new Heap(new MinHeap());
		String[] input= { "refactoring","diving","apple", "code","programming","mango"};
		Iterator<String> iter;
		String[] expectedOutput={ "refactoring","code","mango","apple","programming","diving"};
		String actualOutput;
		
		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}	
		iter=heap.iterator();
		
		actualOutput=iter.next();
		assertEquals(expectedOutput[0],actualOutput);
		actualOutput=iter.next();
		assertEquals(expectedOutput[1],actualOutput);
		actualOutput=iter.next();
		assertEquals(expectedOutput[2],actualOutput);
		actualOutput=iter.next();
		assertEquals(expectedOutput[3],actualOutput);
		actualOutput=iter.next();
		assertEquals(expectedOutput[4],actualOutput);
		actualOutput=iter.next();
		assertEquals(expectedOutput[5],actualOutput);
		
	}

}
