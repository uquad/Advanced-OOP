

package com.advoops.assignment3;

public class AddNewCopyCommand extends Command {

	private static final long serialVersionUID = 1L;	
	private String movieName;
	private int quantity;

	public AddNewCopyCommand(String movName,int qty) {

		this.movieName=movName;
		this.quantity=qty;
	}

	@Override
	public boolean execute(Inventory inventObject) {
		
		return inventObject.addNewCopy(movieName,quantity);	
	
	}



}
