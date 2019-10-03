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

public class Browsers_Chrome_031 {

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_031");

	@Before
	public void beforetestAADS_Browsers_001_IE() throws Exception {
		logger.info("beforetest Browsers_Chrome_031 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_031 completed...\n");
	}

	@Test
	public void AADS_Browsers_031() throws Exception {
		try {
			logger.info("Browsers_Chrome_031- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,
					aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			// Navigate to Certificate Managerment -> Identity Certificates
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Security Settings");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Certificate Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Identity Certificates");
			// Import new signed certificate to keystore
			AADSWebDriver.serviceInterfacePageImportSecurityRole(webDriver,	"Chrome");
			Thread.sleep(8000);
			// Export certificate from keystore
			AADSWebDriver.serviceInterfacePageExportSecurityRole(webDriver,	"Chrome");
			Thread.sleep(2000);
			AADSWebDriver.logoutAADSMainPage(webDriver);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			Thread.sleep(2000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Certificate Management");
			Thread.sleep(2000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Identity Certificates");	
			Thread.sleep(2000);
			// Delete certificate from keystore
			AADSWebDriver.serviceInterfacePageDeleteSecurityRole(webDriver,	"IE");
			logger.info("Browsers_Chrome_031- Passed...\n");
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_031_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_031_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}

		logger.info("AADS_Browsers_031_Chrome - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
