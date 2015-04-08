

package com.advoops.assignment3;

import java.io.Serializable;

public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private float price;
	private int quantity;
	private String name;
	
	public Movie(int movieId,String movieName,float moviePrice,int movieQuantity) {
		this.id=movieId;
		this.price=moviePrice;
		this.quantity=movieQuantity;
		this.name=movieName;
		
	}
	
	public int getQuantity(){
		return quantity;	
	}

	public void setQuantity(int amount){
		this.quantity=amount;	
	}
	
	public float getPrice(){
		return price;
	}
	
	public void setPrice(float prc){
		this.price=prc;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String nm){
		this.name=nm;
	}
	
	public String getName(){
		 return name;
	}

	
}
