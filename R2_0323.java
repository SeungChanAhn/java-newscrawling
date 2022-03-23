package Prac0323;

import java.util.Scanner;

public class R2_0323 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		String M = sc.nextLine();
		vedicMathematics(N, M);
	}

	static void vedicMathematics(String N, String M) {
		int n = Integer.parseInt(N);
		int m = Integer.parseInt(M);
		int a = (100 - n) + (100 - m);
		int b = (100 - n) * (100 - m);
		int c = 100 - a;
		String sb = String.valueOf(b);
		String sc = String.valueOf(c);

		System.out.println(N + " X " + M + " = " + (n * m));
		System.out.println("100-" + N + "\t\t" + "100-" + M);
		System.out.println((100 - n) + "\t" + "+" + "\t" + (100 - m));
		System.out.println((100 - n) + "\t" + "X" + "\t" + (100 - m) +"\n");
		System.out.println("First two digits : 100 - " + a + " = " + (100 - a));
		System.out.println("Last two digits : " + sb);
		System.out.println("Result : " + sc + sb);
	}
}