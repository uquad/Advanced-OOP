package com.advoops.assignment2;
//package com.advoops;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//
//public class MinHeapTest extends MinHeap {
//
//	@Test
//	public void testpreOrderPrint() 
//	{
//		
//	MinHeap heap=new MinHeap();	
//	Node node;
//	String[] nodeStrings= {"apple", "diving", "refactoring","code","programming","mango"};
//	String expectedOutput="apple code diving mango programming refactoring ";
//	
//		for(int i=0;i<6;i++)
//		{
//			node=new Node(nodeStrings[i]);
//			heap.heapInsert(heap.getRootNode(), node);	
//		}
//		
//	heap.preorderPrint(heap.getRootNode());
//	assertEquals(expectedOutput, heap.getOutput().toString());
//	}
//	
//	
//	@Test
//	public void testpreOrderSelectivePrint() 
//	{
//		
//	MinHeap heap=new MinHeap();	
//	Node node;
//	String[] nodeStrings= {"apple", "diving", "refactoring","code","programming","mango"};
//	String expectedOutput="diving programming refactoring ";
//	
//		for(int i=0;i<6;i++)
//		{
//			node=new Node(nodeStrings[i]);
//			heap.heapInsert(heap.getRootNode(), node);	
//		}
//		
//	heap.preorderSelectivePrint(heap.getRootNode());
//	assertEquals(expectedOutput, heap.getOutput().toString());		
//	}
//	
//	@Test
//	public void testswapNodeValues() 
//	{
//		
//	MinHeap heap=new MinHeap();	
//	Node nodeA=new Node("Banana ");
//	Node nodeB=new Node("Orange ");
//	String expectedOutput="Orange Banana ";
//	
//    heap.swapNodeValues(nodeA, nodeB);		
//    assertEquals(expectedOutput, nodeA.nodeValue+nodeB.nodeValue);
//		
//	}
//
//}
