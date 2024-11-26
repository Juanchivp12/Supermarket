package edu.collin.cosc2436.group6.cashregisterrevisited;

import java.util.HashMap;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * This is the retail item look up class. It gets the price for items as well as the tax.
 */
public class RetailItemLookUp 
{
	public final double taxRate;
	public final HashMap<RetailItemType, PricingCategory> categoryMap;
	
	/**
	 * This is a constructor that initializes the fields
	 * @param taxRate the value for tax Rate
	 * @param categoryMap a Hash map of categories
	 */
	public RetailItemLookUp(double taxRate)
	{
		this.taxRate = taxRate;
		this.categoryMap = new HashMap<>();
	}
	
	/**
	 * This method adds a pricing category to the category map
	 * @param type the type of item
	 * @param taxable if taxable or not
	 * @throws DuplicateCategoryException exception to be thrown if category is already in map
	 */
	public void addPricingCategory(RetailItemType type, boolean taxable) throws DuplicateCategoryException
	{
		if (categoryMap.containsKey(type))
		{
			throw new DuplicateCategoryException(type);
		}
		
		categoryMap.put(type, new PricingCategory(taxable));
		System.out.println("Added a pricing category for " + type);
	}
	
	/**
	 * This method removes a pricing category specified by the key
	 * @param type the key of the value to be removed
	 */
	public void removePricingCategory(RetailItemType type)
	{
		categoryMap.remove(type);
	}
	
	/**
	 * Adds an item entry to a category
	 * @param item item to be added
	 * @param price price to be added to the category
	 * @throws MissingCategoryException exception to be thrown if category is missing
	 */
	public void addItemEntry(RetailItem item, double price) throws MissingCategoryException
	{
		PricingCategory category = findCategory(item.getType());
		category.addItem(item, price);
	}
	
	
	/**
	 * This method gets the price of an item
	 * @param item a retail item
	 * @return the ordinal value of the enum
	 */
	public double getPrice(RetailItem item) throws MissingCategoryException, MissingItemsException
	{
		PricingCategory category = findCategory(item.getType());
		return category.findItem(item);
	}
	
	/**
	 * This method calculates tax for the taxable items
	 * @param item an enum
	 * @return the tax calculated
	 * @throws MissingCategoryException 
	 * @throws MissingItemsException 
	 */
	public double computeTax(RetailItem item) throws MissingCategoryException, MissingItemsException
	{
		PricingCategory category = findCategory(item.getType());
		
		double price = getPrice(item);
		
		if (category.isTaxable())
		{
			return price * taxRate;
		}
		return price;
	}
	
	/**
	 * Private helper for when category is not found
	 * @param itemType type of the item
	 * @param category a pricing category
	 * @throws MissingCategoryException exception to be thrown if cateogry is missing
	 */
	private PricingCategory findCategory(RetailItemType itemType) throws MissingCategoryException
	{
		PricingCategory category = categoryMap.get(itemType);
		if (category == null)
		{
			throw new MissingCategoryException(itemType);
		}
		return category;
	}
	
	
}
