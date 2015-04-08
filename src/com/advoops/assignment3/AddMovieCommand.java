

package com.advoops.assignment3;

public class AddMovieCommand extends Command {

	private static final long serialVersionUID = 1L;
	private String movieName;
	private float price;
	private int quantity;

	public AddMovieCommand(String movName,float movPrice,int qty) {
		this.movieName=movName;
		this.price=movPrice;	
		this.quantity=qty;
	}

	@Override
	public boolean execute(Inventory inventObject) {
		
		return inventObject.add(movieName, price,quantity);
	}


}
