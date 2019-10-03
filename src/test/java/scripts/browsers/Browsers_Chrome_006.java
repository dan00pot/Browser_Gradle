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

public class Browsers_Chrome_006 {
	
/*#################################################################################
 * Browsers_Chrome_006	Server Connections - LDAP Configuration - add new Directory
"Verify that user can add new Directory

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Server Connections ->  LDAP Configuration -> Enterprise Directory
	3. Click + button
	4. Input valid value to the required fields then Save -> OK
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Enterprise Directory page is displayed clearly without error
	3. New Directory tab is created
	4. Value can be inputted and save without error "

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_006");

	@Before
	public void beforetestBrowsers_Chrome_006() throws Exception {
		logger.info("beforetest Browsers_Chrome_006 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_006 completed...\n");
	}

	@Test
	public void AADS_Browsers_006() throws Exception {
		try {
			logger.info("Browsers_Chrome_006- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			Thread.sleep(2000);
			// Navigate to Server Connections -> LDAP Configuration ->
			// Enterprise Directory
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Server Connections");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"LDAP Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Enterprise Directory");
			// Add new directory
			AADSWebDriver.ldapConfigAddNewDirectory(webDriver, "Chrome");
			logger.info("Browsers_Chrome_006 - Passed...\n");
			assertTrue(true);
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_006_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_006_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_006_Chrome - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
