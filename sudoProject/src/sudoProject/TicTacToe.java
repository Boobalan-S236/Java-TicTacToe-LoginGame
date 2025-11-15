package sudoProject;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
public class TicTacToe {
	
	static char board[][]=new char[3][3];
	
	static Scanner sc = new Scanner(System.in);
	
	public static void initializeBoard(String name) {
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
		displayBoard() ;
	}
	
	public static void displayBoard() {
		
	    System.out.println("-------------");
	    for (int i = 0; i < board.length; i++) {
	        System.out.print("| ");
	        for (int j = 0; j < board[i].length; j++) {
	            System.out.print(board[i][j] + " | ");
	        }
	        System.out.println(); 
	        System.out.println("-------------");
	    }
	  
	}
	
	public static boolean checkColmWin() {
		
		for(int j=0;j<=2;j++) {
			
				if(board[0][j] !=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
					return true;
				}
			
		}
		return false;
	}
	
	public static boolean checkRowWin() {
		
		for(int i=0;i<=2;i++) {
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]  ) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkDiagWin() {
		
		if(board[0][0] != ' ' && board[0][0] == board[1][1] 
			&& board[1][1] == board[2][2] 
			|| board[0][2] != ' ' && board[0][2] == board[1][1] 
			&& board[1][1] == board[2][0]) 
		{
			
			return true;
			
		}
		else { 
			return false;
		}
		
	}
	public static boolean checkDraw() {
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (board[i][j] == ' ') {
	                return false; 
	            }
	        }
	    }
	    return true;
	}

	public static boolean placingBoard(int row,int col,char marker,String name) throws Exception {
		
		if(row <= 2 && col <= 2) {
			
			if(board[row][col] == ' ' ) {
				
				board[row][col]=marker;
				TicTacToe.displayBoard();
				if(TicTacToe.checkColmWin() || TicTacToe.checkDiagWin() || TicTacToe.checkRowWin()) {
					System.out.println(name + " YOU WIN THE MATCH CONGRATULATIONS....... ");
					return true;
				}
				if (TicTacToe.checkDraw()) {
	                System.out.println("MATCH DRAWN! WELL PLAYED BOTH PLAYERS .....");
	                return true;
	            }
		   }else System.err.println("MISS PLACED.....");

		}else System.err.println("MISS PLACED.....");
		
		return false;
	}
	public static void computerMove(String name) {
	    Random rand = new Random();
	    int row, col;
	    while (true) {
	        row = rand.nextInt(3);
	        col = rand.nextInt(3);
	        if (board[row][col] == ' ') {
	            System.out.println("Computer chooses position: " + (row * 3 + col + 1));
	            board[row][col] = 'O';
	            displayBoard();
	            if (checkColmWin() || checkDiagWin() || checkRowWin()) {
	                System.out.println("COMPUTER WINS! TRY AGAIN NEXT TIME...");
	            } else if (checkDraw()) {
	                System.out.println("MATCH DRAWN! WELL PLAYED BOTH...");
	            }
	            break;
	        }
	    }
	}

	
}
