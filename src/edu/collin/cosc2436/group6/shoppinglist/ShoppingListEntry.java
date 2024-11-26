package edu.collin.cosc2436.group6.shoppinglist;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;

/**
 * Implementation of a shopping list entry
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class ShoppingListEntry 
{
	private final String itemName;
	private final RetailItemType itemType;
	private final String shelfName;
	
	/**
	 * Constructs a shopping list entry
	 * @param itemName the name of the item
	 * @param itemType the type of the item
	 * @param shelfName the name of the shelf to get the item from
	 */
	public ShoppingListEntry(String itemName, RetailItemType itemType, String shelfName) 
	{
		this.itemName = itemName;
		this.itemType = itemType;
		this.shelfName = shelfName;
	}

	/**
	 * Gets the item name
	 * @return itemName, a String
	 */
	public String getItemName() 
	{
		return itemName;
	}

	/**
	 * Gets the item type
	 * @return itemType, a RetailItemType
	 */
	public RetailItemType getItemType() 
	{
		return itemType;
	}

	/**
	 * Gets the shelf name
	 * @return shelfName, a String
	 */
	public String getShelfName() 
	{
		return shelfName;
	}

	/**
	 * This is a toString method 
	 */
	@Override
	public String toString() 
	{
		return getItemType() + ": " + getItemName() + " from " + getShelfName();
	}
	
	
}
