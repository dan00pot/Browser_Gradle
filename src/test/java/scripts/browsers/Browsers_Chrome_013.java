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

public class Browsers_Chrome_013 {
	
/*#################################################################################
 * Browsers_Chrome_013	Logs Management - Collect logs
	"Verify that admin can collect logs from AADS
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Logs management -> Log Level
	3. From Collect Logs, click Collect -> Ok
	4. Click Download
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Logs management page is displayed clearly
	3. Logs are collect successfully from server without errors
	4. aads_logs file is downloaded to PC"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_013");

	@Before
	public void beforetestBrowsers_Chrome_013() throws Exception {
		logger.info("beforetest Browsers_Chrome_013 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_013 completed...\n");
	}

	@Test
	public void AADS_Browsers_013() throws Exception {

		try {
			logger.info("Browsers_Chrome_013- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,
					aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Logs management -> Log Level
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Logs Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Log Level");
			AADSWebDriver.collectLogIE(webDriver, aadsData.AADS_SERVER_IPv4_ADDRESS);
			logger.info("Browsers_Chrome_013 - completed...\n");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("AADS_Browsers_013_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_013_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_013_Chrome - completed...\n");
	}

	@After
	public void tearDown(){
		logger.info("tearDown starting...\n");
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
