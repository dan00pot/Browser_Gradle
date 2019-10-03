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

public class Browsers_Firefox_018 {
	
/*#################################################################################
 * Browsers_Firefox_018	Dynamic Configuration Tab - View Published Setting
	"Verify that View Published Settings page working normally without errors
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Dynamic Configuration -> View Published Settings
	3. Select category User and value to view published settings
	4. Select category Group and value to view published settings
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. View Published Settings page is displayed clearly
	3. Selected user's settings are displayed correctly
	4. Selected group's settings are displayed correctly"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	String configurationName = "Browsers_Firefox_018";
	final static Logger logger = LogManager.getLogger("Browsers_Firefox_018");

	@Before
	public void beforetestBrowsers_Firefox_018() throws Exception {
		logger.info("beforetest Browsers_Firefox_018 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_018 completed...\n");
	}

	@Test
	public void Browsers_018_Firefox() throws Exception {
		logger.info("Browsers_018_Firefox - Starting\n");
		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Dynamic Configuration");
			Thread.sleep(1000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");

			// Create configurations and publish
			logger.info("Browsers_018_IE - Starting\n");
			AADSWebDriver.configurationPageSettingVariable(webDriver, "User","EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver, "Group","EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver, "Global","EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver,"Platform", "EWSSSO", true, "1");
			AADSWebDriver.configurationPageAddNewConfig(webDriver,configurationName);
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,configurationName);
			AADSWebDriver.configurationPagePublishUserIncludeFlatform(webDriver,aadsData.AADS_USER_1_GROUP_CN, aadsData.AADS_USER_1_NAME, "iOS");
			webDriver.switchTo().defaultContent();
			
			// View published settings
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Dynamic Configuration");
			Thread.sleep(1000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"View Published Settings");
			AADSWebDriver.viewPublishedSettingsSelectCategory(webDriver,"Group", aadsData.AADS_USER_GROUP);
			if (AADSWebDriver.viewPublishedSettingsVerify(webDriver, "EWSSSO",	true, "1")) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
			AADSWebDriver.viewPublishedSettingsSelectCategory(webDriver,"User", aadsData.AADS_USER_1_NAME);
			if (AADSWebDriver.viewPublishedSettingsVerify(webDriver, "EWSSSO",	true, "1")) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_Firefox_018 - Failed with Exception:" + exception
					+ "...\n");
			fail("Browsers_Firefox_018 - Failed - Exception occurs: "
					+ exception.toString());
		} 
		logger.info("Browsers_Firefox_018 - test completed\n");
	}

	@After
	public void tearDown() {
		logger.info("tearDown starting...\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Dynamic Configuration");
//			AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");
			Thread.sleep(2000);
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,configurationName);
			AADSWebDriver.configurationPageDeleteConfiguration(webDriver,configurationName);
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,aadsData.AADS_USER_1_STANDARD_CONFIG);
			AADSWebDriver.configurationPagePublishUser(webDriver,aadsData.AADS_USER_1_GROUP_CN ,aadsData.AADS_USER_1_NAME);
			AADSWebDriver.logoutAADSMainPage(webDriver);
			Thread.sleep(1000);
			webDriver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

		
		logger.info("tearDown completed...\n");
	}
}
