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

public class Browser_010_IE {
	
/*#################################################################################
 * Browser_010_IE	Server Connections - Trusted Hosts
"Verify that Trusted Hosts tab is displayed clearly, can add new host to host list 

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Server Connections ->  Server Connections -> Trusted Hosts
	3. Add new trusted host to list
	4. Edit trusted host fqdn
	5. Delete host from list
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Trusted hosts page is displayed clearly without errors, hosts in host list are displayed completely
	3. New trusted host is added and displayed in host list
	4. Trusted host is edited successfully without errors
	5. Host is deleted successfully"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browser_010_IE");

	@Before
	public void beforetestBrowser_010_IE() throws Exception {
		logger.info("beforetest Browser_010_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest Browser_010_IE completed...\n");
	}

	@Test
	public void Browser_010_IE() throws Exception {

		try {
			logger.info("AADS_Browsers_- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Server Connections -> LDAP Configuration ->
			// Enterprise Directory
			AADSWebDriver.navigateToFeaturesPage(webDriver,
					"Server Connections");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Trusted Hosts");

			// Incomplete script, need enhance
			AADSWebDriver.serverConnetionsPageAddTrustedHost(webDriver,"1.1.1.1");
			AADSWebDriver.serverConnetionsPageEditTrustedHost(webDriver,"2.2.2.2", "1.1.2.2");
			AADSWebDriver.serverConnetionsPageDeleteTrustedHost(webDriver,"2.2.2.2");
			// Deleted directory
			logger.info("AADS_Browsers_008_Firefox - Passed...\n");
			assertTrue(true);

		} catch (Exception exception) {
			logger.error("AADS_Browsers_008_Firefox - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_008_Firefox - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_008_Firefox - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
