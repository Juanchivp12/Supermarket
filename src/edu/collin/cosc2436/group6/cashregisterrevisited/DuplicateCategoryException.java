package edu.collin.cosc2436.group6.cashregisterrevisited;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;

/**
 * This is a duplicate category exception class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class DuplicateCategoryException extends Exception 
{

	private static final long serialVersionUID = 4407397479209602207L;
	
	/**
	 * Constructs a duplicate category exception
	 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
	 */
	public DuplicateCategoryException(RetailItemType type)
	{
		super(type + " category already exists");
	}

}
