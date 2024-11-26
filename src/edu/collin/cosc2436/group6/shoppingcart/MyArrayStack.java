package edu.collin.cosc2436.group6.shoppingcart;

import java.util.EmptyStackException;

/**
 * Implementation of a stack
 * @param <T> 
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class MyArrayStack<T> implements MyStack<T> 
{
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	private static final int DEFAULT_INCREMENT = 10;
	
	private Object[] arr;
	private int top;
	private final int increment;

	/**
	 * Constructs an array stack with no arguments by calling the other constructor 
	 * and sending it the default initial capacity and increment
	 * 
	 */
	public MyArrayStack()
	{
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_INCREMENT);
	}
	
	/**
	 * Constructs an array stack
	 * @param initialCapacity the initial capacity the stack will take 
	 * @param increment the increment value
	 */
	public MyArrayStack(int initialCapacity, int increment) 
	{
		if (initialCapacity <= 0)
		{
			throw new IllegalArgumentException("Cannot create a stack with non-positive capacity");
		}
		if (increment <= 0)
		{
			throw new IllegalArgumentException("Cannot create a stack with non-positive increment");
		}
		arr = new Object[initialCapacity];
		this.increment = increment;
		top = 0;
	}

	/**
	 * Checks if stack is empty
	 * @return a boolean
	 */
	@Override
	public boolean isEmpty() 
	{
		return top == 0;
	}
	
	/**
	 * Pushes an item to the top of the stack
	 * @param item any item of type T
	 * @return any item of type T that is pushed
	 */
	@Override
	public T push(T item) 
	{
		growIfNeeded();
		arr[top++] = item;
		return item;
	}
	
	/**
	 * Looks at the object at the top of the stack without removing it
	 * @return object of type T
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T peek() 
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		return (T)arr[top -1];
	}

	/**
	 * Removes the last object of the stack
	 * @return object of type T 
	 */
	@Override
	public T pop() 
	{
		T item = peek();
		arr[--top] = null;
		return item;
		
	}

	
	
	private void growIfNeeded()
	{
		if (top == arr.length)
		{
			Object[] newArr = new Object[arr.length + increment];

			for (int i = 0; i < arr.length; ++i)
			{
				newArr[i] = arr[i];
			}
			arr = newArr; // pointing arr to the newArr
		}

	}

}
