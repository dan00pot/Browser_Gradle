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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import testData.aadsData;

public class Browser_025_IE {
	
/*#################################################################################
 * Browser_025_IE	Open in another new
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

	final static Logger logger = LogManager.getLogger("AADS_Browsers_001_IE");

	@Before
	public void beforetestAADS_Browsers_001_IE() throws Exception {
		logger.info("beforetest AADS_Browsers_001_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest AADS_Browsers_001_IE completed...\n");
	}

	@Test
	public void Browsers_025_Firefox() throws Exception {
		logger.info("Browsers_025_Firefox - Starting\n");
		try {

			// Login AADS
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);

			webDriver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "n");

			Thread.sleep(3000);

			//webDriver.get("http://youtube.com/");
			Thread.sleep(5000);
			webDriver.switchTo().defaultContent();
			webDriver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "n");

			webDriver.switchTo().defaultContent();
			String parent = webDriver.getWindowHandle();
			webDriver.switchTo().defaultContent();
			for (String winHandle : webDriver.getWindowHandles()) {
				webDriver.switchTo().defaultContent();
				webDriver.switchTo().window(winHandle);
				if (!winHandle.equals(parent)) {
					webDriver.get(aadsData.AADS_SERVER_ADDRESS);
				}
			}
			webDriver.switchTo().window(parent);
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);

			webDriver.switchTo().defaultContent();
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			

			// webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Cluster Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Cluster Nodes");
			AADSWebDriver.clusterConfigClusterNodeVerify(webDriver, 3,	aadsData.AADS_CLUSTER_NODES_CLUSTER_UPDATE);

			assertTrue(true);

		} catch (Exception exception) {
			logger.error("Browsers_025_Firefox - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_025_Firefox - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_025_Firefox - test completed\n");
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
