package scripts.browsers;

import java.util.ArrayList;

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

public class Browsers_Chrome_025 {
	
/*#################################################################################
 * Browsers_Chrome_025	Open in another new
	"Verify that user can open aads AdminUI in new tabs
	
	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Login Admin UI by correct username and password
	3. Open and lauch AADS adminUI in 4 new window of browser
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. User can input username and password and login successfully
	3. AdminUI are lauched successfully in others tab and already logged in, current Window still working normally"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Chrome_025");

	@Before
	public void beforetestBrowsers_Chrome_025() throws Exception {
		logger.info("beforetest Browsers_Chrome_025 starting...\n");
		webDriver = driverMgnt.createChromeDriver();
		logger.info("beforetest Browsers_Chrome_025 completed...\n");
	}

	@Test
	public void Browsers_025_Chrome() throws Exception {
		logger.info("Browsers_025_Chrome - Starting\n");
		try {

			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,
					aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			Thread.sleep(3000);
			// webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"n");
			// webDriver.switchTo().window(webDriver.getWindowHandles().iterator().next());
			AADSWebDriver.openNewTab(webDriver);
			Thread.sleep(3000);
			ArrayList<String> tabs = new ArrayList<String>(
					webDriver.getWindowHandles());
			webDriver.switchTo().window(tabs.get(1));
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.navigateToFeaturesPage(webDriver,
					"Cluster Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Cluster Nodes");
			AADSWebDriver.clusterConfigClusterNodeVerify(webDriver, 3,	aadsData.AADS_CLUSTER_NODES_CLUSTER_UPDATE);

		} catch (Exception exception) {
			logger.error("Browsers_025_Chrome - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_025_Chrome - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_025_Chrome - test completed\n");
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
