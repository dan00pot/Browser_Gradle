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

public class Browsers_Chrome_027 {
	
/*#################################################################################
 * Browsers_Chrome_027	About button
	"Verify that user can get system and licenses information from About
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Login Admin UI by admin role user
	3. Click About button and verify system information
	4. Click Third Party Licenses and verify licenses
	5. Logoff AdminUI
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. User can input username and password and login successfully
	3. About popup is displayed, system information is displayed correctly
	4. Third Party Licenses displayed correctly
	5. AdminUI back to login page "

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_027");
	String license = "This software includes third-party component software distributed by Avaya pursuant to specific third-party license agreements, whose terms and conditions are as set forth in the license agreement for this software and/or the applicable End User License Agreement. Below, please find the acknowledgments required by such third-party licenses";
	String version = aadsData.AADS_SERVER_VERSION;

	@Before
	public void beforetestBrowsers_Chrome_027() throws Exception {
		logger.info("beforetest Browsers_Chrome_027 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_027 completed...\n");
	}

	@Test
	public void Browsers_027_Chrome() throws Exception {
		logger.info("Browsers_027_Chrome - Starting\n");
		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.aboutButtonVerifyTabContent(webDriver, "About", version);
			AADSWebDriver.aboutButtonVerifyTabContent1(webDriver, "License", license);
			assertTrue(true);

		} catch (Exception exception) {
			logger.error("Browsers_027_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_027_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_027_Chrome - test completed\n");
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
