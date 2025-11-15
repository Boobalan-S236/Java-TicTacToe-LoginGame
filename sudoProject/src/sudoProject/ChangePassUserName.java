package sudoProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ChangePassUserName {
	
	private static String n,p;
	private static String query="update gamelogin set name = ?";
	private static String query2="update gamelogin set password = ?";

	
	public static void changeUserName(Scanner sc) throws Exception {
		
		System.out.println("TO CHANGE THE USER NAME \n ENTER A NEW ONE...");
		n=sc.nextLine();
		Connection con=ConnectionData.ConnectionDemo();
		PreparedStatement pst =con.prepareStatement(query);
		pst.setString(1, n);
		pst.executeUpdate();
		System.out.println("USER NAME WHERE CHANGED SUUCCESSFULLY"+ "\n" +"-------------------------------------------------------");
	
	}
	
	public static void changeUserPass(Scanner sc) throws Exception{
		
		System.out.println("TO CHANGE THE USER PASSWORD \n ENTER A NEW ONE...");
		p=sc.nextLine();
		Connection con=ConnectionData.ConnectionDemo();
		PreparedStatement pst =con.prepareStatement(query2);
		pst.setString(1,p);
		pst.executeUpdate();
		System.out.println("USER PASSWORD WHERE CHANGED SUUCCESSFULLY"+ "\n" +"-------------------------------------------------------");
		
		
	}
	
}
