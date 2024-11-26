package edu.collin.cosc2436.group6.supermarketshelf_group6;

/**
 * This is an interface for a customer
 * @author Juan Villegas, Brian Ayo, Luke Brieden, COSC 2436/ Section 004/ 2024 Fall Semester
 */
public interface IShelfCustomer 
{
	RetailItem findAndTake(RetailItem item) throws OutOfStockException;
}
