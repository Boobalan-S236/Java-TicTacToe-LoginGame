package sudoProject;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception  {
		Scanner scanner = new Scanner(System.in);
		UserLoginGame ulg = new UserLoginGame();
		ulg.login(scanner,ulg);
	
	}

}
