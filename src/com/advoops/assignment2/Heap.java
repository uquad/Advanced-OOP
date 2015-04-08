
package com.advoops.assignment2;

import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class Heap extends AbstractHeap{
	
	private RealNode root;
	private HeapStrategy heapStrategy;
	private int heapModCount=0;//to check number of modifications done on heap
	
	public Heap() {
	}	
	
	public Heap(HeapStrategy strategy)
	{
		this.heapStrategy=strategy;
	}
	
	@Override
	public String[] toArray() {
		
		int heapArrayIndex=0;
		String[] heapArray=new String[this.size()];
		HeapIterator heapIterator=new HeapIterator(root);
					
		while(heapIterator.hasNext())
		{
			heapArray[heapArrayIndex++]=heapIterator.next();
		}	
		return heapArray;
	}
	
	@Override
	public int size() {
		
		int heapNodeCount=0;
		HeapIterator heapIterator=new HeapIterator(root);
		
		while(heapIterator.hasNext())
		{
			heapNodeCount++;
			heapIterator.next();
		}	
		return heapNodeCount;
	}
	
	@Override
	public String toString()
	{	
		StringBuffer heapStringBuffer=new StringBuffer();
		HeapIterator heapIterator=new HeapIterator(root);
				
		while(heapIterator.hasNext())
		{
			heapStringBuffer.append(heapIterator.next());
			heapStringBuffer.append(" ");	
		}		
		
		return heapStringBuffer.toString();
	}
	
	@Override
	public boolean isEmpty() {

		if(root==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public void clear() {

		root=null;
		heapModCount++;
	}	
	
	@Override
	public boolean add(String value) {
		RealNode newNode=new RealNode(value);
		Boolean addStatus;
		heapModCount++;
			if(root==null)
			{
				root=newNode;
				addStatus=true;
			}
			else
			{
				addStatus=heapStrategy.add(root, newNode);
			}
		
		return addStatus;
	}
	
	@Override
	public Iterator<String> iterator() {
		return new HeapIterator(root);
	}
		
	private class HeapIterator implements Iterator<String> {
		
		private Node currentNode;
		private Node root;
		private int lockedModCount;
		private Stack<Node> nodeStack=new Stack<Node>();

		public HeapIterator(Node rootNode) 
		{
			root=rootNode;	
			currentNode=rootNode;
			lockedModCount=heapModCount;
		}

		
		
		
			
		@Override
		public boolean hasNext() {
			
			//if heap was modified while iterator was working on it
			if(lockedModCount!=heapModCount)
			{
				throw new ConcurrentModificationException();
			}		
			else if(currentNode==null)
			{
				return false;
			}
			//before iteration has begun when the stack is empty OR
			//when the root is popped and its right subtree is yet to be traversed
			else if(currentNode==root || currentNode==root.rightChild)
			{
				return true;
			}
			else if(nodeStack.isEmpty())
			{
				return false;
			}
			else 
			{
				return true;
			}
		}

		@Override
		public String next() {
			
			String returnValue;
			
			if(currentNode==null)
			{
				throw new NoSuchElementException();
			}
			
			while(true)
			{
				while(!currentNode.isNullNode())
				{
					nodeStack.push(currentNode);
					currentNode=currentNode.leftChild;
				}
				
				if(currentNode.isNullNode() && (!(nodeStack.isEmpty())))
				{
					currentNode=nodeStack.pop();
					returnValue=currentNode.value;
					currentNode=currentNode.rightChild;
					
					return returnValue;
					
				}					
			}			
		}

		
		
		
		
		@Override
		public void remove() {		
		}
	}
	
}



