package edu.collin.cosc2436.group6.supermarketshelf_group6;

/**
 * This class makes a customer
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Customer 
{
	/**
	 * Takes an item from the shelf 
	 * @param shelf shelf to take an item from
	 * @param item item to take from the shelf
	 * @return item taken
	 * @throws OutOfStockException 
	 */
	public RetailItem takeItemFromShelf(IShelfCustomer shelf, RetailItem item) throws OutOfStockException
	{
			RetailItem itemTaken = shelf.findAndTake(item);
			return itemTaken;
	}
}
