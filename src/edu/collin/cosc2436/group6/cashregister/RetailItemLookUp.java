package edu.collin.cosc2436.group6.cashregister;

/**
 * This is the retail item look up class. It gets the price for items as well as the tax.
 */
public class RetailItemLookUp 
{
	public final double taxRate;
	public final double[] prices;
	
	/**
	 * This is a constructor that initializes the fields
	 * @param taxRate the value for tax Rate
	 * @param prices an array of prices 
	 */
	public RetailItemLookUp(double taxRate, double[] prices)
	{
		this.taxRate = taxRate;
		this.prices = new double[prices.length];
		
		for (int i = 0; i < prices.length; ++i)
		{
			this.prices[i] = prices[i];
		}
	}
	
	/**
	 * This method gets the price of an item
	 * @param item an enum
	 * @return the ordinal value of the enum
	 */
	public double getPrice(RetailItemType item)
	{
		return prices[item.ordinal()];
	}
	
	/**
	 * This method calculates tax for the taxable items
	 * @param item an enum
	 * @return the tax calculated
	 */
	public double computeTax(RetailItemType item)
	{
		double price = getPrice(item);
		double tax = 0;
		
		switch (item)
		{
			case CHIPS:
			case CEREAL:
				break;
			case SOAP:
			case SODA:
				tax = price * taxRate;
		}
		return tax;
	}
	
	
}
