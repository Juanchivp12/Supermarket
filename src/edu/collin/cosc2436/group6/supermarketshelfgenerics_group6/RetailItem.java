package edu.collin.cosc2436.group6.supermarketshelfgenerics_group6;

/**
 * This is a Retail Item class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class RetailItem implements Comparable<RetailItem>
{
	
private final String name;
	
	/**
	 * This constructs the name of retail item
	 * @param name the name of the retail item
	 */
	public RetailItem(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the name of the retail item
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * compares two retailItem objects
	 * @param item item to be compared
	 * @return the result of the comparison. -1 if less, 0 if equal, 1 if greater
	 */
	public int compareTo(RetailItem other)
	{
	
		return getName().compareTo(other.getName());
	}

	/**
	 * This is an overridden to string method that returns the name
	 */
	@Override
	public String toString() 
	{
		return getName();
	}

}
