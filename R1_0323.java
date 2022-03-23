package Prac0323;

import java.util.Scanner;

public class R1_0323 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		vedicMathematics(N, M);
	}

	static void vedicMathematics(int N, int M) {
		int a = (100 - N) + (100 - M);
		int b = (100 - N) * (100 - M);
		int c = 100 - a;
		System.out.println("¢º " + N + " X " + M + " = " + (N * M) + "\n");
		System.out.println("100-" + N + "\t\t" + "100-" + M);
		System.out.println("  " + (100 - N) + "       +       " + (100 - M));
		System.out.println("  " + (100 - N) + "       X       " + (100 - M) +"\n");
		System.out.println("First two digits : 100 - " + a + " = " + (100 - a));
		System.out.println("Last two digits : " + b);
		System.out.println("Result : " + (c * 100 + b));
	}
}