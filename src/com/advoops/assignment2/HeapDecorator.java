

package com.advoops.assignment2;

import java.util.Iterator;

public abstract class HeapDecorator extends AbstractHeap{

	private AbstractHeap heap;
	

	public HeapDecorator(Heap heapConcrete){
	
		heap=heapConcrete;
	}

	@Override
	public String[] toArray() {
		
		return (String[]) heap.toArray();
	}
	
	@Override
	public String toString(){
		
		return heap.toString();
	}
	
	@Override
	public boolean isEmpty() {
		
		return heap.isEmpty();
	}
	
	public void clear() {
		
		heap.clear();	
	}	

	@Override
	public boolean add(String value) {
		
		return heap.add(value);
	}

	@Override
	public Iterator<String> iterator() {	
		
		return heap.iterator();
	}
	
	@Override
	public int size(){
		
		return heap.size();
	}
	
	
}
