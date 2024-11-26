package edu.collin.cosc2436.group6.supermarketshelf_group6;

import java.util.ArrayList;

/**
 * This is a modified binary search to instead find where to insert an item
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Binary 
{
	/**
	 * This method inserts an item into the sorted list, keeping it sorted
	 * @param list the sorted array list
	 * @param item item to be added
	 * @return index where item was inserted
	 */
	public static int insert(ArrayList<RetailItem> list, RetailItem newItem)
	{
		int low = 0;
		int high = list.size() - 1;
		
		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			RetailItem midItem = list.get(mid);
			
			if (midItem.compareTo(newItem) < 0)
			{
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}
		}
		return low;
			
	}
	
	/**
	 * This method searches for an item in the list
	 * @param list the sorted array list
	 * @param item item being searched
	 * @return the index of the item being searched, if not found, it returns -1
	 */
	public static int search(ArrayList<RetailItem> list, RetailItem item)
	{
		int low = 0;
		int high = list.size() - 1;
		int ret = -1;
		
		while(low <= high)
		{
			int mid = low + (high - low) / 2;
			RetailItem midItem = list.get(mid);
			
			if (midItem.compareTo(item) == 0)
			{
				ret = mid;
				break;
			}
			else if (midItem.compareTo(item) < 0)
			{
				low = mid + 1;
			}
			else 
			{
				high = mid - 1;
			}
		}
		return ret;
	}
}
					
