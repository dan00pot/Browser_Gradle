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

public class Browser_030_IE {

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browser_030_IE");

	@Before
	public void beforetestBrowser_030_IE() throws Exception {
		logger.info("beforetest Browser_030_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest Browser_030_IE completed...\n");
	}

	@Test
	public void AADS_Browsers_030() throws Exception {
		try {
			logger.info("AADS_Browsers_030_IE- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			// Navigate to Certificate Managerment -> Identity Certificates
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Security Settings");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Certificate Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Identity Certificates");
			// Create new CSR
			AADSWebDriver.createNewCSRBrowserIE(webDriver);
			webDriver.switchTo().defaultContent();
			AADSWebDriver.logoutAADSMainPage(webDriver);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Security Settings");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Certificate Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Identity Certificates");
			// Delete CSR
			AADSWebDriver.deleteCSR(webDriver, "IE");
			logger.info("AADS_Browsers_030_IE- Passed...\n");
		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_030_IE - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_030_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_030_IE - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
