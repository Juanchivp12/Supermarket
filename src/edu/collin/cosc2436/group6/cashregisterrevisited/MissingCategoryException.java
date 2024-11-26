package edu.collin.cosc2436.group6.cashregisterrevisited;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;

/**
 * This is a missing category exception class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class MissingCategoryException extends Exception 
{

	private static final long serialVersionUID = -6081132942444520823L;
	
	/**
	 * Constructs a missing category exception
	 * @param type a retail item type
	 */
	public MissingCategoryException(RetailItemType type)
	{
		super("Missing category of: " + type);
	}

}
