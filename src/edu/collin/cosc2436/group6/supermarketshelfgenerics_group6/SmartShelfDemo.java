package edu.collin.cosc2436.group6.supermarketshelfgenerics_group6;

import java.util.ArrayList;
import java.util.Scanner;

import edu.collin.cosc2436.group6.supermarketshelf_group6.OutOfStockException;

/**
 * This is a demo for the smart shelf
 */
public class SmartShelfDemo 
{
	public static void main(String[] args) throws OutOfStockException
	{
		SmartShelf<Cereal> cerealShelf = new SmartShelf<>("Cereal Shelf");
		SmartShelf<Chips> chipShelf = new SmartShelf<>("Chips Shelf");
		
		Customer john = new Customer("John");
		Customer mary = new Customer("Mary");
		Employee jack = new Employee("Jack");
		
		// Scans cereal.txt file
		ArrayList<Cereal> cerealItems = new ArrayList<>();
		Scanner cerealScanner = new
		Scanner(SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		
		while (cerealScanner.hasNext()) 
		{
		cerealItems.add(new Cereal(cerealScanner.nextLine()));
		}
		cerealScanner.close();
		
		// Scans chips.txt file
		ArrayList<Chips> chipsItems = new ArrayList<>();
		Scanner chipScanner = new
		Scanner(SmartShelfDemo.class.getResourceAsStream("/chips.txt"));
		
		while (chipScanner.hasNext())
		{
			chipsItems.add(new Chips(chipScanner.nextLine()));
		}
		chipScanner.close();
		
		jack.putItemsOnShelf(cerealShelf, cerealItems);
		System.out.println(cerealShelf);
		
		jack.putItemsOnShelf(chipShelf, chipsItems);
		System.out.println(chipShelf);
		
		mary.takeItemFromShelf(cerealShelf, "Apple Jacks");
		mary.takeItemFromShelf(cerealShelf, "Cinnamon Toast Crunch");
		mary.takeItemFromShelf(cerealShelf, "Cinnamon Toast Crunch");
		System.out.println(cerealShelf);
		
		john.takeItemFromShelf(chipShelf, "Lays");
		john.takeItemFromShelf(chipShelf, "Bugles");
		System.out.println(chipShelf);
		
		jack.addItemToShelf(cerealShelf, new Cereal("Cinnamon Toast Crunch"));
		jack.addItemToShelf(cerealShelf, new Cereal("Lucky Charms"));
		System.out.println(cerealShelf);
		
		jack.addItemToShelf(chipShelf, new Chips("Ruffles"));
		jack.addItemToShelf(chipShelf, new Chips("Bugles"));
		System.out.println(chipShelf);
		
		
		
	}
}
