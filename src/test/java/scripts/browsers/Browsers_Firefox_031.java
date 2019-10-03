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

public class Browsers_Firefox_031 {

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_031");

	@Before
	public void beforetestBrowsers_Firefox_031() throws Exception {
		logger.info("beforetest Browsers_Firefox_031 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_031 completed...\n");
	}

	@Test
	public void AADS_Browsers_031() throws Exception {
		try {
			logger.info("Browsers_Firefox_031- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			// Navigate to Certificate Managerment -> Identity Certificates
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Security Settings");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Certificate Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Identity Certificates");
			// Import new signed certificate to keystore
			AADSWebDriver.serviceInterfacePageImportSecurityRole(webDriver,	"Firefox");
			Thread.sleep(8000);
			// Export certificate from keystore
			AADSWebDriver.serviceInterfacePageExportSecurityRole(webDriver,	"Firefox");
			Thread.sleep(2000);
			AADSWebDriver.logoutAADSMainPage(webDriver);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			Thread.sleep(2000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Certificate Management");
			Thread.sleep(2000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Identity Certificates");	
			Thread.sleep(2000);
			// Delete certificate from keystore
			AADSWebDriver.serviceInterfacePageDeleteSecurityRole(webDriver,	"Firefox");
			logger.info("Browsers_Firefox_031- Passed...\n");
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_031_Firefox - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_031_Firefox - Failed - Exception occurs: "
					+ exception.toString());
		}

		logger.info("AADS_Browsers_031_Firefox - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
