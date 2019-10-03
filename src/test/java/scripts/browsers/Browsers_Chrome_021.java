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

public class Browsers_Chrome_021 {
	
/*#################################################################################
 * Browsers_Chrome_021	Web Deployment Tab - Remove appcast item
	"Verify that admin can delete appcast in Web Deployment  

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Web Deployment -> Deployment
	3. Choose appcast which want to edit from Appcast Items
	4. Click Delete -> Ok to delete appcast
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Deployment page is displayed clearly
	3. Appcast item is selected and displayed correctly
	4. Appcast is deleted successfully"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_021");

	@Before
	public void beforetestBrowsers_Chrome_021() throws Exception {
		logger.info("beforetest Browsers_Chrome_021 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_021 completed...\n");
	}

	@Test
	public void Browsers_021_Chrome() throws Exception {
		logger.info("Browsers_021_Chrome - Starting\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,
					aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Web Deployment");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Deployment");
			AADSWebDriver.deploymentPageDeleteAppcastItem(webDriver,aadsData.AADS_APPCAST_FILE_NAME_NEW);
			logger.info("Browsers_Chrome_021 - Passed\n");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_021_Chrome - Failed with Exception:"	+ exception + "...\n");
			fail("Browsers_021_Chrome - Failed - Exception occurs: "+ exception.toString());
		}
		logger.info("Browsers_021_Chrome - completed...\n");
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
