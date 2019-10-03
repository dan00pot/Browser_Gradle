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

public class Browsers_Chrome_003 {
	
/*#####################################################################################
 * Browsers_Chrome_003	Service control Tab - Stop/Start services
"Verify that user can stop/start service in Application Management 

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Service Control -> Application Management
	3. Check into Device Services checkbox then Click Stop -> OK
	4. Check into Device Services checkbox then Click Start -> OK
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Application Management page is displayed clearly without error
	3. AADS services are stopped successfully
	4. AADS services are started successfully"
 *##################################################################################### */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_003");

	@Before
	public void beforetestBrowsers_Chrome_003() throws Exception {
		logger.info("beforetest Browsers_Chrome_003 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_003 completed...\n");
	}

	@Test
	public void AADS_Browsers_003() throws Exception {
		logger.info("AADS_Browsers_003_Chrome- starting...\n");

		try {
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Service Control -> Application Management
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Service Control");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Application Management");
			// Stop services
			AADSWebDriver.ApplicationMGMTPageSelectStopDeviceServices(webDriver);
			boolean result = AADSWebDriver.ApplicationMGMTPageVerifyServiceStatus(webDriver, false);
			assertTrue(result);
			logger.info("Browsers_Chrome_003- stop services successful...\n");
			// Start services
			AADSWebDriver.ApplicationMGMTPageSelectStartDeviceServices(webDriver);
			result = AADSWebDriver.ApplicationMGMTPageVerifyServiceStatus(webDriver, true);
			logger.info("Browsers_Chrome_003- start services successful...\n");
			assertTrue(result);
		} catch (Exception exception) {
			logger.error("AADS_Browsers_003_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_003_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_003_Chrome - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
