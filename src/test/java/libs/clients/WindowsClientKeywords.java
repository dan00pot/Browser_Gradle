package libs.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import libs.common.Selenium;

public class WindowsClientKeywords {
	
	
	Selenium selenium = new Selenium();
	WindowsClientLocators windowsClient = new WindowsClientLocators();
	final static Logger logger = LogManager.getLogger("AADS Web Actions");
	WindowsDriver winClientDriver;
	
	public void verifyEnterpriseContactSearch (WindowsDriver winClientDriver, String name, String expected) throws Exception 
	{
		logger.info("verifyEnterpriseContactSearchOn - starting...\n");
		try {
			boolean flag = false;
			logger.info("**** verifyEnterprieseContactSearchOnACA - Get number of result ****");
			
			selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, name);
			
			Thread.sleep(5000);
			
			String s1 = selenium.getAttribute(winClientDriver, windowsClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,"Name");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
			logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
			logger.info("verifyEnterprieseContactSearch - Expected result: " + expected);
			
			for (int i = 0; i < num; i++) {
				String s2 = selenium.getAttribute(winClientDriver, windowsClient.search_contact_enterprise_result(expected), "Name");
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(expected)) {
					logger.info("verifyEnterprieseContactSearch - Existed the expected result - PASSED ");
					flag = true;
					break;
				}
			}
			if (flag == false) {
				logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
				throw new Exception("verifyEnterprieseContactSearch - Expected result didn't exist");
			}
			logger.info("verifyEnterprieseContactSearch - PASSED");
		} catch (Exception e) {
			
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
		}
	}
	
	
	public String getWinHandle(WindowsDriver windowDriver, String windowName) {
		try {
			WebElement handle = windowDriver.findElementByName("Avaya Equinox");
			String st = handle.getAttribute("NativeWindowHandle");
			String s2 = Integer.toHexString(Integer.parseInt(st));
			System.out.println(s2);
			String equinox = "0x"+s2;
			return equinox;
		} catch (Exception e) {
			return null;
		}
	}

}
