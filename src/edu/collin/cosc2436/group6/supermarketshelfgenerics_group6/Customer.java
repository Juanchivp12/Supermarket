package edu.collin.cosc2436.group6.supermarketshelfgenerics_group6;

import edu.collin.cosc2436.group6.supermarketshelf_group6.OutOfStockException;

/**
 * This class makes a customer
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Customer
{
	private final String name;
	
	/**
	 * Constructs a customer
	 * @param name
	 */
	public Customer(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns the name of the customer
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Takes an item from the shelf 
	 * @param <T> to parametize with any type of item
	 * @param shelf shelf to take an item from
	 * @param item item to take from the shelf
	 * @return item taken
	 * @throws OutOfStockException 
	 */
	public <T> void takeItemFromShelf(IShelfCustomer<T> shelf, String item) throws OutOfStockException
	{
		System.out.println(getName() + " getting from " + shelf.getShelfName() + ": " + item);
		try 
		{
			System.out.println(getName() + " got " + shelf.findAndTake(item));
		} catch (OutOfStockException e) 
		{
			System.out.println(e);
		}
	}
}
