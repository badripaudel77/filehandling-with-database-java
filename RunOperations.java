package com.filehandling_project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class RunOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException 
	
	{	//creating the object to call the methods 
	    DoOperations doOp = new DoOperations();
	    
	    //displaying the menu
		System.out.println("Select one of the folloowing Options to proceed : ");
		System.out.println(" 1.Create Customers\n"
				+ " 2.Read Customers \n"
				+ " 3.Update Customers \n"
				+ " 4.Delete Customers\n 5.Export File ");
	    //asking for the choice
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
	    
	    
	    switch (choice) {
		
	    case 1:
	           doOp.createCustomers();//call the createCustomer() method if 1 is chosen        
			break;
	    case 2:
	           doOp.readCustomers();  //call the readCustomer() method if 1 is chosen     
			break;
	    case 3:
	           doOp.updateCustomers(); //call the updateCustomer() method if 1 is chosen      
			break;
	    case 4:
	           doOp.deleteCustomers(); //call the deleteCustomer() method if 1 is chosen    
			break;
	    case 5:
	    	System.out.println("Enter the format to export\n 1.txt file\n2read .txt file");//what the user want to read or write
	      int formatChoice = scanner.nextInt();
	    	switch(formatChoice) {
	    	
	    	case 1:
	    		doOp.toTxt();//call the toText() method if 1 is chosen to write to the text
	    		break;
	    	case 2:
	    		doOp.readTextFile();//call the readTextFile() method if 2 is chosen to read from the text file saved
	    		break;
	    		
	    	default :
	    		System.out.println("Invalid format");
	    		break;
	    		
	    	}
		}
	}

}
