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

public class Browsers_Firefox_005 {
	
/*#################################################################################
 * Browsers_Firefox_005	Client Administration Tab
"Verify that Sub-tabs of Client Administrator are displayed clearly without error

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Client Administration -> HTTP Clients
	3. Navigate to Client Administration -> Feature Entitlements
	4. Logout
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. HTTP Clients is displayed clearly without error
	- REST and OAMP dropbox have those items: NONE, OPTIONAL,OPTIONAL_NO_CA and REQUIRED  
	3. Feature Entitlements is displayed clearly without error and correct WebLM URL
	4. Logout successfully"
 *################################################################################ */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_005");

	@Before
	public void beforetestBrowsers_Firefox_005() throws Exception {
		logger.info("beforetest Browsers_Firefox_005 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_005 completed...\n");
	}

	@Test
	public void AADS_Browsers_005() throws Exception {
		logger.info("Browsers_Firefox_005- starting...\n");
		try {
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,
					aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Client Administration --> HTTP Client
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Client Administration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "HTTP Clients");
			AADSWebDriver.clientAdministrationPageVerifyRestValues(webDriver);
			logger.info("clientAdministrationPageVerifyRestValues passed...\n");
			AADSWebDriver.clientAdministrationPageVerifyOAMPValues(webDriver);
			logger.info("clientAdministrationPageVerifyOAMPValues passed...\n");
			// Navigate to Client Administration --> Feature Entitlements
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Feature Entitlements");
			AADSWebDriver.clientAdministrationPageVerifyFeatureEntitlements(webDriver);
			// log out AADS

			logger.info("AADS_Browsers_005_IE passed...\n");
			assertTrue(true);
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("Browsers_Firefox_005 - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_Firefox_005 - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_005_Firefox - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
