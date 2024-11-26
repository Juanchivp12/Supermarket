package edu.collin.cosc2436.group6.cashregisterrevisited;

import java.util.HashMap;

import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * This is a class for the pricing category
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class PricingCategory 
{
	private final boolean taxable;
	final HashMap<RetailItem, Double> pricesMap;
	
	/**
	 * Constructs a pricing category
	 * @param taxable a boolean to determine if taxable
	 * @param pricesMap a Hash map with RetailItem keys and Double values
	 */
	public PricingCategory(boolean taxable) 
	{
		this.taxable = taxable;
		this.pricesMap = new HashMap<>();
	}

	/**
	 * Gets the boolean value if an item is taxable or not
	 * @return the boolean value
	 */
	public boolean isTaxable() 
	{
		return taxable;
	}
	
	/**
	 * This method adds an item and its price to the prices Hash map
	 * @param item retail item to be added as a key
	 * @param price price of that item that serves as the value to the item key
	 */
	public void addItem(RetailItem item, double price)
	{
		pricesMap.put(item, price);
		System.out.println("Added " + item.getName() + ": $" + price + " to " + item.getType());
	}
	
	/**
	 * This method finds an item from the map and returns its price
	 * @param item item to find
	 * @return the price
	 * @throws MissingItemsException exception to be thrown when item is not found
	 */
	public double findItem(RetailItem item) throws MissingItemsException
	{
		if (!pricesMap.containsKey(item))
		{
			throw new MissingItemsException(item.getName());
		}
		return pricesMap.get(item);
	}
}
