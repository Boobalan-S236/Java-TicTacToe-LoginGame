package sudoProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserLoginGame {
	
	GameProfile gp = new GameProfile();
	
	private static String name;
	private static String pass;
	private final String sup="sign up";
	private final String sin="sign in";
	private String userchoicelogin;
	
	private final String query1="insert into gamelogin values(?,?);";
	
	
	
	public void login(Scanner sc,UserLoginGame ulg) throws Exception{
		
		System.out.println("WELCOME TO XOX GAME........");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("IF YOU ALREADY HAD AN ACCOUNT DO \" SIGN IN \" IF YOU DONT HAVE DO SIGN UP");
		userchoicelogin=sc.nextLine();
		if(userchoicelogin.equalsIgnoreCase(sup)) {
			ulg.signUp(sc,gp);
		}
		else if(userchoicelogin.equalsIgnoreCase(sin)) ulg.signIn(sc,gp); 
		
		else System.err.println("ERROR OCUURED IN TYPING MISTAKE.....");

	}
	
	public void signUp(Scanner sc,GameProfile gp) throws Exception {
		System.out.println("ENTER NAME :");
		name = sc.nextLine();
		System.out.println("PASSWORD :");
		pass=sc.nextLine();
		Connection con = ConnectionData.ConnectionDemo();
		PreparedStatement ps =con.prepareStatement(query1);
		ps.setString(1, name);
		ps.setString(2, pass);
		int r=ps.executeUpdate();
		System.out.println("LOADING................!!!!!!!!!"+"\n");
		Thread.sleep(4000);
		System.out.println("LOGGIN SUCCESSFULL ........ welcome " + name );
		Thread.sleep(2000);
		gp.gameProfile(name,sc,gp);
		
	}
	public static void signIn(Scanner sc,GameProfile gp) throws Exception {
		
		    System.out.println("ENTER THE USERNAME IF YOU FORGET THE USER NAME GIVE AS \"YES OR NO\": ");
		    String signinname = sc.nextLine();
		    
		    if(signinname.equalsIgnoreCase("yes")) {
		    	ChangePassUserName.changeUserName(sc);
		    }else if(signinname.equalsIgnoreCase("no")) {
		    	UserLoginGame.checkNamePass(sc,gp);
		    	return ;
		    }else {System.err.println("FOLLOW THE INSTRUCTION PROPERLLY"); return ;}
		    
		    System.out.println("ENTER THE PASSWORD IF YOU FORGET THE USER password GIVE AS \"YES OR NO\": ");
		    String signinpass = sc.nextLine();
		    
		    if(signinpass.equalsIgnoreCase("yes")) {
		    	ChangePassUserName.changeUserPass(sc);
		    }else if(signinpass.equalsIgnoreCase("no")) {
		    	UserLoginGame.checkNamePass(sc,gp);
		    	return;
		    }else {System.err.println("FOLLOW THE INSTRUCTION PROPERLLY"); return ;}

	}
	public static void checkNamePass(Scanner sc,GameProfile gp) throws Exception {
		Connection con=ConnectionData.ConnectionDemo();
		String query="select * from gamelogin ";
		String dname,dpass;
		System.out.println("ENTER NAME :");
		String name=sc.nextLine();
		System.out.println("ENTER PASSWORD :");
		String pass=sc.nextLine();
		
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(query);
		
		while(rs.next()) {
			
			dname=rs.getString(1);
			dpass=rs.getString(2);
			
			if(dname.equals(null) || dpass.equals(null)) {System.err.println(" THERE IS NO ACCOUNT ");}
			if(name.equals(dname) && pass.equals(dpass)) {
				System.out.println("LOGGIN SUCCESSFULL ........ welcome " + name );
				Thread.sleep(2000);
				gp.gameProfile(name,sc,gp);
			}
			else {
				System.err.println("USERNAME OR PASSWORD IN VALID");
			}
			
		}
	}
}
