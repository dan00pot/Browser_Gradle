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

public class Browsers_Firefox_007 {
	
/*#################################################################################
* Browsers_Firefox_007	Server Connections - LDAP Configuration - edit Directory
"Verify that user can edit Directory configuration

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Server Connections ->  LDAP Configuration -> Enterprise Directory
	3. Choose directory
	4. Edit some field's value then Save -> OK
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Enterprise Directory page is displayed clearly without error
	3. DIrectory configuration is displayed successfully 
	4. Value can be editted and save without error "

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_007");

	@Before
	public void beforetestBrowsers_Firefox_007() throws Exception {
		logger.info("beforetest Browsers_Firefox_007 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_007 completed...\n");
	}

	@Test
	public void AADS_Browsers_007() throws Exception {

		try {
			logger.info("Browsers_Firefox_007- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Server Connections -> LDAP Configuration ->
			// Enterprise Directory
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Server Connections");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"LDAP Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Enterprise Directory");
			// Edit some field of LDAP directory --> save
			AADSWebDriver.ldapConfigEditDirectory(webDriver, "IE");
			logger.info("Browsers_Firefox_007 - Passed...\n");
			assertTrue(true);

		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_007_Firefox - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_007_Firefox - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_007_Firefox - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
