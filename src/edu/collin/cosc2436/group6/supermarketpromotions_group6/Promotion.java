package edu.collin.cosc2436.group6.supermarketpromotions_group6;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

/**
 * This is a Promotion class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Promotion
{
	private final String name;
	private final int discountPercentage;
	private final LocalDate localDate;
	private final HashSet<RetailItem> itemsWithPromo = new HashSet<>();
	
	/**
	 * Constructs a promotion class
	 * @param name the promotion name
	 * @param discountPercentage the percentage of the discount
	 * @param localDate the local date
	 * @param itemsWithPromo set of items the promotion applies to
	 */
	public Promotion(String name, int discountPercentage, LocalDate localDate) 
	{
		super();
		this.name = name;
		this.discountPercentage = discountPercentage;
		this.localDate = localDate;
	}

	/**
	 * Gets the name of the promotion
	 * @return name 
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Gets the discount percentage
	 * @return discountPercentage
	 */
	public int getDiscountPercentage() 
	{
		return discountPercentage;
	}

	/**
	 * Gets the local date
	 * @return localDate
	 */
	public LocalDate getLocalDate() 
	{
		return localDate;
	}
	
	/**
	 * This method determines the discount of an item if it is an item with a promotion
	 * @param item the item passed as an argument
	 * @return the discount percentage
	 */
	public int determineDiscount(RetailItem item)
	{
		int ret = 0;
		
		if (itemsWithPromo.contains(item))
		{
			ret = getDiscountPercentage();
		}
		return ret;
	}
	
	/**
	 * Adds a retail item to the set
	 * @param item
	 */
	public void addItem(RetailItem item)
	{
		itemsWithPromo.add(item);
	}
	
	/**
	 * Adds all items to a collection
	 * @param <T>
	 * @param items
	 */
	public <T extends RetailItem> void addAllItems(Collection<T> items)
	{
		itemsWithPromo.addAll(items);
	}
}
