package com.advoops.assignment2;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;

public class IngHeapDecoratorTest {

	@Test
	public void testToArray() {
		Heap heap=new Heap(new MinHeap());
		IngHeapDecorator ingDec=new IngHeapDecorator(heap);
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		String[] expectedOutput={"refactoring","programming","diving"};
		String[] actualOutput;
		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}		
		
		actualOutput=ingDec.toArray();
		
		for(int i=0;i<3;i++)
		{
			assertEquals(expectedOutput[i],actualOutput[i]);	
		}

	}

	@Test
	public void testToString() {
		Heap heap=new Heap(new MinHeap());
		AbstractHeap absHeap=new IngHeapDecorator(heap);
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		String expectedOutput="refactoring programming diving ";
		String actualOutput;
		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}	
		
		actualOutput=absHeap.toString();
		
		assertEquals(expectedOutput,actualOutput);	
	}

	@Test
	public void testIterator() {
		
		Heap heap=new Heap(new MinHeap());
		AbstractHeap absHeap=new IngHeapDecorator(heap);
		Iterator<String> ingDecIterator;
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		boolean[] expectedOutput={true,true,true,false};
		boolean actualOutput;
		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}		
		
		ingDecIterator=absHeap.iterator();
		
		actualOutput=ingDecIterator.hasNext();
		assertEquals(expectedOutput[0],actualOutput);
		ingDecIterator.next();
		actualOutput=ingDecIterator.hasNext();
		assertEquals(expectedOutput[1],actualOutput);
		ingDecIterator.next();
		actualOutput=ingDecIterator.hasNext();
		assertEquals(expectedOutput[2],actualOutput);
		ingDecIterator.next();
		actualOutput=ingDecIterator.hasNext();
		assertEquals(expectedOutput[3],actualOutput);
	}

}
