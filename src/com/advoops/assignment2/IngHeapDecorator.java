package com.advoops.assignment2;

import java.util.Iterator;

public class IngHeapDecorator extends HeapDecorator{
	
	private AbstractHeap heap;
	
	public IngHeapDecorator(Heap heapObject) 
	{
		super(heapObject);
		heap=heapObject;
	}

	@Override
	public String[] toArray() 
	{	
		int ingArrayIndex=0;
		String[] ingArray;
		Iterator<String> ingFilter=	new IngFilter(heap.iterator());		
		ingArray=new String[size()];
					
		while(ingFilter.hasNext())
		{
			ingArray[ingArrayIndex++]=ingFilter.next();
		}	
		return ingArray;
	}
	
	@Override
	public String toString()
	{
		StringBuffer heapString=new StringBuffer();
		Iterator<String> ingFilter=	new IngFilter(heap.iterator());
	
		while(ingFilter.hasNext())
		{
			heapString.append(ingFilter.next()+ " ");
		}
		
		return heapString.toString();
	}
	
	@Override
	public int size()
	{
		int ingNodesCount=0;
		Iterator<String> ingFilCounter=new IngFilter(heap.iterator());

		while(ingFilCounter.hasNext())
		{
			ingNodesCount++;
			ingFilCounter.next();
		}
		
		return ingNodesCount;	
	}
	
	
	
	
	
	
	@Override
	public Iterator<String> iterator() 
	{		
		return new IngFilter(heap.iterator());
	}

}
