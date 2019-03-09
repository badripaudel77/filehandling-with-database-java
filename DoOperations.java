package com.filehandling_project;

import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoOperations {
    
	java.sql.Statement st = null;
	PreparedStatement pst;
	Connection con =null;
	ResultSet rs;
	String username,address;//creating the variables
	
	Scanner sc = new Scanner(System.in);
	
	String detailsCustomers = "";// to store the database value and concatenate the every details from the database
	private Scanner scN;
//placing this code in constructor so that it is loaded as soon as the object of that class is created
public DoOperations() throws ClassNotFoundException, SQLException {

Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fileHandling","root", "");	

}

//now insert the customers into table of the database
public void createCustomers() throws SQLException {
	
	System.out.println("Enter the customer's details\n Enter username and address");//id is auto increment
	username = sc.nextLine();
	address = sc.nextLine();

	pst= con.prepareStatement("insert into customers(names,address) values(?,?)");

	pst.setString(1, username);
    pst.setString(2,address);
    pst.executeUpdate();
    
    System.out.println("Record successfully stored");
}
 
public void readCustomers()  {
 try {

String readCustomers = "Select * from customers";
 
st = con.createStatement();
 rs =st.executeQuery(readCustomers);
 
 System.out.println("Id\tUsername\t\tAddress\t\n");
 
 while(rs.next()) {

	 detailsCustomers += rs.getInt(1) + " \t" + rs.getString(2) + "\t\t" + rs.getString(3) +"\n";
 
 }
 
 System.out.println(detailsCustomers + "\n----Record Displayed----");
 
 }
 
 catch(Exception e) {
	 System.out.println(e);
 }
	
}

public void updateCustomers() throws SQLException {
	int id;
   String names,address;
   
	System.out.println("Update The Records\n Enter the id to update");
	id = sc.nextInt();
	
	scN = new Scanner(System.in);
	
	System.out.println("Enter the Name to update");
	names = scN.next();
	
	System.out.println("Enter the Name to update");
	address = scN.next();
	
	String updateCustomers = "update customers set names=?, address=? where id="+id;
	
	pst = con.prepareStatement(updateCustomers);
	pst.setString(1, names);
	pst.setString(2,address);
	pst.executeUpdate();
	
	System.out.println("Record successfully updated");
}

   public void deleteCustomers() throws SQLException {
	   
	  System.out.println("Delete the customers-->All the record row associated with that id number "
	   		+ "will be deleted"
	   		+ "\n Enter the Id number to delete");
	   
	   int delId = sc.nextInt();
	   String delQuery = "delete from customers where id=?";
	   pst = con.prepareStatement(delQuery);
       pst.setInt(1, delId);
       pst.executeUpdate();
	   System.out.println("Record successfully Deleted");
	   
   }
  
 public void toTxt() throws IOException, SQLException {
     
	 String readCustomers = "Select * from customers";
	 
	 st = con.createStatement();
	  rs =st.executeQuery(readCustomers);
	  
	  
	  while(rs.next()) {

	 	 detailsCustomers += rs.getInt(1) + " \t" + rs.getString(2) + "\t\t" + rs.getString(3) +"\n";
	  
	  }
	 
	 File fileLoc = new File("e:/test/badri1.txt");
	 FileOutputStream fout = new FileOutputStream(fileLoc);
	 byte []b = detailsCustomers.getBytes();
	 fout.write(b);
	 fout.close();
	 System.out.println("successfully written to the file location mentioned.");
	 System.exit(0);
	  
   }
 
 public void readTextFile() throws IOException {
	 
	 File file = new File("e:/test/badri1.txt");	
	 FileInputStream fin = new FileInputStream(file);
	 
	 int c=0;

	 System.out.println("-----The content of the text file is ----- \n");
	 while((c=fin.read())!=-1)//-1 denotes end of file 
	
	 {
		 System.out.print((char)c); 
	 }
	 
 }
   
   
}
