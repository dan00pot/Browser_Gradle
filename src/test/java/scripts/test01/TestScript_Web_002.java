package scripts.test01;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;
import java.net.URL;

import libs.common.DriverManagement;
import libs.clients.AADSWebKeywords;
import libs.clients.AndroidClientKeywords;

public class TestScript_Web_002 {

	AADSWebKeywords webDriver = new AADSWebKeywords();
	AndroidClientKeywords androidDriver = new AndroidClientKeywords();
	static DriverManagement driverMgt = new DriverManagement();
	static WebDriver newSession;
	static AndroidDriver androidSession;
	WebElement CalculatorResult = null;

	@BeforeClass
	public static void setup() {
		try {
			// androidSession = driverMgt.createAndroidClientDriver();
			newSession = driverMgt.createFFDriver();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@AfterClass
	public static void teardown() {
		try {
			// newSession.quit();
			// androidSession.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@Test
	public void test() throws Exception {
		newSession.get("https://10.255.247.209");
		newSession.findElement(By.xpath("//p[@class='center']/a")).click();
		Thread.sleep(1000);
		newSession.findElement(By.xpath("//input[@name='userName']")).sendKeys(
				"admin");
		newSession.findElement(By.xpath("//input[@name='logonButton']"))
				.click();
		newSession.findElement(By.xpath("//input[@name='pa55word']")).sendKeys(
				"Avaya123$");
		newSession.findElement(By.xpath("//input[@name='logonButton']"))
				.click();
		newSession.findElement(By.xpath("//input[@name='motdContinue']"))
				.click();
		Thread.sleep(5000);

		Actions action = new Actions(newSession);
		action.moveToElement(
				newSession.findElement(By.xpath("//*[text()='Administration']")))
				.build().perform();

		Thread.sleep(1000);
		newSession.findElement(By.xpath("//*[contains(text(),'Messaging')]"))
				.click();

		/*
		 * webDriver.loginAADSMainPage(newSession, "huydao@tma.com.vn",
		 * "tma_12Tma"); webDriver.logoutAADSMainPage(newSession);
		 * androidSession.resetApp();
		 * androidDriver.autoConfigLogin(androidSession,
		 * "https://aws1-aads-sin.tma.com.vn:443/acs/resources/configurations",
		 * "kwagner@tma.com.vn", "tma_12Tma");
		 */

	}
}
