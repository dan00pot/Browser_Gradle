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

public class Browser_009_IE {
	
/*#################################################################################
 * Browser_009_IE	Server Connections - CORS Configuration
	"Verify that CORS Configuration tab is displayed clearly

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Server Connections ->  CORS Configuration -> Service Interface
	3. Check Enable Cross-Origin Resource Sharing and input CORS domain in Specific Domain(s) -> Save
	4. Navigate to Server Connections ->  CORS Configuration -> Admin Interface
	5. Check Enable Cross-Origin Resource Sharing and Allow access from any origin -> Save
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Service Interface page is displayed clearly without errors
	3. Specific Domain(s) field is displayed when check on Enable Cross-Orgin Resource Sharing, domain can be inputted and saved successfully
	4. Admin Interface page is displayed clearly without errors
	5. Specific Domain(s) field isn't displayed when check on Allow access from any origin, configure can be saved successfully "

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browser_009_IE");

	@Before
	public void beforetestBrowser_009_IE() throws Exception {
		logger.info("beforetest Browser_009_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest Browser_009_IE completed...\n");
	}

	@Test
	public void AADS_Browsers_009() throws Exception {

		try {
			logger.info("Browser_009_IE- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Server Connections -> LDAP Configuration ->
			// Enterprise Directory
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Server Connections");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"CORS Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Service Interface");
			Thread.sleep(4000);
			AADSWebDriver.serverConnectionsPageCORSconfigure(webDriver, true, false, "tma.com.vn");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Admin Interface");
			Thread.sleep(2000);
			AADSWebDriver.serverConnectionsPageCORSconfigure(webDriver, true, true, "tma.com.vn");
			logger.info("Browser_009_IE - Passed...\n");
			assertTrue(true);

		} catch (Exception exception) {
			logger.error("Browser_009_IE - Failed with Exception:"
					+ exception + "...\n");
			fail("Browser_009_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browser_009_IE - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
