package edu.collin.cosc2436.group6.shoppingcart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.cashregisterrevisited.Cereal;
import edu.collin.cosc2436.group6.cashregisterrevisited.Chips;
import edu.collin.cosc2436.group6.cashregisterrevisited.DuplicateCategoryException;
import edu.collin.cosc2436.group6.cashregisterrevisited.MissingCategoryException;
import edu.collin.cosc2436.group6.cashregisterrevisited.MissingItemsException;
import edu.collin.cosc2436.group6.cashregisterrevisited.RetailItemLookUp;
import edu.collin.cosc2436.group6.cashregisterrevisited.Soap;
import edu.collin.cosc2436.group6.cashregisterrevisited.Soda;
import edu.collin.cosc2436.group6.shoppinglist.MyLinkedList;
import edu.collin.cosc2436.group6.shoppinglist.MyList;
import edu.collin.cosc2436.group6.shoppinglist.ShoppingListEntry;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.ActivePromotion;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.Promotion;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.RetailItem;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.SmartShelf;

/**
 * This is the demo for a shopping cart
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class ShoppingCartDemo 
{
	public static void main(String[] args) throws MissingItemsException, MissingCategoryException, DuplicateCategoryException
	{
		final String cerealShelfString = "Cereal Shelf";
		final String chipsShelfString = "Chips Shelf";
		final String sodaShelfString = "Soda Shelf";
		final String soapShelfString = "Soap Shelf";
		
		SuperMarket market = new SuperMarket();
		
		Set<Cereal> cerealItemsSet = new HashSet<>();
		Set<Chips> chipsItemsSet = new HashSet<>();
		Set<Soda> sodaItemsSet = new HashSet<>();
		Set<Soap> soapItemsSet = new HashSet<>();
		
		Collection <ShoppingCart> carts = new ArrayList<>();
		for (int i = 1; i <= 10; ++i)
		{
			carts.add(new ShoppingCart(i));
		}
		market.stockCarts(carts);
		
		SmartShelf<Cereal> cerealShelf = new SmartShelf<>(cerealShelfString);
		SmartShelf<Chips> chipsShelf = new SmartShelf<>(chipsShelfString);
		SmartShelf<Soda> sodaShelf = new SmartShelf<>(sodaShelfString);
		SmartShelf<Soap> soapShelf  = new SmartShelf<>(soapShelfString);
		
		market.addShelf(cerealShelf);
		market.addShelf(chipsShelf);
		market.addShelf(sodaShelf);
		market.addShelf(soapShelf);
		
		// Scans cereal.txt file
		ArrayList<Cereal> cerealItems = new ArrayList<>();
		Scanner cerealScanner = new
		Scanner(ShoppingCartDemo.class.getResourceAsStream("/cereal.txt"));
		
		while (cerealScanner.hasNext()) 
		{
		cerealItems.add(new Cereal(cerealScanner.nextLine()));
		}
		cerealScanner.close();
		
		// Scans chips.txt file
		ArrayList<Chips> chipsItems = new ArrayList<>();
		Scanner chipScanner = new
		Scanner(ShoppingCartDemo.class.getResourceAsStream("/chips.txt"));
		
		while (chipScanner.hasNext())
		{
			chipsItems.add(new Chips(chipScanner.nextLine()));
		}
		chipScanner.close();
		
		// Scans soda.txt file
		ArrayList<Soda> sodaItems = new ArrayList<>();
		Scanner sodaScanner = new
		Scanner(ShoppingCartDemo.class.getResourceAsStream("/soda.txt"));
		
		while (sodaScanner.hasNext()) 
		{
		sodaItems.add(new Soda(sodaScanner.nextLine()));
		}
		sodaScanner.close();
		
		// Scans soap.txt file
		ArrayList<Soap> soapItems = new ArrayList<>();
		Scanner soapScanner = new
		Scanner(ShoppingCartDemo.class.getResourceAsStream("/soap.txt"));
		
		while (soapScanner.hasNext())
		{
			soapItems.add(new Soap(soapScanner.nextLine()));
		}
		soapScanner.close();
		
		// Add items to sets
		cerealItemsSet.addAll(cerealItems);
		chipsItemsSet.addAll(chipsItems);
		sodaItemsSet.addAll(sodaItems);
		soapItemsSet.addAll(soapItems);
		
		RetailItemLookUp lookUp = new RetailItemLookUp(.0825);
		lookUp.addPricingCategory(RetailItemType.CEREAL, false);
		lookUp.addPricingCategory(RetailItemType.CHIPS, false);
		lookUp.addPricingCategory(RetailItemType.SODA, true);
		lookUp.addPricingCategory(RetailItemType.SOAP, true);
		
		// Adds items and their price at random
		addItemsAndPrice(cerealItemsSet, lookUp);
		addItemsAndPrice(chipsItemsSet, lookUp);
		addItemsAndPrice(sodaItemsSet, lookUp);
		addItemsAndPrice(soapItemsSet, lookUp);
		
		Promotion thanksgivingPromo = new Promotion("Thanksgiving", 10, LocalDate.of(2024, 11, 28));
		Promotion christmasPromo = new Promotion("Christmas", 15, LocalDate.of(2024, 12, 25));
		Promotion blackFridayPromo = new Promotion("Black Friday", 20, LocalDate.of(2024, 11, 29));
		
		// add thanksgiving promotion to chips and Christmas promotions to soaps
		thanksgivingPromo.addAllItems(chipsItemsSet);
		christmasPromo.addAllItems(soapItemsSet);
		
		// Add Black Friday promotion to even items in all categories 
		addBlackFriday(cerealItemsSet, blackFridayPromo);
		addBlackFriday(chipsItemsSet, blackFridayPromo);
		addBlackFriday(sodaItemsSet, blackFridayPromo);
		addBlackFriday(soapItemsSet, blackFridayPromo);
		
		LinkedList<Promotion> promotions = new LinkedList<>();
		
		ActivePromotion activePromotion = new ActivePromotion(promotions);
		activePromotion.add(thanksgivingPromo);
		activePromotion.add(christmasPromo);
		activePromotion.add(blackFridayPromo);
		System.out.println();
		
		CashRegister.setRetailItemLookUp(lookUp);
		CashRegister.setActivePromotions(activePromotion);
		
		Employee jack = new Employee("Jack");
		jack.putItemsOnShelf(cerealShelf, cerealItems);
		jack.putItemsOnShelf(chipsShelf, chipsItems);
		jack.putItemsOnShelf(sodaShelf, sodaItems);
		jack.putItemsOnShelf(soapShelf, soapItems);
		System.out.println();
		
		Customer john = new Customer("John", market);
		MyList<ShoppingListEntry> johnList = new MyLinkedList<>();
		johnList.addFirst(new ShoppingListEntry("Diet Coke", RetailItemType.SODA, sodaShelfString));
		johnList.addLast(new ShoppingListEntry("Dial", RetailItemType.SOAP, soapShelfString));
		johnList.addLast(new ShoppingListEntry("Funyuns", RetailItemType.CHIPS, chipsShelfString));
		johnList.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, chipsShelfString));
		johnList.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, cerealShelfString));
		
		Customer mary = new Customer("Mary", market);
		MyList<ShoppingListEntry> maryList = new MyLinkedList<>();
		maryList.addFirst(new ShoppingListEntry("Diet Coke", RetailItemType.SODA, sodaShelfString));
		maryList.addLast(new ShoppingListEntry("Olay", RetailItemType.SOAP, soapShelfString));
		maryList.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, chipsShelfString));
		maryList.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, cerealShelfString));
		
		Cashier bertha = new Cashier("Bertha");
		
		john.shop(johnList, market);
		mary.shop(maryList, market);
		
		john.checkOut();
		bertha.handleCheckoutCounter(market.getCounter());
		
		mary.checkOut();
		bertha.handleCheckoutCounter(market.getCounter());
	}
	
	/**
	 * Private helper to add items and their price to each type.
	 * @param items item to set the price for.
	 * @param lookUp
	 * @throws MissingCategoryException exception to be thrown when there is a missing category
	 */
	private static void addItemsAndPrice(Collection<? extends RetailItem> items, RetailItemLookUp lookUp) throws MissingCategoryException
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
	
	/**
	 * Private method to add items to the third promotion
	 * @param items array list of items to be added
	 * @param thanksgiving the third promotion
	 */
	private static void addBlackFriday(Set<? extends RetailItem> items, Promotion blackFriday) 
	{
	    List<? extends RetailItem> itemsList = new ArrayList<>(items); 
	    for (int i = 0; i < itemsList.size(); i++) 
	    {
	        if (i % 2 == 0) 
	        {
	            blackFriday.addItem(itemsList.get(i));
	        }
	    }
	}
}