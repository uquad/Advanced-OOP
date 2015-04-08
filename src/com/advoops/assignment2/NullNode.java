

package com.advoops.assignment2;

public class NullNode extends Node{

	public NullNode(int whichChild) {
		
		//sets the nullNode as a right or left child of Real parent  Node		
		if(whichChild==1)
		{
			isLeftChild=true;
		}
		else if (whichChild==2)
		{
			isRightChild=true;
		}

	}
	
	public int getHeight()
	{
		return 0;
	}
	
	public boolean isNullNode()
	{
		return true;
	}

	public boolean add(Node newNode) {
		
			Node currentNullNode=this;

			newNode.parent=currentNullNode.parent;
			newNode.isLeftChild=currentNullNode.isLeftChild;
			newNode.isRightChild=currentNullNode.isRightChild;
			
			//newNode has to be added to the left of the parent
			if(currentNullNode.isLeftChild)
			{
				currentNullNode.parent.leftChild=newNode;
			}
			//newNode has to be added to the right of the parent
			else if(currentNullNode.isRightChild)
			{
				currentNullNode.parent.rightChild=newNode;						
			}
			return true;
			
	}
	
}
