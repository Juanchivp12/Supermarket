package edu.collin.cosc2436.group6.shoppinglist;

import java.util.HashMap;

import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.SmartShelf;



/**
 * Implementation of a Super market
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class SuperMarket
{
	private final HashMap<String, SmartShelf<? extends RetailItem>> smartShelves;

	public SuperMarket() 
	{
		this.smartShelves = new HashMap<>();
	}
	
	/**
	 * Adds a shelf to the smart shelf map
	 * @param shelfToAdd name of shelf to add
	 */
	public void addShelf(SmartShelf<? extends RetailItem> shelfToAdd)
	{
		smartShelves.put(shelfToAdd.getShelfName(), shelfToAdd);
	}
	
	/**
	 * This method removes a smart shelf from the map
	 * @param shelfToRemove 
	 */
	public void remove(String shelfToRemove)
	{
		smartShelves.remove(shelfToRemove);
	}
	
	/**
	 * This method finds a shelf by its name
	 * @param shelfName the name of the shelf
	 * @return the shelf
	 */
	public SmartShelf<? extends RetailItem> findShelfByName(String shelfName)
	{
		return smartShelves.get(shelfName);
	}
	
}
