package edu.collin.cosc2436.group6.supermarketpromotions_group6;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;

/**
 * This is a Retail Item class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class RetailItem implements Comparable<RetailItem>
{
	
private final String name;
private final RetailItemType type;
	
	/**
	 * This constructs the name of retail item
	 * @param name the name of the retail item
	 */
	public RetailItem(String name, RetailItemType itemType)
	{
		this.name = name;
		this.type = itemType;
	}
	
	/**
	 * Gets the name of the retail item
	 * @return the name of the item
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method gets the type of a retail item
	 * @return RetailItemType an enum of retail item types
	 */
	public RetailItemType getType()
	{
		return type;
	}
	
	/**
	 * compares two retailItem objects
	 * @param item item to be compared
	 * @return the result of the comparison. -1 if less, 0 if equal, 1 if greater
	 */
	public int compareTo(RetailItem other)
	{
		String concatString = type.name() + name;
		String concatOther = other.type.name() + other.getName();
		return concatString.compareTo(concatOther);
	}
	
	/**
	 * This is an overridden implementation of the hashCode method 
	 * @return ret 
	 */
	@Override
	public int hashCode()
	{
		int ret = 17;
		ret = 31 * ret + name.hashCode();
		ret = 31 * ret + type.hashCode();
		return ret;
	}
	
	/**
	 * This method determines if two objects are equal
	 * @param obj the object to be compared with
	 * @return ret 
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean ret = false;
		if (obj instanceof RetailItem)
		{
			RetailItem item = (RetailItem) obj;
			ret = name.equals(item.name) && type == item.type; 
		}
		return ret;
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
