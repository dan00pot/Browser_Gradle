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

public class Browsers_Chrome_001 {
	
/*#############################################################################
 * Browsers_Chrome_001: Login and logout adminUi using correct user and password

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

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_001");

	@Before
	public void beforetestBrowsers_001_Chrome() throws Exception {
		logger.info("beforetest Browsers_Chrome_001 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_001 completed...\n");
	}

	@Test
	public void AADS_Browsers_001() throws Exception {

		logger.info("Browsers_Chrome_001 - starting...\n");

		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			boolean n = AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, "tma_12Tma");
			assertTrue(n);
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("Browsers_Chrome_001 - Failed with Exception:"	+ exception + "...\n");
			fail("Browsers_Chrome_001 - Failed - Exception occurs: "+ exception.toString());
		}
		logger.info("Browsers_Chrome_001 - completed...\n");
	}

	private void asserttrue(Boolean n) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
