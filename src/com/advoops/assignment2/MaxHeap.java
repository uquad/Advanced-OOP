package com.advoops.assignment2;


public class MaxHeap implements HeapStrategy {

	public MaxHeap() {		
	}

	public boolean add(Node rootNode,Node newNode) {
		
		int nodeValueComparer;
		Node currentNode=rootNode;
		boolean nodeAdded=false;//to check whether Real Node has replaced Null Node
				
		while(nodeAdded==false)
		{
			nodeValueComparer = currentNode.value.compareTo(newNode.value);
			
			//string in newNode is smaller than in currentNode
			if (nodeValueComparer > 0)
			{
									
				if (currentNode.leftChild.getHeight() <= currentNode.rightChild.getHeight())
				{
					currentNode= currentNode.leftChild;
					nodeAdded=currentNode.add(newNode);

				} 
					
				else if(currentNode.leftChild.getHeight()>currentNode.rightChild.getHeight()) 
				{
					currentNode=currentNode.rightChild;
					nodeAdded=currentNode.add(newNode);

				}
	
			}
			//string in newNode is bigger than in the current
			//Node then interchange the values.
			else if (nodeValueComparer < 0) 
			{
				String swapNodeValue;
				swapNodeValue = currentNode.value;
				currentNode.value = newNode.value;
				newNode.value = swapNodeValue;	
			}
		}
				
		return true;
	}
}
