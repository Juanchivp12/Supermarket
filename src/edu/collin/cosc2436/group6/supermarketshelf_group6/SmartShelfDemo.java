package edu.collin.cosc2436.group6.supermarketshelf_group6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a demo for the smart shelf
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class SmartShelfDemo 
{
	public static void main(String[] args)
	{
		SmartShelf smartShelf = new SmartShelf("cereal");
		Employee employee = new Employee("Jack");
		Customer customer = new Customer();
		ArrayList<RetailItem> cerealItems = new ArrayList<>();
		Scanner scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		
		while (scanner.hasNext()) 
		{
		cerealItems.add(new RetailItem(scanner.nextLine()));
		}
		scanner.close();
		
		System.out.println("----------Employee placing on the shelf:");
		
		for (RetailItem item : cerealItems)
		{
			System.out.println(item);
		}
		
		employee.putItemsOnShelf(smartShelf, cerealItems);
		System.out.println("\n----------Placed on the shelf:");
		System.out.println(smartShelf);
		
		try 
		{
			System.out.println("----------Customer getting Apple Jacks");
			RetailItem itemToTake = new RetailItem("Apple Jacks");
			RetailItem itemTaken = customer.takeItemFromShelf(smartShelf, itemToTake);
			System.out.println("----------Got " + itemTaken);
			
			System.out.println("----------Customer getting Cinnamon Toast Crunch");
			itemToTake = new RetailItem("Cinnamon Toast Crunch");
			itemTaken = customer.takeItemFromShelf(smartShelf, itemToTake);
			System.out.println("----------Got " + itemTaken);
			
			System.out.println("----------Customer getting Cinnamon Toast Crunch");
			itemToTake = new RetailItem("Cinnamon Toast Crunch");
			itemTaken = customer.takeItemFromShelf(smartShelf, itemTaken);
			
		} 
		catch (OutOfStockException e) 
		{
			System.out.println(e);
		} 
		
		System.out.println(smartShelf);
			
		System.out.println("----------Employee adding Cinnamon Toast Crunch");
		System.out.println("----------Employee adding Lucky Charms");
		RetailItem itemToAdd = new RetailItem("Lucky Charms");
		employee.addItemToShelf(smartShelf, itemToAdd);
		System.out.println(smartShelf);
	}
}
