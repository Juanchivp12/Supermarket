package edu.collin.cosc2436.group6.cashregister;

/**
 * This is the Cash Register Demo with the main method in it
 */
public class CashRegisterDemo 
{
	public static void main(String[] args)
	{
		double[] prices = {2.49, 3.25, 1.79, 2.99};
		RetailItemLookUp lookUp = new RetailItemLookUp(.0825, prices);
		
		CashRegister.setRetailItemLookUp(lookUp);
		CashRegister register = new CashRegister();
				
		// Transaction with only groceries
		register.startTransaction();
		register.scanItem(RetailItemType.CHIPS);
		register.scanItem(RetailItemType.CEREAL);
		register.printReceipt();
		
		// Transaction with non-groceries
		register.startTransaction();
		register.scanItem(RetailItemType.SOAP);
		register.scanItem(RetailItemType.SODA);
		register.printReceipt();
		
		// Transaction with all items
		register.startTransaction();
		register.scanItem(RetailItemType.CHIPS);
		register.scanItem(RetailItemType.CEREAL);
		register.scanItem(RetailItemType.SOAP);
		register.scanItem(RetailItemType.SODA);
		register.printReceipt();
	}
}