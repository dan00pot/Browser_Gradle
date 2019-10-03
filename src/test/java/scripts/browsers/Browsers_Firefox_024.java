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

public class Browsers_Firefox_024 {
	
/*#################################################################################
 * Browsers_Firefox_024	Navigate configuration tabs 
	"Verify that user navigate several tabs without errors
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Login Admin UI by correct username and password
	3. Navigate to some configuration tabs
	4. Logout
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. User can input username and password and login successfully
	3. Configuration pages are displayed without errors
	4. Logout successfully"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_024");

	@Before
	public void beforetestBrowsers_Firefox_024() throws Exception {
		logger.info("beforetest Browsers_Firefox_024 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_024 completed...\n");
	}

	@Test
	public void Browsers_Firefox_024() throws Exception {
		logger.info("Browsers_Firefox_024 - Starting\n");
		try {

			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,"huydao@aam1.com", aadsData.AADS_USER_PWD);

			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Contact Integrity");

			// Step 3-4
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Dynamic Configuration");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Service Control");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Client Administration");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Server Connections");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Cluster Configuration");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Web Deployment");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Pictures");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Logs Management");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_Firefox_024 - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_Firefox_024 - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_Firefox_024 - test completed\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		webDriver.get(aadsData.AADS_SERVER_ADDRESS);
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
