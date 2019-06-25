package com.sf.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/sf/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");

		switch (browsername.toString()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/D:/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Defined browser not available");
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void cleanup() {
		driver.quit();
	}
}
