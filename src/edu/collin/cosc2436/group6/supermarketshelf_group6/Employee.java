package edu.collin.cosc2436.group6.supermarketshelf_group6;

import java.util.ArrayList;

/**
 * This class makes an employee
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Employee 
{
	private final String name;
	
	/**
	 * Constructs an employee
	 * @param name
	 */
	public Employee(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns the name of the employee
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This puts the unsorted list of items on the shelf, sorting them
	 * @param shelf the shelf to put the items on
	 * @param items the items to put on the shelf
	 */
	public void putItemsOnShelf(IShelfEmployee shelf, ArrayList<RetailItem> items)
	{
		shelf.placeItems(items);
	}
	
	/**
	 * This adds an item to the shelf without losing its sort
	 * @param shelf the shelf to put the item on
	 * @param item the item to put on the shelf
	 */
	public void addItemToShelf(IShelfEmployee shelf, RetailItem item)
	{
		shelf.addItem(item);
	}
	
}
