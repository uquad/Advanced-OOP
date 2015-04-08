

package com.advoops.assignment3;

public class SetPriceCommand extends Command {

	private static final long serialVersionUID = 1L;
	
	private String movieName;
	private float moviePrice;

	public SetPriceCommand(String movName,float price) {

		this.movieName=movName;
		this.moviePrice=price;
	}

	@Override
	public boolean execute(Inventory inventObject) {
		
		return inventObject.setPrice(movieName,moviePrice);

	}


}