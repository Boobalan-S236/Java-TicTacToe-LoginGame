package sudoProject;

import java.util.Scanner;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GameProfile {
		
	String query = "SELECT * FROM GAMEHISTORY; ";
	
	public void gameProfile(String name,Scanner sc,GameProfile gp) throws Exception{
		System.out.println();
		System.out.println("ENTER YOUR CHOICE : \n 1 - GAME_HISTORY \n 2 - CREDITS \n 3 - SINGLE_PLAYER  \n 4 -  MULTIPLE PLAYER ");
		int option = sc.nextInt();
		
		switch(option) {
			case 1:
				gp.gameHistory();
				break;
			case 2:
				gp.gameDeveloperDetails();
				break;
//			case 3:
//				gp.gameLevel();
//				break;
//			case 4:
//				gp.gameRank();
//				break;
			case 3:
				SinglePlayer.start(sc,name);
				break;
			case 4:
				MultiplePlayer.start(sc,name);
		}
	}
	
	public void gameHistory() throws Exception {
		
		Connection con = ConnectionData.ConnectionDemo();
		Statement s=con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("GAME PLAYED = " + rs.getInt(1));
			System.out.println("GAME WON = " + rs.getInt(2));
			System.out.println("GAME LOSS = " + rs.getInt(3));
		}
	}
	
	public void gameDeveloperDetails() {
		
		System.out.println("THIS GAME IS DEVELOPED BY \"BOOBALAN.S\"");
		
	}
	
	public void gameLevel() {
		
	}
	public void gameRank() {
		
	}
}
