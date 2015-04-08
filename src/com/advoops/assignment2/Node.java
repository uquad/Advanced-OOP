

package com.advoops.assignment2;

public abstract class Node {
	
	String value;
	Node parent;
	Node leftChild;
	Node rightChild;
	boolean isLeftChild=false;
	boolean isRightChild=false;
	
	public Node() {
	}
	
	public abstract int getHeight();		
	public abstract boolean isNullNode();	
	public abstract boolean add(Node newNode);

}
