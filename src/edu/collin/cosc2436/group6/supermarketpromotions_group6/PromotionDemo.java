package edu.collin.cosc2436.group6.supermarketpromotions_group6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;

/**
 * This is a demo for promotion
 */
public class PromotionDemo 
{
	public static void main(String[] args)
	{
		// Scans cereal.txt file
		ArrayList<Cereal> cerealItems = new ArrayList<>();
		Scanner cerealScanner = new
		Scanner(PromotionDemo.class.getResourceAsStream("/cereal.txt"));
		
		while (cerealScanner.hasNext()) 
		{
		cerealItems.add(new Cereal(cerealScanner.nextLine(), RetailItemType.CEREAL));
		}
		cerealScanner.close();
		
		// Scans chips.txt file
		ArrayList<Chips> chipsItems = new ArrayList<>();
		Scanner chipScanner = new
		Scanner(PromotionDemo.class.getResourceAsStream("/chips.txt"));
		
		while (chipScanner.hasNext())
		{
			chipsItems.add(new Chips(chipScanner.nextLine(), RetailItemType.CHIPS));
		}
		chipScanner.close();
		

		Promotion thanksgivingPromo = new Promotion("Thanksgiving", 20, LocalDate.of(2024, 11, 28));
		Promotion columbusDayPromo = new Promotion("Columbus", 5, LocalDate.of(2024, 10, 11));
		Promotion halloweenPromo = new Promotion("Halloween", 10, LocalDate.of(2024, 10, 31));
		
		halloweenPromo.addAllItems(chipsItems);
		columbusDayPromo.addAllItems(cerealItems);
		
		for (int i = 0; i < chipsItems.size(); i++)
		{
			if (i % 2 == 0)
			{
				thanksgivingPromo.addItem(chipsItems.get(i));
			}
		}
		
		for (int i = 0; i < cerealItems.size(); i++)
		{
			if (i % 2 == 0)
			{
				thanksgivingPromo.addItem(cerealItems.get(i));
			}
		}
		
		LinkedList<Promotion> promotions = new LinkedList<>();
		promotions.add(thanksgivingPromo);
		promotions.add(columbusDayPromo);
		promotions.add(halloweenPromo);
		
		ActivePromotion activePromotion = new ActivePromotion(promotions);
		
		printBestPromos(cerealItems, activePromotion, "Cereal");
		printBestPromos(chipsItems, activePromotion, "Chips");
		
		activePromotion.removeExpired();
		
		printBestPromos(cerealItems, activePromotion, "Cereal");
		printBestPromos(chipsItems, activePromotion, "Chips");
		
		activePromotion.remove("Thanksgiving");
		
		printBestPromos(cerealItems, activePromotion, "Cereal");
		printBestPromos(chipsItems, activePromotion, "Chips");
		
	}
	
	/**
	 * Prints the best promotion for each item in the arrayList
	 * @param <T> generic method
	 * @param items arrayList of items
	 * @param activePromo ActivePromotion object to help find best promotion
	 */
	private static <T extends RetailItem> void printBestPromos(ArrayList<T> items, ActivePromotion activePromo, String type)
	{
		System.out.println(type + ":");
		for (T item : items)
		{
			Promotion bestPromotion = activePromo.findBestPromotion(item);
			if (bestPromotion != null)
			{
				System.out.printf("%-25s %-15s Expires: %-15s %2d%% %n",
				item.getName(),
				bestPromotion.getName(),
				bestPromotion.getLocalDate(),
				bestPromotion.getDiscountPercentage());
			}
			else 
			{
				System.out.printf("%-25s %-15s %n", item.getName(), "No active promo");
			}
		}
		System.out.println();
	}
}
