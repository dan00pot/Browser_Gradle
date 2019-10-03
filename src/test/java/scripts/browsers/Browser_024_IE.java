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

public class Browser_024_IE {
	
/*#################################################################################
 * Browser_024_IE	Navigate configuration tabs 
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

	final static Logger logger = LogManager.getLogger("Browser_024_IE");

	@Before
	public void beforetestAADS_Browsers_001_IE() throws Exception {
		logger.info("beforetest Browser_024_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest Browser_024_IE completed...\n");
	}

	@Test
	public void Browser_024_IE() throws Exception {
		logger.info("Browser_024_IE - Starting\n");
		try {

			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,"huydao@aam1.com", aadsData.AADS_USER_PWD);

			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Contact Integrity");

			// Step 3-4
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Dynamic Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Service Control");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Client Administration");
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Server Connections");
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Cluster Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Web Deployment");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Pictures");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Logs Management");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browser_024_IE - Failed with Exception:"
					+ exception + "...\n");
			fail("Browser_024_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browser_024_IE - test completed\n");
	}

	@After
	public void tearDown(){
		logger.info("tearDown starting...\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.logoutAADSMainPage(webDriver);
			webDriver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("tearDown completed...\n");
	}
}
