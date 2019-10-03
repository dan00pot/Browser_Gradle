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

public class Browsers_Firefox_019 {
	
/*#################################################################################
 * Browsers_Firefox_019	Web Deployment Tab - Add appcast item
	"Verify that admin can add new appcast in Web Deployment  
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Web Deployment -> Deployment
	3. Input the required fields an upload file
	4. Save appcast
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Deployment page is displayed clearly
	3. File is chosen and uploaded succesfully without error
	4. New appcast is saved successfully"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_019");

	@Before
	public void beforetestBrowsers_Firefox_019() throws Exception {
		logger.info("beforetest Browsers_Firefox_019 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_019 completed...\n");
	}

	@Test
	public void Browsers_Firefox_019() throws Exception {
		logger.info("Browsers_Firefox_019 - starting...\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,
					aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Web Deployment");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Deployment");

			AADSWebDriver.deploymentPageAddAppcastItem(webDriver, "Avaya Communicator", aadsData.AADS_APPCAST_FILE_NAME,	aadsData.AADS_APPCAST_FILE_NAME,aadsData.AADS_APPCAST_VERSION, "windows",aadsData.AADS_USER_1_NAME, aadsData.AADS_USER_PWD, "https://aads.aam1.com:443/acs/resources/webdeployment/downloads/","Firefox");
			logger.info("Browsers_Firefox_019 - Passed\n");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_019_Firefox - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_019_Firefox - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_019_Firefox - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
