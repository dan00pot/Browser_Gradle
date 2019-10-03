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

public class Browser_014_IE {
	
/*#################################################################################
 * Browser_014_IE	Dynamic Configuration Tab - Configuration - Set and Publish setting
"Verify that admin set and publish configuration from Dynamic Configuration

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Dynamic Configuration -> Configuration
	3. From Setting, set some value for Global, Group, User, Flatform
	4. Save configuration
	5. Publish configuration
	6. Delete configuration
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Configuration page is displayed clearly
	3. Admin can set valid value for Global, Group, User and Flatform's fields successfully without errors
	4. Configuration is saved and displayed in Configuration dropbox
	5. Configuration is published successfully
	6. Configuration is deleted from configuration"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browser_014_IE");
	String configurationName = "Browsers_IE_014";

	@Before
	public void beforetestAADS_Browsers_001_IE() throws Exception {
		logger.info("beforetest Browsers_IE_014 starting...\n");
		webDriver = driverMgnt.createIEDriver();
		webDriver.manage().window().maximize();
		logger.info("beforetest Browsers_IE_014 completed...\n");
	}

	@Test
	public void Browsers_014_IE() throws Exception {
		logger.info("Browsers_014_IE - Starting\n");
		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Dynamic Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");

			
			// AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,
			// aadsData.AADS_USER_1_NAME);
			logger.info("Browsers_IE_014 - Starting\n");
			Thread.sleep(2000);
			AADSWebDriver.configurationPageSettingVariable(webDriver,"User","EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver,"Group","EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver,"Global","EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver,"Platform", "EWSSSO", true, "1");
			AADSWebDriver.configurationPageAddNewConfig(webDriver, configurationName);
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,configurationName);
			boolean result = AADSWebDriver.configurationPagePublishUserIncludeFlatform(webDriver,aadsData.AADS_USER_1_GROUP_CN, aadsData.AADS_USER_1_NAME, "iOS");
			assertTrue(result);
			// Verify by Test link
			// AADSWebDriver.verify46xx(webDriver,
			// "EWSSSO 1",aadsData.AADS_USER_1_NAME);

		} catch (Exception exception) {
			logger.error("Browsers_014_IE - Failed with Exception:" + exception
					+ "...\n");
			fail("Browsers_014_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_014_IE - test completed\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Dynamic Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver, configurationName);
			AADSWebDriver.configurationPageDeleteConfiguration(webDriver, configurationName);
			AADSWebDriver.logoutAADSMainPage(webDriver);
			webDriver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("tearDown completed...\n");
	}
}
