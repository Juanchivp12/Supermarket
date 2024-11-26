package edu.collin.cosc2436.group6.supermarketpromotions_group6;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This is an active promotion class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class ActivePromotion
{
	private LinkedList<Promotion> promotions;
	
	/**
	 * Constructs an active promotion
	 * @param list
	 */
	public ActivePromotion(LinkedList<Promotion> promotions)
	{
		this.promotions = promotions;
	}
	
	/**
	 * Adds a promotion to the linked list of promotions
	 * @param promotion
	 */
	public void add(Promotion promotion)
	{
		promotions.add(promotion);
		System.out.println("Added promotion " + promotion.getName());
	}
	
	/**
	 * Removes a promotion from the list using an iterator
	 * @param promoToRemove promotion to be removed
	 */
	public void remove(String promoToRemove)
	{
		Iterator<Promotion> iter = promotions.iterator();
		
		while(iter.hasNext())
		{
			Promotion promotion = iter.next();
			
			if (promoToRemove.compareTo(promotion.getName()) == 0)
			{
				iter.remove();
				System.out.println("Removed " + promoToRemove);
				System.out.println();
			}
		}
	}
	
	/**
	 * Removes a promotion from the list if it is expired
	 */
	public void removeExpired()
	{
		Iterator<Promotion> iter = promotions.iterator();
		
		while(iter.hasNext())
		{
			Promotion promotion = iter.next();
			
			if (promotion.getLocalDate().isBefore(LocalDate.now()))
			{
				iter.remove();
				System.out.println("Removed expired");
				System.out.println();
			}
		}
	}
	
	/**
	 * This method determines the best promotion using sequential search
	 * @param item
	 * @return bestPromotion
	 */
	public Promotion findBestPromotion(RetailItem item)
	{
		Promotion bestPromotion = null;
		double maxDiscount = 0;
		
		for (Promotion promotion : promotions)
		{
			double discount = promotion.determineDiscount(item);
			
			if (discount > maxDiscount)
			{
				maxDiscount = discount;
				bestPromotion = promotion;
			}
		}
		return bestPromotion;
	}
}
