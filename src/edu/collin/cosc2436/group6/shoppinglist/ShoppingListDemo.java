package edu.collin.cosc2436.group6.shoppinglist;

import java.util.ArrayList;
import java.util.Scanner;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.cashregisterrevisited.CashRegisterDemo;
import edu.collin.cosc2436.group6.cashregisterrevisited.Cereal;
import edu.collin.cosc2436.group6.cashregisterrevisited.Chips;
import edu.collin.cosc2436.group6.cashregisterrevisited.Soap;
import edu.collin.cosc2436.group6.cashregisterrevisited.Soda;
import edu.collin.cosc2436.group6.supermarketpromotions_group6.SmartShelf;

/**
 * Demo For a Shopping List
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class ShoppingListDemo 
{

	public static void main(String[] args) 
	{
		final String cerealShelfString = "Cereal Shelf";
		final String chipsShelfString = "Chips Shelf";
		final String sodaShelfString = "Soda Shelf";
		final String soapShelfString = "Soap Shelf";
		
		SuperMarket market = new SuperMarket();
		
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
		
		Employee mike = new Employee("Mike");
		mike.putItemsOnShelf(cerealShelf, cerealItems);
		mike.putItemsOnShelf(chipsShelf, chipsItems);
		mike.putItemsOnShelf(sodaShelf, sodaItems);
		mike.putItemsOnShelf(soapShelf, soapItems);
		
		Customer john = new Customer("John");
		MyList<ShoppingListEntry> johnList = new MyLinkedList<>();
		johnList.addFirst(new ShoppingListEntry("Coca-Cola", RetailItemType.SODA, sodaShelfString));
		johnList.addLast(new ShoppingListEntry("Dial", RetailItemType.SOAP, soapShelfString));
		johnList.addLast(new ShoppingListEntry("Fritos", RetailItemType.CHIPS, chipsShelfString));
		johnList.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, chipsShelfString));
		johnList.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, cerealShelfString));
		john.shop(johnList, market);
		
		Customer mary = new Customer("Mary");
		MyList<ShoppingListEntry> maryList = new MyLinkedList<>();
		maryList.addFirst(new ShoppingListEntry("Coca-Cola", RetailItemType.SODA, sodaShelfString));
		maryList.addLast(new ShoppingListEntry("Neutrogena", RetailItemType.SOAP, soapShelfString));
		maryList.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, chipsShelfString));
		maryList.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, cerealShelfString));
		mary.shop(maryList, market);
		
		Customer jarJar = new Customer("Jar Jar Binks");
		MyList<ShoppingListEntry> jarJarList = new MyLinkedList<>();
		jarJarList.addFirst(new ShoppingListEntry("Cheetos", RetailItemType.CHIPS, sodaShelfString));
		jarJarList.addLast(new ShoppingListEntry("Red Bull", RetailItemType.SODA, soapShelfString));
		jarJarList.addLast(new ShoppingListEntry("Coke Zero", RetailItemType.SODA, chipsShelfString));
		jarJarList.addLast(new ShoppingListEntry("Ivory", RetailItemType.SOAP, cerealShelfString));
		jarJar.shop(jarJarList, market);
	}
}
