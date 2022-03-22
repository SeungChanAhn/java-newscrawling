package Prac0322;

import java.util.Scanner;

public class R1 {

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String first = scanner.nextLine();
			String second = scanner.nextLine();
			String third = scanner.nextLine();
			
			// 한 행이 0000이거나, 열이 000 이면 Pass, 아니면 Fail. ASCII코드 48은 0이다.
			if (first == "0000" && second == "0000" && third == "0000") {
				System.out.println("Pass");
			} else if (first.charAt(0) == 48 && second.charAt(0) == 48 && third.charAt(0) == 48) {
				System.out.println("Pass");
			} else if (first.charAt(1) == 48 && second.charAt(1) == 48 && third.charAt(1) == 48) {
				System.out.println("Pass");
			} else if (first.charAt(2) == 48 && second.charAt(2) == 48 && third.charAt(2) == 48) {
				System.out.println("Pass");
			} else if (first.charAt(3) == 48 && second.charAt(3) == 48 && third.charAt(3) == 48) {
				System.out.println("Pass");	
			} else {
				System.out.println("Fail");
			}
		}
	}
}