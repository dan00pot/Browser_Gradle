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

public class Browsers_Firefox_015 {
	
/*#################################################################################
 * Browsers_Firefox_015	Dynamic Configuration Tab - Configuration - Retrieve setting
	"Verify that admin can retrieve configuration from user and group
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Dynamic Configuration -> Configuration
	3. From Search Criteria, select User then input username -> click Retrieve 
	4. From Search Criteria, select Group then input group -> click Retrieve 
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Configuration page is displayed clearly
	3. Configuration of inputted user is retrieved and displayed correctly
	4. Configuration of inputted group is retrieved and displayed correctly"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_015");
	String configurationName = "Browsers_015_Firefox";

	@Before
	public void beforetestBrowsers_Firefox_015() throws Exception {
		logger.info("beforetest Browsers_Firefox_015 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_015 completed...\n");
	}

	@Test
	public void AADS_Browsers_015() throws Exception {
		logger.info("Browsers_Firefox_015 - Starting\n");
		try {
			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			AADSWebDriver.loginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Configuration Page
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Dynamic Configuration");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");
			Thread.sleep(3000);

			// Step 3-4
			AADSWebDriver.configurationPageSettingVariable(webDriver, "User", "EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver, "Group", "EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver, "Global", "EWSSSO", true, "1");
			AADSWebDriver.configurationPageSettingVariable(webDriver, "Platform", "EWSSSO", true, "1");
			AADSWebDriver.configurationPageAddNewConfig(webDriver,	 configurationName);
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver, configurationName);
			AADSWebDriver.configurationPagePublishUserIncludeFlatform(webDriver,aadsData.AADS_USER_1_GROUP_CN, aadsData.AADS_USER_1_NAME,"iOS");
			 
			Thread.sleep(3000);
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Dynamic Configuration");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Configuration");
			Thread.sleep(3000);
			AADSWebDriver.configurationPageRetriveUserData(webDriver,aadsData.AADS_USER_1_NAME);
			
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Dynamic Configuration");
			Thread.sleep(3000);
			AADSWebDriver.navigateToFeaturesPage(webDriver,"Configuration");
			Thread.sleep(3000);
			AADSWebDriver.configurationPageRetriveGroup(webDriver,aadsData.AADS_USER_GROUP);
			assertTrue(true);
		} catch (Exception exception) {
			logger.error("Browsers_Firefox_015 - Failed with Exception:" + exception
					+ "...\n");
			fail("Browsers_Firefox_015 - Failed - Exception occurs: "
					+ exception.toString());
		}
		
		logger.info("Browsers_Firefox_015 - test completed\n");
	}

	@After
	public void tearDown(){
		logger.info("tearDown starting...\n");
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Dynamic Configuration");
//			AADSWebDriver.navigateToFeaturesPage(webDriver, "Configuration");
			Thread.sleep(2000);
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,configurationName);
			AADSWebDriver.configurationPageDeleteConfiguration(webDriver,configurationName);
			AADSWebDriver.configurationPageSelectConfigurationUser(webDriver,aadsData.AADS_USER_1_STANDARD_CONFIG);
			AADSWebDriver.configurationPagePublishUser(webDriver,aadsData.AADS_USER_1_GROUP,aadsData.AADS_USER_1_NAME);
			AADSWebDriver.logoutAADSMainPage(webDriver);
			webDriver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("tearDown completed...\n");
	}
}
