package edu.collin.cosc2436.group6.shoppinglist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for My linked List implementation
 * @param <T> 
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public class MyLinkedList<T> implements MyList<T>
{
	private Node<T> first = null;
	private Node<T> last = null;
	private int size = 0;
	
	/**
	 * This method returns an Iterator of type T
	 * @return Iterator<T>
	 */
	@Override
	public Iterator<T> iterator() 
	{
		return new MyIterator();
	}
	
	/**
	 * Adds element of type T to the beginning of the list
	 * @param element, the element to be added
	 */
	@Override
	public void addFirst(T element) 
	{
		Node<T> node = new Node<T>(element, first);
		first = node;
		
		if (last == null)
		{
			last = node;
		}
		++size;	
	}

	/**
	 * Adds element of type T to the end of the list
	 * @param element, the element to be added
	 */
	@Override
	public void addLast(T element) 
	{
		Node<T> node = new Node<T>(element); 
		
		if (last != null)
		{
			last.setNext(node);
		}
		
		last = node;
		
		if (first == null)
		{
			first = node;
		}
		++size;
	}

	/**
	 * Removes and returns the last element of the list
	 * @return T, the last element of the list
	 */
	@Override
	public boolean remove(T element) 
	{
		Iterator<T> iter = iterator();
		
		while (iter.hasNext())
		{
			if (iter.next().equals(element))
			{
				iter.remove();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if list is empty
	 * @return a boolean, true if list is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}
	
	/**
	 * Inner class that makes an Iterator
	 */
	public class MyIterator implements Iterator<T>
	{
		private Node<T> currentNode;
		private Node<T> previousNode;
		private boolean canRemove;
		
		/**
		 * Constructs an iterator
		 */
		public MyIterator()
		{
			Node<T> fakeNode = new Node<T>(null, first);
			currentNode = fakeNode;
			previousNode = fakeNode;
			canRemove = false;
		}

		/**
		 * Checks if list has a next element
		 * @returns boolean
		 */
		@Override
		public boolean hasNext() 
		{
			return currentNode.getNext() != null;
		}

		/**
		 * Gets the next element of the list
		 * @return <T> 
		 */
		@Override
		public T next() 
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			canRemove = true;
			return currentNode.getValue();
		}
		
		@Override
		public void remove()
		{
			if (!canRemove)
			{
				throw new IllegalStateException();
			}
			if (currentNode == first)
			{
				first = first.getNext();
			}
			
			if (currentNode == last)
			{
				if (first == null)
				{
					last = null;
				}
				else 
				{
					last = previousNode;
				}
			}
			previousNode.setNext(currentNode.getNext());
			currentNode = previousNode;
			canRemove = false;
			--size;
		}
	}
	/**
	 * Inner static class for Node
	 */
	private static class Node<V>
	{
		private final V value;
		private Node<V> next;
		
		/**
		 * Constructs a Node with a value and next reference set to null
		 * @param value the value given
		 */
		private Node(V value)
		{
			this(value, null);
		}
		
		/**
		 * Constructs a Node with a value and a next reference
		 * @param value
		 * @param next
		 */
		private Node(V value, Node<V> next)
		{
			this.value = value;
			this.next = next;
		}

		/**
		 * Gets the next reference
		 * @return the next Node 
		 */
		protected Node<V> getNext() {
			return next;
		}

		/**
		 * Sets the next reference
		 * @param next
		 */
		protected void setNext(Node<V> next) 
		{
			this.next = next;
		}

		/**
		 * Gets the value of the Node
		 * @return the value
		 */
		protected V getValue() 
		{
			return value;
		}	
	}
}
