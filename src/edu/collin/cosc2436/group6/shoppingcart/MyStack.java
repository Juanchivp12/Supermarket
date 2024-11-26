package edu.collin.cosc2436.group6.shoppingcart;

/**
 * Interface for the implementation of a stack
 * @param <T> 
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public interface MyStack<T> 
{
	/**
	 * Checks if stack is empty
	 * @return a boolean
	 */
	boolean isEmpty();
	
	/**
	 * Pushes an item to the top of the stack
	 * @param item any item of type T
	 * @return any item of type T that is pushed
	 */
	T push(T item);
	
	/**
	 * Removes the last object of the stack
	 * @return object of type T 
	 */
	T pop();
	
	/**
	 * Looks at the object at the top of the stack without removing it
	 * @return object of type T
	 */
	T peek();
}
