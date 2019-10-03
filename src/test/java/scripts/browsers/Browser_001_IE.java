package scripts.browsers;

import libs.clients.AADSWebKeywords;
import libs.common.DriverManagement;
import libs.common.Selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import testData.aadsData;

public class Browser_001_IE {
	
/*#############################################################################
 * Browser_001_IE: Login and logout adminUi using correct user and password

 *"Verify that user can login and logout Admin UI normally

*Procedure:
1. Go to https://<aads fqdn>:8445/admin/
2. Login Admin UI by correct username and password
3. Click on logoff button to log out Admin UI

*Expected Result:
1. AADS admin UI login page is displayed clearly without errors
2. User can input username and password and login successfully
3. AdminUI back to login page "
 
 ##############################################################################*/

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browser_001_IE");

	@Before
	public void beforetestAADS_Browsers_001_IE() throws Exception {
		logger.info("beforetest Browser_001_IE starting\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest Browser_001_IE completed\n");
	}

	@Test
	public void Browser_001_IE() throws Exception {

		logger.info("Browser_001_IE - starting\n");

		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			boolean n = AADSWebDriver.loginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER, "tma_12Tma");
			assertTrue(n);
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("Browser_001_IE - Failed with Exception:" + exception
					+ "\n");
			fail("Browser_001_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		logger.info("Teardown is starting");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("Teardown completed");
	}
}
