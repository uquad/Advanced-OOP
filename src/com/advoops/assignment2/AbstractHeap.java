package com.advoops.assignment2;

import java.util.AbstractCollection;
import java.util.Iterator;

public abstract class AbstractHeap extends AbstractCollection<String>{

	public AbstractHeap() {
	}

	public abstract String[] toArray();
	public abstract int size();
	public abstract String toString();
	public abstract boolean isEmpty() ;
	public abstract void clear();
	public abstract boolean add(String value);
	public abstract Iterator<String> iterator();
	
}
