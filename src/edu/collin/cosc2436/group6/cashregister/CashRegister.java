package edu.collin.cosc2436.group6.cashregister;

import java.util.ArrayList;


/**
 * This is the Cash Register class, it puts items in an array list and processes them
 */
public class CashRegister 
{
	private static RetailItemLookUp lookUp;
	private ArrayList<RetailItemType> purchasedItems;
	
	/**
	 * This method sets the value of the lookUp field
	 * @param itemLookUp
	 */
	public static void setRetailItemLookUp(RetailItemLookUp itemLookUp)
	{
		lookUp = itemLookUp;
	}
	
	/**
	 * This method creates an instance of the purchased items array list
	 */
	public void startTransaction()
	{
		purchasedItems = new ArrayList<>();
	}
	
	/**
	 * This method adds a retail item to the array list of purchased items
	 * @param item
	 */
	public void scanItem(RetailItemType item)
	{
		purchasedItems.add(item);
	}
	
	/**
	 * This method calculates subtotal by iterating over the array list of purchased items
	 * @return the subtotal
	 */
	private double calculateSubTotal()
	{
		double subtotal = 0;
		
		for (RetailItemType item : purchasedItems)
		{
			subtotal += lookUp.getPrice(item);
		}
		
		return subtotal;
	}
	
	/**
	 * This method calculates the tax by iterating over the array list of purchased items
	 * @return the tax
	 */
	private double calculateTax()
	{
		double tax = 0;
		
		for (RetailItemType item : purchasedItems)
		{
			tax += lookUp.computeTax(item);
		}
		
		return tax;
	}
	
	/**
	 * This method prints out a formatted receipt
	 */
	public void printReceipt()
	{
		double subTotal = calculateSubTotal();
		double tax = calculateTax();
		double total = calculateSubTotal() + calculateTax();
		
		for (RetailItemType item : purchasedItems)
		{
			System.out.printf("%-10s $%5.2f %n", item, lookUp.getPrice(item));
		}
		
		System.out.println();
		System.out.printf("%-10s $%5.2f %n", "Subtotal", subTotal);
		System.out.printf("%-10s $%5.2f %n", "Tax", tax);
		System.out.printf("%-10s $%5.2f %n", "Total", total);
		System.out.println("-----------------");
	}
	
	
}
