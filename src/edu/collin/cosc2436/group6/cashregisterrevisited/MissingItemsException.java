package edu.collin.cosc2436.group6.cashregisterrevisited;

/**
 * This is a missing items exception class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class MissingItemsException extends Exception 
{

	private static final long serialVersionUID = -3116763749987028203L;
	
	/**
	 * Constructs a missing items exception
	 * @param itemName a string, the name of an item
	 */
	public MissingItemsException(String itemName)
	{
		super(itemName + " not found");
	}

}
