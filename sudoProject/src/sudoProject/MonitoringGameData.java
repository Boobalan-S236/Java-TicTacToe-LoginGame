package sudoProject;

import java.sql.Connection;
import java.sql.Statement;

public class MonitoringGameData{
	
	static String querywin="UPDATE GAMEHISTORY SET gamewon = gamewon + 1, gameplayed = gameplayed + 1;";
	static String queryloss="UPDATE  GAMEHISTORY SET  gameloss =  gameloss + 1, gameplayed = gameplayed + 1;";
	
	static String querydraw="UPDATE  GAMEHISTORY SET  gameplayed =  gameplayed + 1;";

	
	public static void monitorWinHistory() throws Exception {
		Connection con = ConnectionData.ConnectionDemo();
		Statement st = con.createStatement();
		int r=st.executeUpdate(querywin);
		
	}
	public static void monitorlossHistory() throws Exception {
		Connection con = ConnectionData.ConnectionDemo();
		Statement st = con.createStatement();
		int r=st.executeUpdate(queryloss);
		
	}
//	public static void monitorDrawHistory() throws Exception {
//		Connection con = ConnectionData.ConnectionDemo();
//		Statement st = con.createStatement();
//		int r1=st.executeUpdate(querydraw);
//	}
}
