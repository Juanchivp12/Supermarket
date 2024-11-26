package edu.collin.cosc2436.group6.supermarketpromotions_group6;

import java.util.ArrayList;

/**
 * This is an interface for an employee
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public interface IShelfEmployee<T> extends IShelf
{
	/**
	 * This method will place items in an array list of T items
	 * @param items the array list
	 */
	void placeItems(ArrayList<T> items);
	
	/**
	 * This method will add one item to the list
	 * @param item item to be added
	 */
	void addItem(T item);
}
