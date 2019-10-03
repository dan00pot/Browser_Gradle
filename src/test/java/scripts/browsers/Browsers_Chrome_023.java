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

public class Browsers_Chrome_023 {
	
/*#################################################################################
 * Browsers_Chrome_023	Contact Integrity Tab
	"Verify that  Contact Integrity page work correctly
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Contact Integrity 
	3. Input 10 valid contacts email address then Submit
	4. Input 1 valid contacts emaill and 1 invalid contact email then Submit
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without error
	2. Contact Integrity page is displayed clearly
	3. Contacts are submitted successfully with announcement ""10 Users submitted successfully for contact integrity""
	4. Contacts are submitted successfully with announcement ""1 Users submitted successfully for contact integrity"""

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_023");

	@Before
	public void beforetestBrowsers_Chrome_023() throws Exception {
		logger.info("beforetest Browsers_Chrome_023 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_023 completed...\n");
	}

	@Test
	public void Browsers_023_Chrome() throws Exception {
		logger.info("Browsers_023_Chrome - Starting\n");
		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Contact Integrity");

			// Step 3-4
			AADSWebDriver.contactIntegrityInputContactEmailAddress(webDriver,aadsData.AADS_USER_1_NAME);
			AADSWebDriver.contactIntegrityVerifyAnnoncement(webDriver, "1",	"IE");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_023_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_023_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_023_Chrome - test completed\n");
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
