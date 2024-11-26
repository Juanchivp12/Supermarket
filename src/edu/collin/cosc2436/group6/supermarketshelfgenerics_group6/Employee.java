package edu.collin.cosc2436.group6.supermarketshelfgenerics_group6;

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
	public <T> void putItemsOnShelf(IShelfEmployee<T> shelf, ArrayList<T> items)
	{
		System.out.println(name + " placing on " + shelf.getShelfName() + ":");
		for (T item : items)
		{
			System.out.println(item);
		}
		shelf.placeItems(items);
	}
	
	/**
	 * This adds an item to the shelf without losing its sort
	 * @param shelf the shelf to put the item on
	 * @param item the item to put on the shelf
	 */
	public <T> void addItemToShelf(IShelfEmployee<T> shelf, T item)
	{
		shelf.addItem(item);
		System.out.println(name + " adding to " + shelf.getShelfName() + ": " + item);
	}
	
}
