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

public class Browsers_Firefox_012 {
	
/*#################################################################################
 * Browsers_Firefox_012	Logs Management - Change log level
"Verify that admin can change log level

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Logs management -> Log Level
	3. Change Current logging level to FINEST -> Save
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Logs management page is displayed clearly
	3. Logging level is changed successfully"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_012");

	@Before
	public void beforetestBrowsers_Firefox_012() throws Exception {
		logger.info("beforetest Browsers_Firefox_012 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_012 completed...\n");
	}

	@Test
	public void AADS_Browsers_012() throws Exception {
		try {
			logger.info("Browsers_Firefox_012- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Logs management -> Log Level
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Logs Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Log Level");
			boolean result = AADSWebDriver.changeLogLevel(webDriver, "Firefox","FINEST - All possible messages");
			logger.info("Browsers_Firefox_012- completed...\n");
			assertTrue(result);
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_012_Firefox - Failed with Exception:" + exception + "...\n");
			fail("AADS_Browsers_012_Firefox - Failed - Exception occurs: "	+ exception.toString());
		}
		logger.info("AADS_Browsers_012_Firefox - completed...\n");
	}

	 @After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
