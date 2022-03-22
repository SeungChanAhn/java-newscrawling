package Prac0322;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class R2_0322 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat();
		String currentYear = "";
		String currentMonthAndDay = "";
		String birthYear = "";
		String birthMonthAndDay = "";

		System.out.println("Current Date :"); // 현재 날짜를 입력한다.
		String currentDate = scanner.nextLine();
		currentYear = currentDate.substring(0, 4); // substring을 이용해서 연도와 월일을 나눠준다.
		currentMonthAndDay = currentDate.substring(4, 8);

		System.out.println("Birthday :");
		String birthDay = scanner.nextLine();
		birthYear = birthDay.substring(0, 4);
		birthMonthAndDay = birthDay.substring(4, 8);

		int cY = Integer.parseInt(currentYear); // 정수형으로 바꿈.
		int cMD = Integer.parseInt(currentMonthAndDay);
		int bY = Integer.parseInt(birthYear);
		int bMD = Integer.parseInt(birthMonthAndDay);

		KoreanAge(cY, bY);
		InternationalAge(cY, cMD, bY, bMD);
	}

	public static void KoreanAge(int currentYear, int birthYear) {

		int age = currentYear - birthYear + 1;
		System.out.println(age + " years old in Korean age");
	}
	
	public static void InternationalAge(int currentYear, int currentMonthAndDay, int birthYear,
			int birthMonthAndDay) {

		int age = currentYear - birthYear;
		if (currentMonthAndDay < birthMonthAndDay) { // 생일이 지났는지 확인.
			age--;
		} else {

		}
		System.out.println(age + " years old in international age");
	}
}
