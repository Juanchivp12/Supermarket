package edu.collin.cosc2436.group6.supermarketshelf_group6;

import java.util.ArrayList;

/**
 * This is a swapper class to be used to swap elements in the array list
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class Swapper 
{
	/**
	 * Swaps two elements of an array list
	 * @param list the array list whose elements are swapped
	 * @param pos1 the position of the first element to swap
	 * @param pos2 the position of the second element to swap
	 */
	protected static void swap(ArrayList<RetailItem> list, int pos1, int pos2)
	{
		RetailItem temp = list.get(pos1);
		list.set(pos1, list.get(pos2));
		list.set(pos2, temp);
	}
}

