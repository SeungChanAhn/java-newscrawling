package crawl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class NewsCrawling {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\crawl\\chromedriver.exe";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�˻��� �ܾ �Է��ϼ���.\n�� ");
		String keyword = scanner.nextLine();
		System.out.print("������� ���������� ������ ����ұ��?\n����) 2022�� 3�� 24�� -> 2022-03-24\n�� ");
		String period = scanner.nextLine();
		String newPeriod[] = period.split("-");
		int year = Integer.valueOf(newPeriod[0]);
		int month = Integer.valueOf(newPeriod[1]);
		int day = Integer.valueOf(newPeriod[2]);

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();

		driver.get("https://www.naver.com/"); // ���̹�����
		sleep(1000);

		// �˻���ư Ŭ��
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[3]/form/fieldset/button/span[2]"))
				.click();
		sleep(1000);
		
		// �����׸� Ŭ��
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[1]/div/ul/li[8]/a"))
				.click();
		sleep(1000);

		// keyword �Է�
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/div/form/fieldset/div[1]/input"))
				.sendKeys(keyword);
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/div/form/fieldset/div[1]/input"))
				.sendKeys(Keys.ENTER);
		sleep(1000);

		// �ɼ� Ŭ��
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/a")).click();
		sleep(1000);

		// �����Է� Ŭ��
		driver.findElement(By.xpath("//*[@id=\"snb\"]/div[2]/ul/li[2]/div/div[1]/a[9]")).click();
		sleep(1000);

		// ���� ����
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[2]/div[1]/div/div/div/ul/li["
						+ (year - 1989) + "]/a"))
				.click();
		sleep(1000);

		// �� ����
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[2]/div[2]/div/div/div/ul/li["
						+ month + "]/a"))
				.click();
		sleep(1000);

		// �� ����
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[2]/div[3]/div/div/div/ul/li["
						+ day + "]/a"))
				.click();
		sleep(1000);

		// ���� Ŭ��
		driver.findElement(
				By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[3]/button"))
				.click();
		sleep(1000);

		// �ֽż� ����
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/a[2]")).click();
		sleep(1000);

		// ù ���������� ������ ���������� �Ź���, ��¥, �������, url ���
		String newspaperStart = "/html/body/div[3]/div[2]/div/div[1]/section[1]/div/div[2]/ul/li[";
		String newspaperEnd = "]/div/div/div[1]/div[2]/a";
		String dayStart = "/html/body/div[3]/div[2]/div/div[1]/section[1]/div/div[2]/ul/li[";
		String dayEnd = "]/div/div/div[1]/div[2]/span";
		String titleStart = "/html/body/div[3]/div[2]/div/div[1]/section[1]/div/div[2]/ul/li[";
		String titleEnd = "]/div/div/a";
		ArrayList<String> newsList = new ArrayList<String>();
		int cnt = 0;
		try {
			System.out.println("ũ�Ѹ��� �����մϴ�.");
			while (true) {
				for (int i = 1; i <= 10; i++) {
					String tempNewspaper = newspaperStart + i + newspaperEnd;
					String newspaper = driver.findElement(By.xpath(tempNewspaper)).getText();
					String tempNewsDate = dayStart + i + dayEnd;
					String newsDate = driver.findElement(By.xpath(tempNewsDate)).getText();
					String tempTitle = titleStart + i + titleEnd;
					String title = driver.findElement(By.xpath(tempTitle)).getText();
					String url = driver.findElement(By.xpath(tempTitle)).getAttribute("href");

					cnt++;
					String strCnt = String.valueOf(cnt);
					String all = strCnt + "," + newspaper + "," + "\"" + "\"" + title + "\"" + "\"" + "," + url
							+ "\n";
					newsList.add(all);
				}
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[2]/div/a[2]/i")).click();
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("ũ�Ѹ��� �������ϴ�. ����Ʈ�� ����ϰ�, csv���Ϸ� �����ϰڽ��ϴ�.");
		}
		System.out.println(newsList);
		writeCsv(newsList);
	}

	public static void writeCsv(ArrayList<String> list) {
		String fileName = "C:\\news\\test1.csv";
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			for (String newsCsv : list) {
				out.write(newsCsv.getBytes());
			}
			System.out.println("������ C����̺� news ������ ����Ǿ����ϴ�.");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}

	public static void sleep(int N) {
		try {
			Thread.sleep(N);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
