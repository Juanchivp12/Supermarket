package edu.collin.cosc2436.group6.supermarketshelf_group6;

import java.util.ArrayList;

/**
 * This is smart shelf class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class SmartShelf implements IShelfCustomer, IShelfEmployee
{
	private final String shelfType;
	private ArrayList<RetailItem> items;

	/**
	 * Constructs a smart shelf
	 * @param itemKind
	 * @param sortedItems
	 */
	public SmartShelf(String shelfType) 
	{
		this.shelfType = shelfType;
		this.items = new ArrayList<>();
	}
	
	/**
	 * This gets the value of the shelfType field
	 * @return the shelfType 
	 */
	public String getShelfType()
	{
		return shelfType;
	}

	/**
	 * This method places items on the shelf in correct order
	 * @param items an array list of retail items
	 */
	@Override
	public void placeItems(ArrayList<RetailItem> items) 
	{
		QuickSort.sort(items);
		this.items.addAll(items);
	}

	/**
	 * This method adds an item at a specific index
	 * @param item a retail item to add
	 */
	@Override
	public void addItem(RetailItem item) 
	{
		int position = Binary.insert(items, item);
		items.add(position, item);
	}

	/**
	 * This method finds an item in the list and returns if it was found, otherwise an exception is thrown
	 * @param item item being searched
	 * @throws OutOfStockException if item is not found in the list
	 */
	@Override
	public RetailItem findAndTake(RetailItem item) throws OutOfStockException 
	{
		int position = Binary.search(items, item);
		
		if (Binary.search(items, item) == -1)
		{
			throw new OutOfStockException(item.getName());
		}

		RetailItem removed = items.remove(position);
		return removed;
	}

	/**
	 * This mis an overriden toString method to print the contents of the array list
	 */
	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		
		
		for (RetailItem item : items)
		{
			builder.append(item).append("\n");
		}
		
		return builder.toString();
	}
	
	

}
