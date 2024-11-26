package edu.collin.cosc2436.group6.shoppinglist;

/**
 * Interface for the implementation of a linked list
 * @param <T> 
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public interface MyList<T> extends Iterable<T> 
{
	/**
	 * Adds element of type T to the beginning of the list
	 * @param element, the element to be added
	 */
	void addFirst(T element);
	
	/**
	 * Adds element of type T to the end of the list
	 * @param element, the element to be added
	 */
	void addLast(T element);
	
	/**
	 * Removes and returns the last element of the list
	 * @return T, the last element of the list
	 */
	boolean remove(T element);
	
	/**
	 * Checks if list is empty
	 * @return a boolean, true if list is empty, false otherwise
	 */
	boolean isEmpty();
}
