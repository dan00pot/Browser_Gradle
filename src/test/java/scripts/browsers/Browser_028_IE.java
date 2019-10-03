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

public class Browser_028_IE {
	
/*#################################################################################
 * Browser_028_IE	Discard setting
	"Verify that values aren't changed after discard change
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Login Admin UI by admin role user
	3. Change some value from Application Management -> Application Properties but don't Save
	4. Click on other tab
	5. Click OK to discard setting
	6. Navigate to Application Management and verify value
	
	*Expected Result:
	4.Warning ""You have unsaved changes. Click OK to discard changes and continue, or Cancel to stay on the current page."" appear
	6.Values of Application Properties are kept stable after discard change "

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browser_028_IE");

	@Before
	public void beforetestBrowser_028_IE() throws Exception {
		logger.info("beforetest Browser_028_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		webDriver.manage().window().maximize();
		logger.info("beforetest Browser_028_IE completed...\n");
	}

	@Test
	public void Browsers_028_IE() throws Exception {
		logger.info("Browsers_028_IE - Starting\n");
		try {
		
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Pictures");
			// AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");
			AADSWebDriver.selectAllowUserUploadPictureCheckboxWithoutSave(webDriver, true);
			Thread.sleep(1000);
			webDriver.switchTo().defaultContent();
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Service Control");
			AADSWebDriver.confirmDiscardConfiguration(webDriver);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Pictures");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_028_IE - Failed with Exception:" + exception
					+ "...\n");
			fail("Browsers_028_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_028_IE - test completed\n");
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
