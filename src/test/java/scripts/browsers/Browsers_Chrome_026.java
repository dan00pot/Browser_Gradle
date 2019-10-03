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

public class Browsers_Chrome_026 {
	
/*#################################################################################
 * Browsers_Chrome_026	Login Info
	"Verify that user information display correctly when login with different users and role
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Login with Administrator Role user
	3. Login with Auditor Role User
	4. Login with Security Role User
	
	*Expected Result:
	User log in successfully, correct username and role are displayed in top right of page
	"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_026");

	@Before
	public void beforetestBrowsers_Chrome_026() throws Exception {
		logger.info("beforetest Browsers_Chrome_026 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_026 completed...\n");
	}

	@Test
	public void Browsers_026_Chrome() throws Exception {
		logger.info("Browsers_026_Chrome - Starting\n");
		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			boolean result = AADSWebDriver.verifyLoginInformation(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, "Administrator");
			assertTrue(result);

		} catch (Exception exception) {

			logger.error("Browsers_026_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_026_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_026_Chrome - test completed\n");
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
