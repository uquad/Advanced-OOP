package com.advoops.assignment3;

public abstract class AbstractInventory {

	public abstract boolean add(String movieName,float moviePrice,int quantity);
	public abstract boolean sell(String movieName,int quantity);
	public abstract boolean addNewCopy(String movieName,int quantity);	
	public abstract boolean setPrice(String movieName,float price);
	public abstract float findPrice(String movieName);	
	public abstract float findPrice(int id);	
	public abstract int findQuantity(String movieName);	
	public abstract int findQuantity(int id);
	public abstract boolean contains(String movieName);
	public abstract int getId(String movieName);

}
