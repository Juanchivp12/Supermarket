package edu.collin.cosc2436.group6.supermarketpromotions_group6;

import java.util.ArrayList;
import java.util.Random;

import edu.collin.cosc2436.group6.cashregister.RetailItemType;
import edu.collin.cosc2436.group6.supermarketshelf_group6.OutOfStockException;

/**
 * This is smart shelf class
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class SmartShelf<T extends RetailItem> implements IShelfCustomer<T>, IShelfEmployee<T>
{
	private final String shelfName;
	private ArrayList<T> items;

	/**
	 * Constructs a smart shelf
	 * @param shelfName the name of the shelf
	 */
	public SmartShelf(String shelfName) 
	{
		this.shelfName = shelfName;
		this.items = new ArrayList<>();
	}
	
	/**
	 * This gets the value of the shelfName field
	 * @return the shelfType 
	 */
	public String getShelfName()
	{
		return shelfName;
	}

	/**
	 * This method places items on the shelf in correct order
	 * @param items an array list of retail items
	 */
	@Override
	public void placeItems(ArrayList<T> items) 
	{
		sort(items);
		this.items.addAll(items);
	}

	/**
	 * This method adds an item at a specific index
	 * @param item a retail item to add
	 */
	@Override
	public void addItem(T item) 
	{
		int position = search(items, item);
		items.add(position, item);
	}

	/**
	 * This method finds an item in the list and returns if it was found, otherwise an exception is thrown
	 * @param item item being searched
	 * @throws OutOfStockException if item is not found in the list
	 */
	@Override
	public T findAndTake(String itemName, RetailItemType type) throws OutOfStockException 
	{ 
		RetailItem item = new RetailItem(itemName, type);
		int position = search(items, item);
		
		if (position >= items.size() || items.get(position).compareTo(item) != 0) // || compare to item (make search take item)
		{
	        throw new OutOfStockException(itemName);
	    }

		T removed = items.remove(position);
		return removed;
	}
	
	/**
	 * This method searches for an item in the list
	 * @param list the sorted array list
	 * @param item item being searched
	 * @return the index of the item being searched
	 */
	public static <T extends RetailItem> int search(ArrayList<T> list, RetailItem item)
	{
		int low = 0;
		int high = list.size() - 1;
		
		while(low <= high)
		{
			int mid = low + (high - low) / 2;
			T midItem = list.get(mid);
			
			if (item.compareTo(midItem) == 0)
			{
				return mid;
			}
			else if (item.compareTo(midItem) > 0)
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
	 * This is the method that is initially called to do quick sort.
	 * It calls the recursive method that does the sorting
	 * @param list the array list of retail items to be sorted
	 */
	public static <T extends RetailItem>void sort(ArrayList<T> list)
	{
		sort(list, 0, list.size() - 1);
	}

	/**
	 * This method recursively sorts the array list
	 * @param list the array list of retail items
	 * @param low the low index of the list
	 * @param high the high index of the list
	 */
	private static <T extends RetailItem> void sort(ArrayList<T> list, int low, int high) 
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
	private static <T extends RetailItem> int partition(ArrayList<T> list, int low, int high) 
	{
		Random rnd = new Random();
		int idx = rnd.nextInt(low, high + 1);
		
		swap(list, idx, low);
		T pivot = list.get(low);
		
		int leftPointer = low + 1;
		int rightPointer = high;
		
		while (leftPointer <= rightPointer)
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
	
	/**
	 * Swaps two elements of an array list
	 * @param list the array list whose elements are swapped
	 * @param pos1 the position of the first element to swap
	 * @param pos2 the position of the second element to swap
	 */
	protected static <T> void swap(ArrayList<T> list, int pos1, int pos2)
	{
		T temp = list.get(pos1);
		list.set(pos1, list.get(pos2));
		list.set(pos2, temp);
	}

	/**
	 * This is an overridden toString method to print the contents of the array list
	 */
	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder('\n' + getShelfName() + ":\n");
		
		
		for (T item : items)
		{
			builder.append('\t').append(item).append("\n");
		}
		
		return builder.toString();
	}
}
