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

public class Browsers_Firefox_011 {
	
/*#################################################################################
 * Browsers_Firefox_011	Cluster Configuration
"Verify thatCluster Nodes tab is displayed clearly, can add new host to host list 

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Navigate to Cluster Configuration -> Cluster Nodes
	
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. Cluster Nodes page is displayed clearly without errors, Node information and status are displayed correctly
	"

 *################################################################################# */

	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("Browsers_Firefox_011");

	@Before
	public void beforetestBrowsers_Firefox_011() throws Exception {
		logger.info("beforetest Browsers_Firefox_011 starting...\n");
		webDriver = driverMgnt.createFFDriver();
		logger.info("beforetest Browsers_Firefox_011 completed...\n");
	}

	@Test
	public void AADS_Browsers_011() throws Exception {
		try {
			logger.info("Browsers_Firefox_011- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Cluster Configuration -> Cluster Nodes
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Cluster Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Cluster Nodes");
			AADSWebDriver.clusterConfigClusterNodeVerify(webDriver, 3,	aadsData.AADS_CLUSTER_NODES_CLUSTER_UPDATE);
			logger.info("Browsers_Firefox_011 - Passed...\n");
			assertTrue(true);

		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("Browsers_Firefox_011 - Failed with Exception:"
					+ exception + "...\n");
			fail("Browsers_Firefox_011 - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("Browsers_Firefox_011 - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
