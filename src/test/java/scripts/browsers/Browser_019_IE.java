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

public class Browser_019_IE {
	
/*#################################################################################
 * Browser_019_IE	Web Deployment Tab - Add appcast item
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

	final static Logger logger = LogManager.getLogger("Browser_019_IE");

	@Before
	public void beforetestBrowser_019_IE() throws Exception {
		logger.info("beforetest Browser_019_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		webDriver.manage().window().maximize();
		logger.info("beforetest Browser_019_IE completed...\n");
	}

	@Test
	public void Browsers_019_IE() throws Exception {
		logger.info("Browsers_019_IE - starting...\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,
					aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Web Deployment");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Deployment");

			AADSWebDriver.deploymentPageAddAppcastItem(webDriver,	"Avaya Communicator", aadsData.AADS_APPCAST_FILE_NAME,	aadsData.AADS_APPCAST_FILE_NAME,aadsData.AADS_APPCAST_VERSION, "windows",aadsData.AADS_USER_1_NAME, aadsData.AADS_USER_PWD, "https://aads.aam1.com:443/acs/resources/webdeployment/downloads/","IE");
			logger.info("Browsers_019_IE - Passed\n");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_019_IE - Failed with Exception:" + exception
					+ "...\n");
			fail("Browsers_019_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_019_IE - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
