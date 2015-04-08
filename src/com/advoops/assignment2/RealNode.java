

package com.advoops.assignment2;


public class RealNode extends Node{
		
	private int isleft=1;
	private int isright=2;
	
	public RealNode() {	
	}

	public RealNode(String nodeName)
	{
		value = nodeName;
		leftChild = new NullNode(isleft);
		leftChild.parent=this;
		rightChild = new NullNode(isright);
		rightChild.parent=this;
	}
	
	public int getHeight()
	{	
		return 1 + Math.max(leftChild.getHeight(), rightChild.getHeight());
	}
	
	public boolean isNullNode()
	{
		return false;
	}

	public boolean add(Node newNode)
	{
		return false;
	}
}
