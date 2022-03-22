package Prac0321;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class R1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		////////////////////////////////////////////// 각 문자를 리스트에 오름차순정렬
		char[] word1 = new char[line1.length()];
		for (int i = 0; i < line1.length(); i++) {
			word1[i] = line1.charAt(i);
			list1.add(word1[i]);
		}
		Collections.sort(list1);

		char[] word2 = new char[line2.length()];
		for (int i = 0; i < line2.length(); i++) {
			word2[i] = line2.charAt(i);
			list2.add(word2[i]);
		}
		Collections.sort(list2);
		////////////////////////////////////////////// 리스트 비교
		if (list1.size() == list2.size()) {
			if (list1.containsAll(list2) == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			System.out.println("NO");
		}
	}
}