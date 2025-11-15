package sudoProject;
import java.util.*;
public class MultiplePlayer {
	static String name2;
	static int row,col;
	static char marker;
	static char X='x',O='o';
	Scanner sc = new Scanner(System.in);
	char o,x;
	
	public static void start(Scanner sc,String name) throws Exception  {
		TicTacToe.initializeBoard(name);
		System.out.println("MATCH BEGINS.......");
		
		MultiplePlayer.playerTwoName(sc,name);
	}
	
	public static void playerTwoName(Scanner sc,String name) throws Exception {
		System.out.println("ENTER THE 2ND PLAYER NAME....");
		sc.nextLine();
		name2 = sc.nextLine();
		System.out.println("PROCESSING......... \' PLZ WAIT \'");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("THIS 2ND PLAYER RECORD MAY NOT BE SAVED IN ANY DATABASE ...");
		System.out.println(name2 + " YOUR AN TEMPORARY PLAYER ");
		System.out.println("MAY TAKE FEW SECONDS...................!!!!!!!!!");
		try {
			Thread.sleep(3000);
		}catch(Exception e) {e.printStackTrace();}
		MultiplePlayer.matchStart(name2,name,sc);
	}
	
	public static void matchStart(String name2,String name,Scanner sc) throws Exception {
		System.out.println(name +" SELECT THE MARKER X OR O ");
		marker = sc.next().charAt(0);
		
		if(marker == X) {
			System.out.println(name + " YOUR MARKER IS X ");
			MultiplePlayer.placingRowColX(marker, name, name2,sc);
		}else if(marker == O) {
			System.out.println(name + " YOUR MARKER IS O ");
			MultiplePlayer.placingRowColO(marker, name, name2,sc);
		}else System.err.println("VERIFY YOUR MARKER X OR O");
		
		
	}
	public static void placingRowColX(char marker,String name,String name2,Scanner sc) throws Exception {
	
		if(marker == 'x') {
			System.err.println("PLZ PROVIDE AN CORRECT PLACE TO POINT X OR O \" INCASE YOU PROVIDE IT IN AN WRONG PLACE YOUR TURN WILL LOST \"");
			while(true) {
				System.out.println("YOUR TURN ......" + name);
				row=sc.nextInt();
				col=sc.nextInt();
				if(TicTacToe.placingBoard(row,col,marker,name)) {
					MonitoringGameData.monitorWinHistory();
					break;
				}
				System.out.println("YOUR TURN ......" + name2);
				row=sc.nextInt();
				col=sc.nextInt();
				char c='o';
				if(TicTacToe.placingBoard(row, col,c,name2)){
					MonitoringGameData.monitorlossHistory();
					break;
				}
				
			}
		}else System.err.println(" SOME ISSUE OCCURED ");
	}
	public static void placingRowColO(char marker,String name,String name2,Scanner sc) throws Exception {
						
			System.err.println("PLZ PROVIDE AN CORRECT PLACE TO POINT X OR O \" INCASE YOU PROVIDE IT IN AN WRONG PLACE YOUR TURN WILL LOST \"");
			if(marker == 'o') {
			while(true) {
				
				System.out.println("YOUR TURN ......" + name);
				row=sc.nextInt();
				col=sc.nextInt();
				if(TicTacToe.placingBoard(row,col,marker,name)) {
					MonitoringGameData.monitorWinHistory();
					break;
				}
				System.out.println("YOUR TURN ......" + name2);
				row=sc.nextInt();
				col=sc.nextInt();
				char c='x';
				if(TicTacToe.placingBoard(row, col,c,name2)){
					MonitoringGameData.monitorlossHistory();;
					break;
				}
			}
		}else {System.out.println(" SOME ISSUE OCCURED ");return ;}
	}
	
}
