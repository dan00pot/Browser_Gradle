package scripts.test01;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.WiniumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.windows.WindowsDriver;

import java.util.concurrent.TimeUnit;
import java.net.URL;

import libs.common.DriverManagement;
import libs.clients.AADSWebKeywords;
import libs.clients.WindowsClientKeywords;

public class TestScript_Web_001 {

	AADSWebKeywords webDriver = new AADSWebKeywords();
	WindowsClientKeywords winClient = new WindowsClientKeywords();
	
	static WebDriver newSession;
	static DriverManagement driverMgt = new DriverManagement();
	static AndroidDriver androidSession;
	static WiniumDriver winDriver;
	static WindowsDriver windowsDriver;
	static WindowsDriver windowsDriverRoot;
	WebElement CalculatorResult = null;

	@BeforeClass
	public static void setup() {
		try {
			//androidSession = driverMgt.createAndroidClientDriver();
			// newSession = driverMgt.createFFDriver();
			windowsDriverRoot = driverMgt.createWinAppDriver("http://10.255.249.9:4724");
			WebElement handle = windowsDriverRoot.findElementByName("Avaya Equinox");
			String st = handle.getAttribute("NativeWindowHandle");
			String s2 = Integer.toHexString(Integer.parseInt(st));
			System.out.println(s2);
			String equinox = "0x"+s2; 
			windowsDriver = driverMgt.createWinHandleDriver("http://10.255.249.9:4724",equinox);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@AfterClass
	public static void teardown() {
		try {
		/*	newSession.quit();
			androidSession.quit();*/
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	@Test
	public void test() throws Exception {
		
		/*   newSession.get("https://aws1-aads-sin.tma.com.vn:8445/admin");
 		   webDriver.loginAADSMainPage(newSession, "huydao@tma.com.vn","tma_12Tma");
 		   webDriver.logoutAADSMainPage(newSession);*/
		 
/*		String equinox = winClient.getWinHandle(windowsDriverRoot, "Avaya Equinox");
		windowsDriver = driverMgt.createWinHandleDriver("http://10.255.249.9:4724",equinox);*/
		
/*		int demical = Integer.parseInt(st, 16);
		System.out.println(demical);
		
		String t = asciiToHex(st);
		System.out.println(t);*/
		
		
/*		winClient.verifyEnterpriseContactSearch(windowsDriver, "Sumail", "Hassan,Sumail");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "Barq", "Barqawi,Amer");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "xlinsen", "Linsen,Xu");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "stakhasomi@aam1.com", "Takhasomi,Salehi");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "civanov@aam", "Ivanov Clement");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "\\83806", "Chun,Song");*/
	
		winClient.verifyEnterpriseContactSearch(windowsDriver, "Wagner", "Kristin Wagner");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "frush@aam1.com", "Franklyn Rush");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "Kris", "Kristin Wagner");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "pdavies", "Paris Davies");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "mbernal@aam1", "Madeleine Bernal");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "\\80075", "Eden Felix");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "cma", "Clay Mac");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "\\8007", "Jayson Metcalfe");
		winClient.verifyEnterpriseContactSearch(windowsDriver, "\\80075", "Eden Felix");
/*		windowsDriver.findElementByXPath("//*[@ClassName='TextBox']").sendKeys("Sumail Hassan");
		Thread.sleep(1000);

		
		Actions action = new Actions(windowsDriver);
		action.moveToElement(windowsDriver.findElementByName("Hassan,Sumail")).build().perform();
		Thread.sleep(1500);
		windowsDriver.findElementByName("Add New Contact").click();
		windowsDriver.findElementByName("Add Contact").click();
		Thread.sleep(3000);
		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarHomeContentToggleButton']").click();
		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarContactsContentToggleButton']").click();
		
		windowsDriver.quit();
		windowsDriverRoot.quit();*/
		

/*		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarHomeContentToggleButton']").click();
		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarFavoritesContentToggleButton']").click();
		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarContactsContentToggleButton']").click();
		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarCallHistoryContentToggleButton']").click();
		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarConversationsContentToggleButton']").click();
		
		
		windowsDriver.findElementByXPath("//*[@AutomationId='TabBarContactsContentToggleButton']").click();*/
		
		
		
		
		
	//	windowsDriver.findElementByXPath("//*[@Name='Search for someone (F3) or enter a number to call']").sendKeys("123456");
	//	windowsDriver.findElementByXPath("//*[@Name='Search for someone (F3) or enter a number to call']").clear();

	}
	
	public static String asciiToHex(String value) {
		char[] chars = value.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i=0;i<chars.length;i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}
	
}

