

package com.advoops.assignment3;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersistentInventoryDecoratorTest {

@Test
public void inventoryBackupAndRestoreTest() {
	Inventory invent=new Inventory();
	PersistentInventoryDecorator pInvent=new PersistentInventoryDecorator(invent);
	//after 5 commands inventoryMemento is saved to file and command file is deleted
	pInvent.add("Gladiator", 100,4);
	pInvent.add("Hercules",50,8);
	pInvent.add("Sparta",300,3);
	pInvent.addNewCopy("Sparta",7);
	pInvent.add("James Bond",200,7);
	pInvent.add("Incenption",200,20);
	pInvent.setPrice("Gladiator", 7000);
	pInvent.sell("Sparta",5);
		
		
	Inventory restoredInvent=new Inventory();
	//the inventory restoredInvent has its state restored to the state saved on file using 
	//inventoryMemento and commandlist by the PersistentInventoryDecorator
	PersistentInventoryDecorator pRestoredInv=new PersistentInventoryDecorator(restoredInvent);
		
	//the inventory in memory and the one restored from file will have the same state
	assertEquals(invent.findQuantity("Gladiator"),restoredInvent.findQuantity("Gladiator"));
	assertEquals(invent.findQuantity("Hercules"),restoredInvent.findQuantity("Hercules"));
	assertEquals(invent.findQuantity("Sparta"),restoredInvent.findQuantity("Sparta"));
	assertEquals(invent.findQuantity("Incenption"),restoredInvent.findQuantity("Incenption"));
	assertEquals(invent.findQuantity("James Bond"),restoredInvent.findQuantity("James Bond"));


	}

}
