package edu.collin.cosc2436.group6.cashregisterrevisited;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * This class makes the soap shelf
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Soap extends RetailItem
{
	/**
	 * constructs a cereal
	 * @param name
	 */
	public Soap(String name) 
	{
		super(name, RetailItemType.SOAP);
	}
}
