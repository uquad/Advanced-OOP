

package com.advoops.assignment2;

import java.util.Iterator;


public class IngFilter implements Iterator<String> {
	
	private Iterator<String> heapIterator;
	private String nextValue;
	private Boolean hasNextCalled=false;
	
	public IngFilter(Iterator<String> inputIterator) {	
		heapIterator=inputIterator;
	}
	
	public boolean hasNext()
	{	
		String nodeString;
		hasNextCalled=true;

		while(heapIterator.hasNext())
		{
			nodeString=heapIterator.next();
			if(nodeString.endsWith("ing"))
			{
				nextValue=nodeString;
				return true;
			}			
		}	
		return false;
	}
	
	public String next()
	{	
		String ingValue;	
		if(!hasNextCalled)
		{	
			while(heapIterator.hasNext())
			{
				ingValue=heapIterator.next();
				if(ingValue.endsWith("ing"))
				{
					return ingValue;
				}			
			}
		}	
		else if (hasNextCalled)
		{
			hasNextCalled=false;
			return nextValue;
		}		
		return null;		
	}
		
	@Override
	public void remove() {
		
	}
}
