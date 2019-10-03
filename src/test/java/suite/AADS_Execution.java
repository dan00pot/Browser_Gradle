package suite;

import libs.common.DriverManagement;
import scripts.browsers.*;
import testData.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;



import io.appium.java_client.android.AndroidDriver;

@RunWith(Suite.class)
@Suite.SuiteClasses({
Browser_001_IE.class,Browser_002_IE.class,
//Browser_003_IE.class,Browser_004_IE.class,Browser_005_IE.class,Browser_006_IE.class,Browser_007_IE.class,Browser_008_IE.class,Browser_009_IE.class,
Browser_010_IE.class,Browser_011_IE.class,Browser_012_IE.class,Browser_013_IE.class,Browser_014_IE.class,Browser_015_IE.class,

Browser_016_IE.class,Browser_017_IE.class,Browser_018_IE.class,Browser_019_IE.class,Browser_020_IE.class,
Browser_021_IE.class,Browser_022_IE.class,Browser_023_IE.class,Browser_024_IE.class,Browser_025_IE.class,
Browser_026_IE.class,Browser_027_IE.class,Browser_028_IE.class,

Browsers_Chrome_001.class,Browsers_Chrome_002.class,
//Browsers_Chrome_003.class,Browsers_Chrome_004.class,Browsers_Chrome_005.class,Browsers_Chrome_006.class,Browsers_Chrome_007.class,Browsers_Chrome_008.class,Browsers_Chrome_009.class,
Browsers_Chrome_010.class,Browsers_Chrome_011.class,Browsers_Chrome_012.class,Browsers_Chrome_013.class,Browsers_Chrome_014.class,Browsers_Chrome_015.class,

Browsers_Chrome_016.class,Browsers_Chrome_017.class,Browsers_Chrome_018.class,Browsers_Chrome_019.class,Browsers_Chrome_020.class,
Browsers_Chrome_021.class,Browsers_Chrome_022.class,
//Browsers_Chrome_023.class,
Browsers_Chrome_024.class,Browsers_Chrome_025.class,
Browsers_Chrome_026.class,Browsers_Chrome_027.class,Browsers_Chrome_028.class,
	
Browsers_Firefox_001.class,Browsers_Firefox_002.class,
//Browsers_Firefox_003.class,Browsers_Firefox_004.class,Browsers_Firefox_005.class,Browsers_Firefox_006.class,Browsers_Firefox_007.class,Browsers_Firefox_008.class,Browsers_Firefox_009.class,
Browsers_Firefox_010.class,Browsers_Firefox_011.class,Browsers_Firefox_012.class,Browsers_Firefox_013.class,Browsers_Firefox_014.class,Browsers_Firefox_015.class,

Browsers_Firefox_016.class,Browsers_Firefox_017.class,Browsers_Firefox_018.class,Browsers_Firefox_019.class,Browsers_Firefox_020.class,
Browsers_Firefox_021.class,Browsers_Firefox_022.class,
//Browsers_Firefox_023.class,
Browsers_Firefox_024.class,Browsers_Firefox_025.class,Browsers_Firefox_026.class,Browsers_Firefox_027.class,Browsers_Firefox_028.class

})

/**
 This is the test suite for All written scripts

 */
public class AADS_Execution {
	final static Logger logger = LogManager.getLogger("DriverManagement Keywords");
	public static AndroidDriver androidClientDriver;

	
	@BeforeClass
	public static void setUpSuite() throws Exception {
		logger.info("setUpSuite - startings");
		DriverManagement driverKws = new DriverManagement();

		logger.info("setUpSuite - completed");
		logger.info("********************************************************");
	}

	@AfterClass
	public static void tearDownSuite() {
		logger.info("********************************************************");
		logger.info("tearDownSuite - clearing cookies");
		//winClient2Driver.quit();
		//winClientDriver.quit();
		//androidClientDriver.quit();
		//iOSClientDriver.quit();
		logger.info("tearDownSuite - completed");
	}

}
