package edu.collin.cosc2436.group6.shoppinglist;

import java.util.Iterator;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.IShelfCustomer;
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
	private <T> void takeItemFromShelf(IShelfCustomer<T> shelf, String item, RetailItemType type) throws OutOfStockException
	{
		System.out.println(getName() + " getting from " + shelf.getShelfName() + ": " + item);
		System.out.println(getName() + " got " + shelf.findAndTake(item, type));
	}
	
	/**
	 * This method serves as a shopping simulator for a customer
	 * @param shoppingList a linked list a shopping list
	 * @param market the supermarket
	 */
	public void shop(MyList<ShoppingListEntry> shoppingList, SuperMarket market)
	{
		System.out.println(getName() + " needs to buy:");
		
		for (ShoppingListEntry entry : shoppingList)
		{
			System.out.println(entry);
		}
		System.out.println();
		
		Iterator<ShoppingListEntry> iter = shoppingList.iterator();
		while (iter.hasNext())
		{
			ShoppingListEntry entry = iter.next();
			try 
			{
				takeItemFromShelf(market.findShelfByName(entry.getShelfName()), entry.getItemName(), entry.getItemType());
				iter.remove();
			} catch (OutOfStockException e) 
			{
				System.out.println(e);
			}
		}
		System.out.println();
		
		if (shoppingList.isEmpty())
		{
			System.out.println(getName() + " got everything");
			System.out.println();
		}
		else 
		{
			System.out.println(getName() + " still has on the list:");
			for (ShoppingListEntry entry : shoppingList)
			{
				System.out.println(entry);
			}
			System.out.println();
		}
		
	}
}
