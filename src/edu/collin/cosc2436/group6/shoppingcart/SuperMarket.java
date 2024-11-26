package edu.collin.cosc2436.group6.shoppingcart;

import java.util.Collection;
import java.util.HashMap;

import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.SmartShelf;



/**
 * Implementation of a Super market
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class SuperMarket
{
	private final HashMap<String, SmartShelf<? extends RetailItem>> smartShelves;
	private final MyStack<ShoppingCart> shoppingCarts;
	private final CheckoutCounter counter;

	/**
	 * Constructs a super market
	 * @param counter a check out counter
	 */
	public SuperMarket() 
	{
		this.smartShelves = new HashMap<>();
		this.shoppingCarts = new MyArrayStack<>();
		this.counter = new CheckoutCounter(new CashRegister());
		
	}
	
	/**
	 * Adds a shelf to the smart shelf map
	 * @param shelfToAdd name of shelf to add
	 */
	public void addShelf(SmartShelf<? extends RetailItem> shelfToAdd)
	{
		smartShelves.put(shelfToAdd.getShelfName(), shelfToAdd);
	}
	
	/**
	 * This method removes a smart shelf from the map
	 * @param shelfToRemove 
	 */
	public void remove(String shelfToRemove)
	{
		smartShelves.remove(shelfToRemove);
	}
	
	/**
	 * This method finds a shelf by its name
	 * @param shelfName the name of the shelf
	 * @return the shelf
	 */
	public SmartShelf<? extends RetailItem> findShelfByName(String shelfName)
	{
		return smartShelves.get(shelfName);
	}
	
	/**
	 * Gets a checkout Counter
	 * @return a checkout counter
	 */
	public CheckoutCounter getCounter()
	{
		return counter;
	}
	
	/**
	 * Stocks the super market with carts
	 * @param carts a collection of shopping carts
	 */
	public void stockCarts(Collection<ShoppingCart> carts)
	{
		for (ShoppingCart cart : carts)
		{
			shoppingCarts.push(cart);
			System.out.println("Cart " + cart.getCartId() + " added");
		}
	}
	
	/**
	 * Takes a shopping cart
	 * @return ShoppingCart the cart taken
	 */
	public ShoppingCart takeCart()
	{
		ShoppingCart cartTaken = shoppingCarts.pop();
		System.out.println("Cart " + cartTaken.getCartId() + " taken\n");
		return cartTaken;
	}
	
	/**
	 * Returns a cart 
	 */
	public void returnCart(ShoppingCart cartToReturn)
	{
		shoppingCarts.push(cartToReturn);
		System.out.println("Cart " + cartToReturn.getCartId() + " returned\n");
	}
	
}
