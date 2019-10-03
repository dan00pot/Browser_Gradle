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

public class Browsers_Firefox_032 {

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_032");

	@Before
	public void beforetestBrowsers_Firefox_032() throws Exception {
		logger.info("beforetest Browsers_Firefox_032 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_032 completed...\n");
	}

	@Test
	public void AADS_Browsers_032() throws Exception {
		try {
			logger.info("Browsers_Firefox_032- starting...\n");
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

			logger.info("Browsers_Firefox_032- Passed...\n");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("AADS_Browsers_032_Firefox - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_Firefox_032 - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_Firefox_032 - completed...\n");
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
