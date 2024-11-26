package edu.collin.cosc2436.group6.cashregisterrevisited;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.ActivePromotion;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.Promotion;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;

/**
 * This is the demo for a cash register
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class CashRegisterDemo 
{
	public static void main(String[] args) throws MissingCategoryException, MissingItemsException, DuplicateCategoryException
	{	
		RetailItemLookUp lookUp = new RetailItemLookUp(.0825);
		
		Set<Cereal> cerealItemsSet = new HashSet<>();
		Set<Chips> chipsItemsSet = new HashSet<>();
		Set<Soda> sodaItemsSet = new HashSet<>();
		Set<Soap> soapItemsSet = new HashSet<>();
		
		lookUp.addPricingCategory(RetailItemType.CEREAL, false);
		lookUp.addPricingCategory(RetailItemType.CHIPS, false);
		lookUp.addPricingCategory(RetailItemType.SODA, true);
		lookUp.addPricingCategory(RetailItemType.SOAP, true);
		System.out.println();
		
		// Scans cereal.txt file
		ArrayList<Cereal> cerealItems = new ArrayList<>();
		Scanner cerealScanner = new
		Scanner(CashRegisterDemo.class.getResourceAsStream("/cereal.txt"));
		
		while (cerealScanner.hasNext()) 
		{
		cerealItems.add(new Cereal(cerealScanner.nextLine()));
		}
		cerealScanner.close();
		
		// Scans chips.txt file
		ArrayList<Chips> chipsItems = new ArrayList<>();
		Scanner chipScanner = new
		Scanner(CashRegisterDemo.class.getResourceAsStream("/chips.txt"));
		
		while (chipScanner.hasNext())
		{
			chipsItems.add(new Chips(chipScanner.nextLine()));
		}
		chipScanner.close();
		
		// Scans soda.txt file
		ArrayList<Soda> sodaItems = new ArrayList<>();
		Scanner sodaScanner = new
		Scanner(CashRegisterDemo.class.getResourceAsStream("/soda.txt"));
		
		while (sodaScanner.hasNext()) 
		{
		sodaItems.add(new Soda(sodaScanner.nextLine()));
		}
		sodaScanner.close();
		
		// Scans soap.txt file
		ArrayList<Soap> soapItems = new ArrayList<>();
		Scanner soapScanner = new
		Scanner(CashRegisterDemo.class.getResourceAsStream("/soap.txt"));
		
		while (soapScanner.hasNext())
		{
			soapItems.add(new Soap(soapScanner.nextLine()));
		}
		soapScanner.close();
		
		cerealItemsSet.addAll(cerealItems);
		chipsItemsSet.addAll(chipsItems);
		sodaItemsSet.addAll(sodaItems);
		soapItemsSet.addAll(soapItems);
		
		// Adds items and their price at random
		addItemsAndPrice(cerealItemsSet, lookUp);
		addItemsAndPrice(chipsItemsSet, lookUp);
		addItemsAndPrice(sodaItemsSet, lookUp);
		addItemsAndPrice(soapItemsSet, lookUp);
		
		// Create 3 promotions
		Promotion halloweenPromo = new Promotion("Halloween", 10, LocalDate.of(2024, 10, 31));
		Promotion columbusDayPromo = new Promotion("Columbus", 5, LocalDate.of(2024, 10, 11));
		Promotion thanksgivingPromo = new Promotion("Thanksgiving", 20, LocalDate.of(2024, 11, 28));
		
		// Add chips and soda to first promotion
		halloweenPromo.addAllItems(chipsItems);
		halloweenPromo.addAllItems(sodaItems);
		
		// Add cereal and soap items to second promotion
		columbusDayPromo.addAllItems(cerealItems);
		columbusDayPromo.addAllItems(soapItems);
		
		// Add items to third promotion
		addToThirdPromo(cerealItemsSet, thanksgivingPromo);
		addToThirdPromo(chipsItemsSet, thanksgivingPromo);
		addToThirdPromo(sodaItemsSet, thanksgivingPromo);
		addToThirdPromo(soapItemsSet, thanksgivingPromo);
		
		// Put the 3 promotions in a linked list
		LinkedList<Promotion> promotions = new LinkedList<>();
		
		// Instantiate Active promotion and add all promotions to it
		ActivePromotion activePromotion = new ActivePromotion(promotions);
		activePromotion.add(halloweenPromo);
		activePromotion.add(columbusDayPromo);
		activePromotion.add(thanksgivingPromo);
		System.out.println();
		
		// sets item look up and active promotion for cash register
		CashRegister.setRetailItemLookUp(lookUp);
		CashRegister.setActivePromotions(activePromotion);
		
		CashRegister register = new CashRegister();
		
		register.startTransaction();
		register.scanItem(chipsItems.get(1));
		register.scanItem(new RetailItem("Rap Snacks",RetailItemType.CHIPS));
		register.scanItem(cerealItems.get(2));
		register.printReceipt();
		
		System.out.println();
		register.startTransaction();
		register.scanItem(soapItems.get(1));
		register.scanItem(sodaItems.get(0));
		register.printReceipt();
		System.out.println();
		
		register.startTransaction();
		register.scanItem(chipsItems.get(4));
		register.scanItem(cerealItems.get(3));
		register.scanItem(soapItems.get(2));
		register.scanItem(sodaItems.get(1));
		register.printReceipt();
		activePromotion.removeExpired();
		System.out.println();
		register.startTransaction();
		register.scanItem(chipsItems.get(4));
		register.scanItem(cerealItems.get(3));
		register.scanItem(soapItems.get(2));
		register.scanItem(sodaItems.get(1));
		register.printReceipt();
	}
	
	/**
	 * Private method to add items to the third promotion
	 * @param items array list of items to be added
	 * @param thanksgiving the third promotion
	 */
	private static void addToThirdPromo(Set<? extends RetailItem> items, Promotion thanksgiving)
	{
		List<? extends RetailItem> itemsList = new ArrayList<>(items); 
		for (int i = 0; i < itemsList.size(); i++)
		{
			if (i % 2 == 0)
			{
				thanksgiving.addItem(itemsList.get(i));
			}
		}	
	}
	
	/**
	 * Private helper to add items and their price to each type
	 * @param items item to set the price for
	 * @param lookUp
	 * @throws MissingCategoryException exception to be thrown when there is a missing category
	 */
	private static void addItemsAndPrice(Set<? extends RetailItem> items, RetailItemLookUp lookUp) throws MissingCategoryException
	{
		Random rnd = new Random();

		for (RetailItem item : items)
		{
			try
			{
				double price = (rnd.nextInt(300) + 200) / 100.0;
				lookUp.addItemEntry(item, price);
			}
			catch (MissingCategoryException e)
			{
				System.out.println(e);
			}
		}
		System.out.println();
	}
}
