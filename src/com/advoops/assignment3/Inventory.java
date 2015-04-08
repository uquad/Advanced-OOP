

package com.advoops.assignment3;

import java.io.Serializable;
import java.util.Hashtable;

public class Inventory  extends AbstractInventory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idCount=0;
	private Hashtable<String,Movie> moviesByNames=new Hashtable<String,Movie>();
	private Hashtable<Integer,Movie> moviesById=new Hashtable<Integer,Movie>();

	
	@Override
	public boolean add(String movieName,float moviePrice,int quantity)
	{
		Movie movieToAdd;
		if(moviesByNames.containsKey(movieName))//movie already exists
		{
			movieToAdd=moviesByNames.get(movieName);
			int currentQuantity=movieToAdd.getQuantity();
			movieToAdd.setQuantity(currentQuantity+quantity);
			return true;
		}
		else
		{
			movieToAdd=new Movie(idCount++,movieName,moviePrice,quantity);
			moviesByNames.put(movieName, movieToAdd);
			moviesById.put(idCount, movieToAdd);
			return true;	
		}
	}
	
	
	
	@Override
	public boolean sell(String movieName,int quantity)
	{
		Movie movieToSell;
		if(moviesByNames.containsKey(movieName))
		{
		 movieToSell=moviesByNames.get(movieName);
		 int currentQuantity=movieToSell.getQuantity();
		 if(currentQuantity<quantity){
			 return false;
		 }
		 movieToSell.setQuantity(currentQuantity-quantity);
		 return true;
		}
		else 
		{
			return false;
		}				
	}
	
	
	
	
	@Override
	public boolean addNewCopy(String movieName,int quantity)
	{
		Movie movieToIncrease;
		if(moviesByNames.containsKey(movieName))
		{
		 movieToIncrease=moviesByNames.get(movieName);
		 int currentQuantity=movieToIncrease.getQuantity();
		 movieToIncrease.setQuantity(currentQuantity+quantity);
		 
		 return true;
		}
		else 
		{
			return false;
		}	
	}
	
	@Override
	public boolean setPrice(String movieName,float price)
	{
		Movie movie;
		if(moviesByNames.containsKey(movieName))
		{
		 movie=moviesByNames.get(movieName);
		 movie.setPrice(price);
		 return true;
		}
		else 
		{
			return false;
		}	
	}
	
	@Override		
	public float findPrice(String movieName)
	{
		if(moviesByNames.containsKey(movieName))
		{
			Movie movie;
			movie=moviesByNames.get(movieName);
			return movie.getPrice();
		}
		else
		{
			return 0;
		}
			
	}
	
	
	
	
	
	
	@Override
	public float findPrice(int id)
	{
		if(moviesById.containsKey(id))
		{
			Movie movie;
			movie=moviesById.get(id);
			return movie.getPrice();
		}
		else
		{
			return 0;
		}
		
	}
	
	
	
	
	@Override
	public int findQuantity(String movieName)
	{
		if(moviesByNames.containsKey(movieName))
		{
			Movie movie;
			movie=moviesByNames.get(movieName);
			return movie.getQuantity();
		}
		else
		{
			return 0;
		}
		
	}
	
	@Override
	public int findQuantity(int id)
	{
		if(moviesById.containsKey(id))
		{
			Movie movie;
			movie=moviesById.get(id);
			return movie.getQuantity();
		}
		else
		{
			return 0;
		}
		
	}
	
	@Override
	public boolean contains(String movieName) {

		return moviesByNames.containsKey(movieName);
	}

	@Override
	public int getId(String movieName) {
		Movie movie;
		if(moviesByNames.containsKey(movieName))
		{
			movie=moviesByNames.get(movieName);	
			return movie.getId();
		}
		else
		{
			return 0;
		}

	}	

	protected InventoryMemento saveInventoryStateToMemento(){
		      return new InventoryMemento(this);
		   }
   
	
	protected Inventory getInventoryStateFromMemento(InventoryMemento memento){
	
		Inventory inventFromMemento=memento.getInventory();
			
			      this.moviesByNames=inventFromMemento.moviesByNames;
			      this.moviesById=inventFromMemento.moviesById;
			      this.idCount=inventFromMemento.idCount;
			      return inventFromMemento;
		   }
	
}
