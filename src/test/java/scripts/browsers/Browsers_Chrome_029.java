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

public class Browsers_Chrome_029 {

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_029");

	@Before
	public void beforetestBrowsers_Chrome_029() throws Exception {
		logger.info("beforetest Browsers_Chrome_029 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_029 completed...\n");
	}

	@Test
	public void AADS_Browsers_029() throws Exception {
		try {
			logger.info("Browsers_Chrome_029- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.SECURITY_ROLE_USER, aadsData.SECURITY_ROLE_PWD);
			// Navigate to Certificate Managerment -> SMGR Certificates
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Security Settings");
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Certificate Management");
			AADSWebDriver.navigateToFeaturesPage(webDriver,"SMGR Certificates");
			AADSWebDriver.verifySmgrCertificateDisplayInfoCorrect(webDriver);
			logger.info("Browsers_Chrome_029- passed...\n");
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("AADS_Browsers_029_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_029_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_029_Chrome - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");

		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
