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
		double new_KMpH = killometerPerHour / 3.6; // km/h�� m/s�� ���� ��ȯ �� newKMpH�� �ʱ�ȭ
		double new_MpMS = meterPermills / 1000; // m/ms�� m/s�� ���� ��ȯ �� newMpMS�� �ʱ�ȭ
		
		List<Double> numList = new ArrayList<>();
		numList.add(meterPerSecond);
		numList.add(new_KMpH);
		numList.add(new_MpMS);
		Collections.sort(numList, Collections.reverseOrder()); //����Ʈ�� ��ȯ�� ���� �߰��ϰ� �������� ����

		if (meterPerSecond == numList.get(0)) { // 0��° ����Ʈ�� �ִ밪�̴�. ������ �ִ밪�̸� input������ ���
			System.out.println(meterPerSecond + "m/s");
		} else if (new_KMpH == numList.get(0)) {
			System.out.println(killometerPerHour + "km/h");
		} else if (new_MpMS == numList.get(0)) {
			System.out.println(meterPermills + "m/ms");
		} else {
			
		}
	}
}