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

public class Browsers_Chrome_017 {
	
/*#################################################################################
 * Browsers_Chrome_017	Dynamic Configuration Tab - Default
	"Verify that Defaults page working normally without errors
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Dynamic Configuration -> Defaults
	3. Check on Lock settings and Obscure locked settings -> Save
	4. Uncheck Lock settings -> Save
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Defaults page is displayed clearly
	3. Obscure locked settings option is displayed after check Lock settings, options are checked and saved without errors
	4. Options are unchecked and save successfully"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_017");

	@Before
	public void beforetestBrowsers_Chrome_017() throws Exception {
		logger.info("beforetest Browsers_Chrome_017 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_017 completed...\n");
	}

	@Test
	public void Browsers_017_Chrome() throws Exception {
		logger.info("Browsers_017_Chrome - Starting\n");
		try {

			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Dynamic Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Defaults");
			// Step 3-4
	
			AADSWebDriver.selectAllowPasswordsCheckbox(webDriver, true);
			AADSWebDriver.selectLockedPreferencesCheckbox(webDriver, true);
			AADSWebDriver.selectObsecuredPreferenceCheckbox(webDriver, true, true);
			AADSWebDriver.saveAndVerifyDefaultPage(webDriver,"Settings were published successfully");

			AADSWebDriver.selectAllowPasswordsCheckbox(webDriver, true);
			AADSWebDriver.selectLockedPreferencesCheckbox(webDriver, false);
			AADSWebDriver.saveAndVerifyDefaultPage(webDriver,"Settings were published successfully");

			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_017_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_017_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_017_Chrome - test completed\n");
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
