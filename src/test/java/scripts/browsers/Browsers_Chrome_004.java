package scripts.browsers;

import libs.clients.AADSWebKeywords;
import libs.common.DriverManagement;
import libs.common.Selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import testData.aadsData;

public class Browsers_Chrome_004 {
	
/*##############################################################################
 * Browsers_Chrome_004	Service control Tab - Set and save config
"Verify that user can modify and save value in Application properties
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Service Control -> Application Management
	3. Change some value in Application properties then click Save
	4. Logout then relogin to verify setting is saved successfully
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Application Management page is displayed clearly without error
	3. Value are changed and saved successfully without error
	4. Changed value still be kept after relogin"

 *############################################################################## */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_004");

	@Before
	public void beforetestBrowsers_Chrome_004() throws Exception {
		logger.info("beforetest Browsers_Chrome_004 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_004 completed...\n");
	}

	@Test
	public void AADS_Browsers_004() throws Exception {
		logger.info("AADS_Browsers_004_Chrome- starting...\n");
		try {
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Service Control -> Application Management
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Service Control");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Application Management");
			// Change some value in Application properties --> click save
			AADSWebDriver.applicationMGMTPageChangeApplicationPropertiesValues(webDriver, "Chrome", "Save");
			// relogin AADS web page
			AADSWebDriver.loginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Verify the value after login
			Thread.sleep(160000);
			AADSWebDriver.applicationMGMTPageVerifyApplicationPropertiesValues(webDriver);
			logger.info("Browsers_Chrome_004 - PASSED...\n");
			assertTrue(true);
			AADSWebDriver.applicationMGMTPageChangeApplicationPropertiesDefaultValues(webDriver, "Chrome", "Save");
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_004_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_004_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_004_Chrome - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
