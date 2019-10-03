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

public class Browser_016_IE {
	
/*#################################################################################
 * Browser_016_IE	Dynamic Configuration Tab - DNS Mapping
	"Verify that DNS mapping page working without errors
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Dynamic Configuration -> DNS Mapping
	3. Add new dns mapping
	4. Remove dns mapping
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. DNS Mapping page is displayed clearly
	3. Admin can add new mapping successfully and displayed in list
	4. Mapping is removed successfully"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_016_IE");

	@Before
	public void beforetestBrowsers_016_IE() throws Exception {
		logger.info("beforetest Browsers_016_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		webDriver.manage().window().maximize();
		logger.info("beforetest Browsers_016_IE completed...\n");
	}

	@Test
	public void Browsers_016_IE() throws Exception {
		logger.info("Browsers_016_IE - Starting\n");
		try {

			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Dynamic Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "DNS Mapping");

			// Step 3-4
			// AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,
			// aadsData.AADS_USER_1_NAME);
			Thread.sleep(2000);
			logger.info("Browsers_016_IE - Starting\n");
			AADSWebDriver.dnsPageAddDNSMapping(webDriver, "1.1.1.1","dns.tma.com.vn");
			AADSWebDriver.dnsPageVerifyDNSMapping(webDriver, "1.1.1.1","dns.tma.com.vn", true);
			AADSWebDriver.dnsPageDeleteDNSMapping(webDriver, "dns.tma.com.vn");
			AADSWebDriver.dnsPageVerifyDNSMapping(webDriver, "1.1.1.1",	"dns.tma.com.vn", false);

			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_016_IE - Failed with Exception:" + exception
					+ "...\n");
			fail("Browsers_016_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_016_IE - test completed\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		// webDriver.get(aadsData.AADS_SERVER_ADDRESS);
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
