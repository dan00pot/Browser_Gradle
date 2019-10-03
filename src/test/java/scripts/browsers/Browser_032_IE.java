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

public class Browser_032_IE {

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browser_032_IE");

	@Before
	public void beforetestBrowser_032_IE() throws Exception {
		logger.info("beforetest Browser_032_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest Browser_032_IE completed...\n");
	}

	@Test
	public void Browser_032_IE() throws Exception {
		try {
			logger.info("Browser_032_IE- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			// Navigate to Certificate Managerment -> Identity Certificates
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Security Settings");
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Certificate Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Truststore");
			Thread.sleep(1000);
			// Export certificate from truststore
			AADSWebDriver.truststorePageExportSecurityRoleIE(webDriver);

			logger.info("Browser_032_IE- Passed...\n");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browser_032_IE - Failed with Exception:"
					+ exception + "...\n");
			fail("Browser_032_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_030_Firefox - completed...\n");
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
