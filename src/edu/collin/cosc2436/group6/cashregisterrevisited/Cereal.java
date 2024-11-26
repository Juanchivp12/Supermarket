package edu.collin.cosc2436.group6.cashregisterrevisited;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * This class makes the cereal shelf
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Cereal extends RetailItem
{
	/**
	 * constructs a cereal
	 * @param name
	 */
	public Cereal(String name) 
	{
		super(name, RetailItemType.CEREAL);
	}
}
