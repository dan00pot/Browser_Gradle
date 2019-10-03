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

public class Browser_011_IE {
	
/*#################################################################################
 * Browser_011_IE	Cluster Configuration
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

	final static Logger logger = LogManager.getLogger("AADS_Browsers_001_IE");

	@Before
	public void beforetestAADS_Browsers_001_IE() throws Exception {
		logger.info("beforetest AADS_Browsers_001_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("beforetest AADS_Browsers_001_IE completed...\n");
	}

	@Test
	public void AADS_Browsers_011() throws Exception {
		try {
			logger.info("AADS_Browsers_011_IE- starting...\n");
			// login AADS web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			AADSWebDriver.loginAADSMainPage(webDriver,	aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			// Navigate to Cluster Configuration -> Cluster Nodes
			AADSWebDriver.navigateToFeaturesPage(webDriver,	"Cluster Configuration");
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Cluster Nodes");
			AADSWebDriver.clusterConfigClusterNodeVerify(webDriver, 3,	aadsData.AADS_CLUSTER_NODES_CLUSTER_UPDATE);
			logger.info("AADS_Browsers_011_IE - Passed...\n");
			assertTrue(true);

		} catch (Exception exception) {
			logger.error("AADS_Browsers_011_IE - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_011_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_011_IE - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}

}
