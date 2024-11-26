package edu.collin.cosc2436.group6.shoppingcart;

import java.util.Iterator;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.cashregisterrevisited.MissingCategoryException;
import edu.collin.cosc2436.group6.cashregisterrevisited.MissingItemsException;
import edu.collin.cosc2436.group6.shoppinglist.MyList;
import edu.collin.cosc2436.group6.shoppinglist.ShoppingListEntry;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.IShelfCustomer;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;
import edu.collin.cosc2436.group6.supermarketshelf_group6.OutOfStockException;

/**
 * This class makes a customer
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Customer
{
	private final String name;
	private SuperMarket market;
	private ShoppingCart cart;
	
	/**
	 * Constructs a customer
	 * @param name
	 */
	public Customer(String name, SuperMarket market)
	{
		this.name = name;
		this.market = market;
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
	 * Gets a supermarket
	 * @return SuperMarket
	 */
	public SuperMarket getMarket() {
		return market;
	}

	/**
	 * Gets a shopping cart
	 * @return
	 */
	public ShoppingCart getCart() {
		return cart;
	}

	/**
	 * Takes an item from the shelf 
	 * @param <T> to parametize with any type of item
	 * @param shelf shelf to take an item from
	 * @param item item to take from the shelf
	 * @return item taken
	 * @throws OutOfStockException 
	 */
	private <T> RetailItem takeItemFromShelf(IShelfCustomer<T> shelf, String item, RetailItemType type) throws OutOfStockException
	{
		System.out.println(getName() + " getting from " + shelf.getShelfName() + ": " + item);
		RetailItem takenItem = (RetailItem) shelf.findAndTake(item, type);
		System.out.println(getName() + " got " + takenItem.getName());
		return takenItem;
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
		
		System.out.println(getName() + " is taking a cart from the supermarket");
		cart = market.takeCart();
		
		Iterator<ShoppingListEntry> iter = shoppingList.iterator();
		while (iter.hasNext())
		{
			ShoppingListEntry entry = iter.next();
			try 
			{
				cart.putItemOnCart(takeItemFromShelf(market.findShelfByName(entry.getShelfName()), entry.getItemName(), entry.getItemType()));
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
	
	/**
	 * A customer checking out
	 */
	public void checkOut()
	{
		CheckoutCounter counter = market.getCounter();
		System.out.println(getName() + " is checking out");
		System.out.println();
		counter.setReadyCustomer(this);
	}
	
	/**
	 * Takes receipt and prints it to the console
	 * @param register a cash register
	 * @throws MissingCategoryException
	 * @throws MissingItemsException
	 */
	public void takeReceipt(CashRegister register) throws MissingCategoryException, MissingItemsException
	{
		String receipt = register.printReceipt();
		System.out.println(receipt);
		register.printReceipt();
		System.out.println(getName() + " is returning shopping cart");
		market.returnCart(cart);
	}
}
