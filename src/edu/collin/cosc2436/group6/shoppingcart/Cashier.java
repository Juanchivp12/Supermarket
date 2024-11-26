package edu.collin.cosc2436.group6.shoppingcart;

import edu.collin.cosc2436.group6.cashregisterrevisited.MissingCategoryException;
import edu.collin.cosc2436.group6.cashregisterrevisited.MissingItemsException;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * This class makes a cashier
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Cashier 
{
	private final String name;
	
	/**
	 * Constructs a cashier
	 * @param name the name of the cashier
	 */
	public Cashier(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the name of the cashier
	 * @return String the name
	 */
	public String getName()
	{
		return name;
	}
	
	public void handleCheckoutCounter(CheckoutCounter counter) throws MissingCategoryException, MissingItemsException
	{
		Customer readyCustomer = counter.getReadyCustomer();
		CashRegister register = counter.getRegister();
		
		System.out.println(getName() + " is checking if a customer is ready");
		
		if (readyCustomer != null)
		{
			System.out.println(getName() + " is checking out " + readyCustomer.getName());
			ShoppingCart cart = readyCustomer.getCart();
			register.startTransaction();
			while (!cart.isEmpty())
			{
				RetailItem item = cart.takeItemFromCart();
				register.scanItem(item);
				System.out.println(getName() + " is scanning " + item.getName());
			}
			
			System.out.println();
			System.out.println(readyCustomer.getName() + "'s receipt:");
			readyCustomer.takeReceipt(register);
			
		}
		else 
		{
			System.out.println("There's no customer ready to checkout");
		}
	}
}
