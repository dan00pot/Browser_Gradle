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

public class Browsers_Firefox_022 {
	
/*#################################################################################
 * Browsers_Firefox_022	Pictures Tab
	"Verify that Picture Configuration page work normally
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Pictures -> Configuration
	3. Check Allow users to upload their own photo then Save
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without error
	2.Pictures Configuration page is displayed clearly
	3. Option can be checked and save successfully without error"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_022_Firefox");

	@Before
	public void beforetestBrowsers_022_Firefox() throws Exception {
		logger.info("beforetest Browsers_022_Firefox starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_022_Firefox completed...\n");
	}

	@Test
	public void Browsers_022_Firefox() throws Exception {
		logger.info("Browsers_022_Firefox - Starting\n");
		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Pictures");
			// AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");
			 
			// Step 3-4
			logger.info("Browsers_022_Firefox - Starting\n");
			AADSWebDriver.selectAllowUserUploadPictureCheckbox(webDriver, true);
			AADSWebDriver.verifyMessageLabel(webDriver,	"Settings were published successfully");
			AADSWebDriver.selectAllowUserUploadPictureCheckbox(webDriver, false);
			AADSWebDriver.verifyMessageLabel(webDriver,	"Settings were published successfully");
		} catch (Exception exception) {
			logger.error("Browsers_022_Firefox - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_022_Firefox - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_022_Firefox - test completed\n");
	}

	@After
	public void tearDown(){
		logger.info("tearDown starting...\n");
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
