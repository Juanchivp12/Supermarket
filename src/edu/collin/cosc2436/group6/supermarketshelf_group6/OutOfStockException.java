package edu.collin.cosc2436.group6.supermarketshelf_group6;

/**
 * This is an exception class to be thrown when item is out of stock
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class OutOfStockException extends Exception 
{

	private static final long serialVersionUID = -4571735405117819504L;

	/**
	 * This constructs the exception to be thrown when item is out of stock
	 * @param message string sent to constructor
	 */
	public OutOfStockException(String item) 
	{
		super(item + " is out of stock");
	}
	

}
