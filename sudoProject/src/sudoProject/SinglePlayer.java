package sudoProject;

import java.util.Scanner;

public class SinglePlayer {
	
	public static void start(Scanner sc,String name) throws Exception {

		    TicTacToe.initializeBoard(name);

		    boolean gameEnd = false;
		    while (!gameEnd) {
		       
		        System.out.print("Enter row (0-2): ");
		        int row = sc.nextInt();
		        System.out.print("Enter col (0-2): ");
		        int col = sc.nextInt();
		        gameEnd = TicTacToe.placingBoard(row, col, 'X', name);
		        if (gameEnd) break;

		        TicTacToe.computerMove(name);
		        if (TicTacToe.checkColmWin() || TicTacToe.checkDiagWin() || TicTacToe.checkRowWin() || TicTacToe.checkDraw()) {		        	
		        		gameEnd = true;
		        }
		       
		    }

	}
}
