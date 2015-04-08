package com.advoops.assignment2;

import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {

	@Test
	public void testSize() {
		Heap heap=new Heap(new MinHeap());
		String[] input= {"refactoring","diving","apple", "code","programming","mango"};
		int expectedHeapSize=6;
		int actualHeapSize;

		for(int i=0;i<6;i++)
		{
			heap.add(input[i]);
		}		
		actualHeapSize=heap.size();		
		assertEquals(expectedHeapSize, actualHeapSize);
	}
	
	@Test
	public void testMinHeapToArray() {
		Heap minHeap=new Heap(new MinHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		String[] expectedHeapArray={"refactoring","code","mango","apple","programming","diving"};
		String[] actualheapArray;
		
		for(int i=0;i<6;i++)
		{
			minHeap.add(input[i]);
		}		
		
		actualheapArray=minHeap.toArray();
		
		for(int i=0;i<minHeap.size();i++)
		{
			assertEquals(expectedHeapArray[i],actualheapArray[i]);
		}
	}

	

	@Test
	public void testMinHeapToString() {
		Heap minHeap=new Heap(new MinHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		String expectedMinHeapOutput="refactoring code mango apple programming diving ";
		String actualMinHeapOutput;
		
		for(int i=0;i<6;i++)
		{
			minHeap.add(input[i]);
		}		
		
		actualMinHeapOutput=minHeap.toString();
		
		assertEquals(expectedMinHeapOutput,actualMinHeapOutput);
	}
	
	@Test
	public void testMaxHeapToArray() {
	   Heap maxHeap=new Heap(new MaxHeap());
	   String[] input={"refactoring","diving","apple", "code","programming","mango"};
	   String[] expectedHeapArray={"code","mango","diving","refactoring","apple","programming"};
	   String[] actualheapArray;
		
		for(int i=0;i<6;i++)
		{
			maxHeap.add(input[i]);
		}		
		
		actualheapArray=maxHeap.toArray();
		
		for(int i=0;i<maxHeap.size();i++)
		{
			assertEquals(expectedHeapArray[i],actualheapArray[i]);
		}
	}

	

	@Test
	public void testMaxHeapToString() {
		Heap maxHeap=new Heap(new MaxHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		String expectedMaxHeapOutput="code mango diving refactoring apple programming ";
		String actualMaxHeapOutput;
		
		for(int i=0;i<6;i++)
		{
			maxHeap.add(input[i]);
		}		
		
		actualMaxHeapOutput=maxHeap.toString();
		
		assertEquals(expectedMaxHeapOutput,actualMaxHeapOutput);
	}

	@Test
	public void testIsEmpty() {
		Heap minHeap=new Heap(new MinHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		boolean expectedOutput=false;
		boolean actualOutput;
		for(int i=0;i<6;i++)
		{
			minHeap.add(input[i]);
		}	
		actualOutput=minHeap.isEmpty();
		
		assertEquals(expectedOutput,actualOutput);
	}

	@Test
	public void testAdd() {
		Heap minHeap=new Heap(new MinHeap());
		String[] input={"refactoring","diving","apple", "code","programming","mango"};
		boolean expectedOutput=true;
		boolean actualOutput;
		
		actualOutput=minHeap.add(input[0]);
		assertEquals(expectedOutput,actualOutput);
		actualOutput=minHeap.add(input[1]);
		assertEquals(expectedOutput,actualOutput);
		actualOutput=minHeap.add(input[2]);
		assertEquals(expectedOutput,actualOutput);
		actualOutput=minHeap.add(input[3]);
		assertEquals(expectedOutput,actualOutput);
		actualOutput=minHeap.add(input[4]);
		assertEquals(expectedOutput,actualOutput);
		actualOutput=minHeap.add(input[5]);
		assertEquals(expectedOutput,actualOutput);
		
	}


}
