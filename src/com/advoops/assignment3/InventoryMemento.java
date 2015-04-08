

package com.advoops.assignment3;

import java.io.Serializable;

public class InventoryMemento implements Serializable {

	private static final long serialVersionUID = 1L;
	private Inventory invent;

	   public InventoryMemento(Inventory inventToSave){
	      this.invent = inventToSave;
	   }

	   public Inventory getInventory(){
	      return invent;
	   }
}
