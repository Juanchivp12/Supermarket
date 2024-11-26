package edu.collin.cosc2436.group6.supermarketshelf_group6;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is a quick sort implementation using two pointers
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class QuickSort extends Swapper
{
	/**
	 * This is the method that is initially called to do quick sort.
	 * It calls the recursive method that does the sorting
	 * @param list the array list of retail items to be sorted
	 */
	public static void sort(ArrayList<RetailItem> list)
	{
		sort(list, 0, list.size() - 1);
	}

	/**
	 * This method recursively sorts the array list
	 * @param list the array list of retail items
	 * @param low the low index of the list
	 * @param high the high index of the list
	 */
	private static void sort(ArrayList<RetailItem> list, int low, int high) 
	{
		if (low < high)	
		{
			int pos = partition(list, low, high);
			sort(list, low, pos - 1);
			sort(list, pos + 1, high);
		}
	}

	/**
	 * This method partitions the list 
	 * @param list the array list of retail items
	 * @param low the low index
	 * @param high the high index
	 * @return the final position of the pivot
	 */
	private static int partition(ArrayList<RetailItem> list, int low, int high) 
	{
		Random rnd = new Random();
		int idx = rnd.nextInt(low, high + 1);
		
		swap(list, idx, low);
		RetailItem pivot = list.get(low);
		
		int leftPointer = low + 1;
		int rightPointer = high;
		
		while (leftPointer < rightPointer)
		{
			while (leftPointer <= rightPointer && 
					list.get(leftPointer).compareTo(pivot) <= 0)
			{
				leftPointer++;
			}
			while (leftPointer <= rightPointer &&
					list.get(rightPointer).compareTo(pivot) > 0)
			{
				rightPointer--;
			}
			if (leftPointer < rightPointer)
			{
				swap(list, leftPointer, rightPointer);
				leftPointer++;
				rightPointer--;
			}
		}
		swap(list, low, rightPointer);
		return rightPointer;
	}
}
