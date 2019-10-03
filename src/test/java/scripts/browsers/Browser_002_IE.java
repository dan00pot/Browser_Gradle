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

public class Browser_002_IE {

/*##################################################################################
 * Browser_002_IE	Login Admin UI using incorrect user and password

 "Verify that user can't login in the invalid case of user or password  

	*Procedure:
	1. Go to https://<aads fqdn>:8445/admin/
	2. Input valid user and invalid password then click Sign In button
	3. Input valid user and blank password then click Sign In button
	4. Input invalid user and valid password then click Sign In button
	5. Input blank user and valid password then click Sign In button
	6. Login with correct user and password
	7. Click logoff button to log out 
	
	*Expected Result:
	1. AADS admin UI login page is displayed clearly without errors
	2. 3. 4. 5. User can log into Admin UI with announcement ""Invalid username or password. Please try again.""
	6. Log into AdminUI successfully
	7. Back to login page  "
#####################################################################################*/
	
	static WebDriver webDriver;
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	Selenium selenium = new Selenium();
	DriverManagement driverMgnt = new DriverManagement();
	aadsData aadsData = new aadsData();
	

	final static Logger logger = LogManager.getLogger("Browser_002_IE");

	@Before
	public void beforetestAADS_Browsers_001_IE() throws Exception {
		logger.info("Before test Browser_002_IE starting...\n");
		webDriver = driverMgnt.createIEDriver();
		logger.info("Before test Browser_002_IE completed...\n");
	}

	@Test
	public void AADS_Browsers_002() throws Exception {
		logger.info("AADS_Browsers_002_IE- starting...\n");

		try {
			// Go to aads web page
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);
			// Input valid user and invalid password
			boolean n = AADSWebDriver.invalidLoginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER,	aadsData.AADS_USER_PWD_INVALID);
			assertTrue(n);
			// Input valid user and blank password
			n = AADSWebDriver.invalidLoginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER,	aadsData.AADS_USER_PWD_BLANK);
			assertTrue(n);
			// Input invalid user and valid password
			n = AADSWebDriver.invalidLoginAADSMainPage(webDriver,aadsData.AADS_USER_NAME_INVALID, aadsData.AADS_USER_PWD);
			assertTrue(n);
			// Input blank user and valid password
			n = AADSWebDriver.invalidLoginAADSMainPage(webDriver,aadsData.AADS_USER_NAME_BLANK, aadsData.AADS_USER_PWD);
			assertTrue(n);
			// Login with correct user and password
			n = AADSWebDriver.loginAADSMainPage(webDriver,aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			assertTrue(n);
			logger.info("AADS_Browsers_002_IE - Passed\n");


		} catch (Exception exception) {
			AADSWebDriver.logoutAADSMainPage(webDriver);
			logger.error("AADS_Browsers_002_IE - Failed with Exception:"
					+ exception + "...\n");
			fail("AADS_Browsers_002_IE - Failed - Exception occurs: "
					+ exception.toString());
		}
		logger.info("AADS_Browsers_002_IE - completed...\n");
	}

	@After
	public void tearDown() throws Exception {
		logger.info("tearDown starting...\n");
		AADSWebDriver.logoutAADSMainPage(webDriver);
		webDriver.quit();
		logger.info("tearDown completed...\n");
	}
}
