package edu.collin.cosc2436.group6.cashregisterrevisited;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * This class makes the Soda shelf
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Soda extends RetailItem
{
	/**
	 * constructs a cereal
	 * @param name
	 */
	public Soda(String name) 
	{
		super(name, RetailItemType.SODA);
	}
}
