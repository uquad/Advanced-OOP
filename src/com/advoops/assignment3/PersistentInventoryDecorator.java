

package com.advoops.assignment3;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.commons.codec.binary.Base64;


public class PersistentInventoryDecorator extends AbstractInventory {
	
	private Inventory invent;
	private Command commandToDo;
	private int commandsExecutedCount=0;
	private File commandListFile=new File("D:\\oops\\commands.ser");
	private File inventoryMementoFile= new File("D:\\oops\\InventoryBackup.ser");

	  public PersistentInventoryDecorator(Inventory concreteInventory) {
		
		invent=concreteInventory;
		this.restorefromBackUp();
	}

	  @Override
	  public boolean add(String movieName,float moviePrice,int quantity)
	  {

		  commandToDo=new AddMovieCommand(movieName,moviePrice,quantity);	  
		  boolean addSuccessful=commandToDo.execute(invent);
		  commandToDo.save(commandListFile);
		  
		   if(addSuccessful) {
			   commandsExecutedCount++;
		   }
		   
		   if(commandsExecutedCount==5) {
			   this.refreshBackUp();
			   commandsExecutedCount=0;
		   }
		   
		  return addSuccessful;	 
	  }
	  
	  @Override
	  public boolean sell(String movieName,int quantity)
	  {

		  commandToDo=new SellMovieCommand(movieName,quantity);
		  boolean sellSuccessful=commandToDo.execute(invent);
		  commandToDo.save(commandListFile);
		  
		   if(sellSuccessful) {
			   commandsExecutedCount++;
		   }
		   
		   if(commandsExecutedCount==5){
			   this.refreshBackUp();
			   commandsExecutedCount=0;
		   }
		   
		  return sellSuccessful;	
	  }
	  
	  @Override
	  public boolean addNewCopy(String movieName,int quantity)
	  {

		  commandToDo=new AddNewCopyCommand(movieName,quantity);
		  boolean addNewCopySuccessful=commandToDo.execute(invent);
		  commandToDo.save(commandListFile);
		  
		   if(addNewCopySuccessful){
			   commandsExecutedCount++;
		   }
		   
		   if(commandsExecutedCount==5){
			   this.refreshBackUp();
			   commandsExecutedCount=0;
		   }
		   
		  return addNewCopySuccessful;	
	  }
	  
	  @Override
	  public boolean setPrice(String movieName, float price) 
	  {

		  commandToDo=new SetPriceCommand(movieName, price);	
		  boolean priceSetSuccessfully=commandToDo.execute(invent);
		  commandToDo.save(commandListFile);
			  
			   if(priceSetSuccessfully) {
				   commandsExecutedCount++;
			   }
			   if(commandsExecutedCount==5) {
				   this.refreshBackUp();
				   commandsExecutedCount=0;
			   }
			   
			  return priceSetSuccessfully;	
		}
	  
	  
	  
	  
	  
	  
	  
	  @Override
	  public float findPrice(String movieName){
		  
			  return invent.findPrice(movieName);		  
	  	  }
		
	  @Override
	  public float findPrice(int id) {
		  
			  return invent.findPrice(id);
		  }
		
	  @Override
	  public int findQuantity(String movieName) {
		  
			  return invent.findQuantity(movieName);
		  }
		
	  @Override
	  public int findQuantity(int id){
		  
			  return invent.findQuantity(id);
		  }
	  
	  @Override
	  public boolean contains(String movieName) {
			return invent.contains(movieName);
		}

	  @Override
	  public int getId(String movieName) {

			return invent.getId(movieName);
		}
	  
	  
	  private ArrayList<Command> restoreCommands() {

		  	Base64 decoder=new Base64();	        
	        ArrayList<Command> commands = new ArrayList<Command>();
	        ByteArrayInputStream byteArrStream;
	        ObjectInputStream objectOutputStream;
	        
	        
	        try {
	        	
	            Scanner commandsFile = new Scanner(commandListFile);
	            while (commandsFile.hasNext())
	            {
	                String encodedCommand = commandsFile.nextLine();
	                byteArrStream = new ByteArrayInputStream(decoder.decode(encodedCommand));
	                objectOutputStream = new ObjectInputStream(byteArrStream);
	                Command command = (Command) objectOutputStream.readObject();
	                commands.add(command);
	            }
	            commandsFile.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return commands;
	    }

	  
	  private void refreshBackUp()
	  {

		  File backupInventory=null;
		  
		  try {
			  //creating a backup of the inventoryMemento File
			  backupInventory= new File(inventoryMementoFile.getCanonicalPath() + ".backup"); 
			  //renaming existing inventory file to 'inventory.backup'
			  inventoryMementoFile.renameTo(backupInventory);
			  FileOutputStream fos=new FileOutputStream(inventoryMementoFile);
			  ObjectOutputStream out = new ObjectOutputStream(fos);
		      out.writeObject(invent.saveInventoryStateToMemento());
		      out.close();
		      //deleting backup file after successful write
		      backupInventory.delete();
			  		  
			  commandListFile.delete();
			
		  }
		  catch (IOException e)
		  {
			//restoring the inventory file from '.backup' after failed write
			backupInventory.renameTo(inventoryMementoFile);
			e.printStackTrace();
		  }
		  
	  }
	  
	  private void restorefromBackUp()
	  {
		  
		  if(inventoryMementoFile.exists())
		  { 
	  
			  try
		      {
				 FileInputStream fis=new FileInputStream(inventoryMementoFile);
		         ObjectInputStream in = new ObjectInputStream(fis);
				 invent.getInventoryStateFromMemento((InventoryMemento) in.readObject());
		         in.close();
		      }
			  catch(IOException i)
		      {
		         i.printStackTrace();	      
		      } 
			  catch (ClassNotFoundException e) 
			  {

				e.printStackTrace();
			  }
			  
		  }
		  
		  if(commandListFile.exists())
		  {
			  ArrayList<Command> commandList;
			  commandList=this.restoreCommands();
			  Iterator<Command> iter=commandList.iterator();
			  
			  while(iter.hasNext())
			  {
				  Command commandToDo=iter.next();
				  commandToDo.execute(invent);
			  }
		  
		  }
	  }
	  
}
