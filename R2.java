package Prac0321;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class R2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double meterPerSecond = scanner.nextDouble();
		double killometerPerHour = scanner.nextDouble();
		double meterPermills = scanner.nextDouble();
		double new_KMpH = killometerPerHour / 3.6; // km/h을 m/s로 단위 변환 후 newKMpH로 초기화
		double new_MpMS = meterPermills / 1000; // m/ms을 m/s로 단위 변환 후 newMpMS로 초기화
		
		List<Double> numList = new ArrayList<>();
		numList.add(meterPerSecond);
		numList.add(new_KMpH);
		numList.add(new_MpMS);
		Collections.sort(numList, Collections.reverseOrder()); //리스트에 변환된 값을 추가하고 내림차순 정렬

		if (meterPerSecond == numList.get(0)) { // 0번째 리스트가 최대값이다. 본인이 최대값이면 input값으로 출력
			System.out.println(meterPerSecond + "m/s");
		} else if (new_KMpH == numList.get(0)) {
			System.out.println(killometerPerHour + "km/h");
		} else if (new_MpMS == numList.get(0)) {
			System.out.println(meterPermills + "m/ms");
		} else {
			
		}
	}
}