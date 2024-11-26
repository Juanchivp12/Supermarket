package edu.collin.cosc2436.group6.shoppingcart;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.collin.cosc2436.group6.cashregisterrevisited.MissingCategoryException;
import edu.collin.cosc2436.group6.cashregisterrevisited.MissingItemsException;
import edu.collin.cosc2436.group6.cashregisterrevisited.RetailItemLookUp;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.ActivePromotion;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.Promotion;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;
/**
 * @author Juan, Brian, Luke This class logs items as purchased and
 *         generates/formats/prints a receipt.
 */
public class CashRegister 
{
	
	private static RetailItemLookUp lookUp;

	private static ActivePromotion promotions;
	private List<RetailItem> purchasedItems;

	/**
	 * This method sets the value of the lookUp field
	 * 
	 * @param itemLookUp
	 */
	public static void setRetailItemLookUp(RetailItemLookUp itemLookUp) 
	{
		lookUp = itemLookUp;
	}

	/**
	 * This method starts a new receipt
	 */
	public void startTransaction() 
	{
		purchasedItems = new LinkedList<>();
	}

	/**
	 * This method adds a retail item to the receipt
	 * 
	 * @param item
	 */
	public void scanItem(RetailItem item) 
	{
		purchasedItems.add(item);
	}

	/**
	 * This method prints out a formatted receipt
	 * 
	 * @throws MissingItemException
	 * @throws MissingCategoryException
	 */
	public String printReceipt() throws MissingCategoryException, MissingItemsException
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		
		Iterator<RetailItem> iterator = purchasedItems.iterator();
		double subTotal = 0;
		double totalTax = 0;
		while (iterator.hasNext()) 
		{
			RetailItem currentItem = iterator.next();
			try 
			{
				double currentPrice = lookUp.getPrice(currentItem);
				// double currentDiscount = 0;
				out.printf("%-10s $%5.2f %n", currentItem.getName(), currentPrice);

				Promotion currentPromo = promotions.findBestPromotion(currentItem);
				if (currentPromo != null) 
				{
					double discount = currentPrice * currentPromo.determineDiscount(currentItem) / 100.0;
					currentPrice -= discount;
					out.printf("%10s %s -$%.2f\n", "Promo: ", currentPromo.getName(), discount);
				}

				subTotal += currentPrice;
				totalTax += lookUp.computeTax(currentItem);
			} catch (MissingCategoryException | MissingItemsException e) 
			{
				out.println(e);
				iterator.remove();
			}
		}

		out.println();
		out.printf("%-10s $%5.2f %n", "Subtotal", subTotal);
		out.printf("%-10s $%5.2f %n", "Tax", totalTax);
		out.printf("%-10s $%5.2f %n", "Total", subTotal + totalTax);
		out.println("-----------------");
		
		return stream.toString();
	}

	/**
	 * gets active promotions
	 * 
	 * @return the active promotions
	 */
	public static ActivePromotion getPromotions() 
	{
		return promotions;
	}

	/**
	 * sets active promotions
	 * 
	 * @param promotions the active promotions
	 */
	public static void setActivePromotions(ActivePromotion promotions) 
	{
		CashRegister.promotions = promotions;
	}
	
	/**
	 * @return lookUp item
	 */
	public static RetailItemLookUp getLookUp() 
	{
		return lookUp;
	}

	/**
	 * @param lookUp the lookUp item to set
	 */
	public static void setLookUp(RetailItemLookUp lookUp) 
	{
		CashRegister.lookUp = lookUp;
	}

}
