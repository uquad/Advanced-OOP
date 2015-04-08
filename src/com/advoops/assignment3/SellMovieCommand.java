

package com.advoops.assignment3;

public class SellMovieCommand extends Command {


	private static final long serialVersionUID = 1L;

	private String movieName;
	private int quantity;

	public SellMovieCommand(String movName,int qty) {

		this.movieName=movName;
		this.quantity=qty;
	}

	@Override
	public boolean execute(Inventory inventObject) {
					
		return inventObject.sell(movieName,quantity);
	
	}

}
