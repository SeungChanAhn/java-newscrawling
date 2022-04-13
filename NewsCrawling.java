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
		System.out.print("검색할 단어를 입력하세요.\n▶ ");
		String keyword = scanner.nextLine();
		System.out.print("현재부터 언제까지의 뉴스를 출력할까요?\n예시) 2022년 3월 24일 -> 2022-03-24\n▶ ");
		String period = scanner.nextLine();
		String newPeriod[] = period.split("-");
		int year = Integer.valueOf(newPeriod[0]);
		int month = Integer.valueOf(newPeriod[1]);
		int day = Integer.valueOf(newPeriod[2]);

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();

		driver.get("https://www.naver.com/"); // 네이버뉴스
		sleep(1000);

		// 검색버튼 클릭
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[3]/form/fieldset/button/span[2]"))
				.click();
		sleep(1000);
		
		// 뉴스항목 클릭
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[1]/div/ul/li[8]/a"))
				.click();
		sleep(1000);

		// keyword 입력
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/div/form/fieldset/div[1]/input"))
				.sendKeys(keyword);
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/div/form/fieldset/div[1]/input"))
				.sendKeys(Keys.ENTER);
		sleep(1000);

		// 옵션 클릭
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/a")).click();
		sleep(1000);

		// 직접입력 클릭
		driver.findElement(By.xpath("//*[@id=\"snb\"]/div[2]/ul/li[2]/div/div[1]/a[9]")).click();
		sleep(1000);

		// 연도 설정
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[2]/div[1]/div/div/div/ul/li["
						+ (year - 1989) + "]/a"))
				.click();
		sleep(1000);

		// 월 설정
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[2]/div[2]/div/div/div/ul/li["
						+ month + "]/a"))
				.click();
		sleep(1000);

		// 일 설정
		driver.findElement(By.xpath(
				"/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[2]/div[3]/div/div/div/ul/li["
						+ day + "]/a"))
				.click();
		sleep(1000);

		// 적용 클릭
		driver.findElement(
				By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[2]/div/div[3]/div[3]/button"))
				.click();
		sleep(1000);

		// 최신순 정렬
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/a[2]")).click();
		sleep(1000);

		// 첫 페이지부터 마지막 페이지까지 신문사, 날짜, 기사제목, url 출력
		String newspaperStart = "/html/body/div[3]/div[2]/div/div[1]/section[1]/div/div[2]/ul/li[";
		String newspaperEnd = "]/div/div/div[1]/div[2]/a";
		String dayStart = "/html/body/div[3]/div[2]/div/div[1]/section[1]/div/div[2]/ul/li[";
		String dayEnd = "]/div/div/div[1]/div[2]/span";
		String titleStart = "/html/body/div[3]/div[2]/div/div[1]/section[1]/div/div[2]/ul/li[";
		String titleEnd = "]/div/div/a";
		ArrayList<String> newsList = new ArrayList<String>();
		int cnt = 0;
		try {
			System.out.println("크롤링을 시작합니다.");
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
			System.out.println("크롤링이 끝났습니다. 리스트를 출력하고, csv파일로 저장하겠습니다.");
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
			System.out.println("파일이 C드라이브 news 폴더에 저장되었습니다.");
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
