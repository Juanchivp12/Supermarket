package edu.collin.cosc2436.group6.shoppingcart;

import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * implementation of a shopping cart
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class ShoppingCart 
{
	private final int cartId;
	private MyStack<RetailItem> itemsStack;
	
	/**
	 * Constructs a shopping cart
	 * @param cartId a cart ID
	 */
	public ShoppingCart(int cartId) 
	{
		this.cartId = cartId;
		itemsStack = new MyArrayStack<>();
	}

	/**
	 * Gets the cart ID
	 * @return a string 
	 */
	public int getCartId() 
	{
		return cartId;
	}
	
	/**
	 * This method puts an item on the cart 
	 * @param item any retail item
	 */
	public void putItemOnCart(RetailItem item)
	{
		itemsStack.push(item);
	}
	
	/**
	 * This method takes the last item that was put on the cart
	 * @return the last item in the cart 
	 */
	public RetailItem takeItemFromCart()
	{
		return itemsStack.pop();
	}
	
	/**
	 * Checks if cart is empty
	 * @return empty or not
	 */
	public boolean isEmpty()
	{
		return itemsStack.isEmpty();
	}
}
