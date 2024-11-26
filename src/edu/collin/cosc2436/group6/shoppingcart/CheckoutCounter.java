package edu.collin.cosc2436.group6.shoppingcart;


/**
 * Simulates a checkout counter
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class CheckoutCounter 
{
	private final CashRegister register;
	private Customer readyCustomer;
	
	/**
	 * Constructs a Checkout counter
	 * @param register a cash register
	 * @param customer a customer ready to check out
	 */
	public CheckoutCounter(CashRegister register) 
	{
		this.register = register;
	}

	/**
	 * Gets a ready customer
	 * @return a customer
	 */
	public Customer getReadyCustomer() 
	{
		return readyCustomer;
	}

	/**
	 * Sets a ready customer
	 * @param customer 
	 */
	public void setReadyCustomer(Customer readyCustomer) 
	{
		this.readyCustomer = readyCustomer;
	}

	/**
	 * Gets a cash register
	 * @return CashRegister
	 */
	public CashRegister getRegister() 
	{
		return register;
	}	
}
