/*package testData;

import excel.ExcelData;

*//**
 * This class contains data for network configuration when launching clients.
 *//*
public class NetworkData {
	ExcelData dataExcel = new ExcelData();
	
	//Data for Windows App
	String winiumUrl		 =  dataExcel.windowsData1();
	String winiumUrl2		 =  dataExcel.windowsData2();
	String winiumUrl3		 =  dataExcel.windowsData3();
	String winiumUrlOneX	 =  dataExcel.windowsData4();
	String appPath			 =  dataExcel.windowsData5();
	String appPath64		 =  dataExcel.windowsData6();
	String appPath1X		 =  dataExcel.windowsData7();
	String robotilServer	 =  dataExcel.windowsData8();
	String robotilServer2	 =  dataExcel.windowsData9();
	String robotilServer3	 =  dataExcel.windowsData10();
	String appPathPutty		 =	dataExcel.windowsData11();
	String winiumUrl4		 =	dataExcel.windowsData12();
	
	public String WINIUM_URL			=	winiumUrl;
	public String WINIUM_URL_2			=	winiumUrl2;
	public String WINIUM_URL_3			=	winiumUrl3;
	public String WINIUM_URL_1X			=	winiumUrlOneX;
	public String APP_PATH				= 	appPath;
	public String APP_PATH_64			= 	appPath64;
	public String APP_PATH_1X			= 	appPath1X;
	public String ROBOTIL_SERVER		= 	robotilServer;
	public String ROBOTIL_SERVER_2		= 	robotilServer2;
	public String ROBOTIL_SERVER_3		= 	robotilServer3;
	public String APP_PATH_PUTTY		=	appPathPutty;
	public String APP_PATH_1X_64		= 	"C:\\Program Files (x86)\\Avaya\\Avaya one-X Communicator\\onexcui.exe";
	public String WINIUM_URL_4			= 	winiumUrl4;
	
	
	//Data for Android App
	String appiumServerAddress		 	=  dataExcel.androidData1();
	String appiumServerPort		 		=  dataExcel.androidData2();
	String mobileUDID			 		=  dataExcel.androidData3();
	String deviceName		 			=  dataExcel.androidData4();
	String platformName				 	=  dataExcel.androidData5();
	String platformVersion		 		=  dataExcel.androidData6();
	String appPackage		 			=  dataExcel.androidData7();
	String appActivity		 			=  dataExcel.androidData8();
	String timeout		 				=  dataExcel.androidData9();
	String appiumServerAddressRemote 	=  dataExcel.androidData10();
	String appiumServerPortRemote 		=  dataExcel.androidData11();
	String mobileUDIDRemote		 		=  dataExcel.androidData12();
	String deviceNameRemote	 			=  dataExcel.androidData13();
	String platformNameRemote		 	=  dataExcel.androidData14();
	String platformVersionRemote 		=  dataExcel.androidData15();
	String appPackageRemote	 			=  dataExcel.androidData16();
	String appActivityRemote 			=  dataExcel.androidData17();
	
	public String APPIUM_SERVER_ADDRESS								= appiumServerAddress;
	public String APPIUM_SERVER_PORT								= appiumServerPort;
	public String MOBILE_UDID										= mobileUDID;
	public String DEVICE_NAME										= deviceName;
	public String PLATFORM_NAME										= platformName;
	public String PLATFORM_VERSION									= platformVersion;
	public String APP_PACKAGE										= appPackage;
	public String APP_ACTIVITY										= appActivity;
	public String TIMEOUT											= timeout;
	public String APPIUM_SERVER_ADDRESS_REMOTE						= appiumServerAddressRemote;
	public String APPIUM_SERVER_PORT_REMOTE							= appiumServerPortRemote;
	public String MOBILE_UDID_REMOTE								= mobileUDIDRemote;
	public String DEVICE_NAME_REMOTE								= deviceNameRemote;
	public String PLATFORM_NAME_REMOTE								= platformNameRemote;
	public String PLATFORM_VERSION_REMOTE							= platformVersionRemote;
	public String APP_PACKAGE_REMOTE								= appPackageRemote;
	public String APP_ACTIVITY_REMOTE								= appActivityRemote;
	
	//Data for iOS App
	
	String appiumServerAddressIOS		=  dataExcel.iOS1();
	String mobileUDIDIOS		 		=  dataExcel.iOS2();
	String deviceNameIOS		 		=  dataExcel.iOS3();
	String platformNameIOS		 		=  dataExcel.iOS4();
	String platformVersionIOS	 		=  dataExcel.iOS5();
	String appiumVersion		 		=  dataExcel.iOS6();
	String xcodeConfigFileValue	 		=  dataExcel.iOS7();
	String appBundleID		 	 		=  dataExcel.iOS8();
	
	String appiumServerAddressIOS2nd	=  dataExcel.iOS9();
	String mobileUDIDIOS2nd		 		=  dataExcel.iOS10();
	String deviceNameIOS2nd		 		=  dataExcel.iOS11();
	String platformNameIOS2nd	 		=  dataExcel.iOS12();
	String platformVersionIOS2nd 		=  dataExcel.iOS13();
	String appiumVersion2nd		 		=  dataExcel.iOS14();
	String xcodeConfigFileValue2nd 		=  dataExcel.iOS15();
	String appBundleID2nd	 	 		=  dataExcel.iOS16();
	
	public String APPIUM_SERVER_ADDRESS_IOS							= appiumServerAddressIOS;
	public String MOBILE_UDID_IOS									= mobileUDIDIOS; //udid of your testing device
	public String DEVICE_NAME_IOS									= deviceNameIOS;
	public String PLATFORM_NAME_IOS									= platformNameIOS;
	public String PLATFORM_VERSION_IOS								= platformVersionIOS;	
	public String APPIUM_VERSION									= appiumVersion;
	public String xcodeConfigFile									= xcodeConfigFileValue;
	public String APP_BUNDLE_ID										= appBundleID;

	public String APPIUM_SERVER_ADDRESS_IOS_2ND						= appiumServerAddressIOS2nd;
	public String MOBILE_UDID_IOS_2ND								= mobileUDIDIOS2nd;
	public String DEVICE_NAME_IOS_2ND								= deviceNameIOS2nd;
	public String PLATFORM_NAME_IOS_2ND								= platformNameIOS2nd;
	public String PLATFORM_VERSION_IOS_2ND							= platformVersionIOS2nd;	
	public String APPIUM_VERSION_2ND								= appiumVersion2nd;
	public String xcodeConfigFile_2nd								= xcodeConfigFileValue2nd;
	public String APP_BUNDLE_ID_2ND									= appBundleID2nd;
	
	// Network Configuration for Windows Client
	public String WINIUM_URL_3 										= "http://10.255.249.14:9999";
	
	public String WINIUM_URL_2										= "http://10.255.249.6:9999";
	public String WINIUM_URL 										= "http://10.255.249.14:9999";
	public String WINIUM_URL_1X 									= "http://10.255.249.6:9999";
	
	public String APP_PATH 											= "C:\\Program Files\\Avaya\\Avaya Equinox\\Avaya Equinox.exe";
//	public String APP_PATH_1X										= "C:\\Program Files (x86)\\Avaya\\Avaya Equinox\\Avaya Equinox.exe";
//	public String APP_PATH 											= "C:\\Program Files\\Notepad++\\notepad++.exe";
	public String APP_PATH_1X										= "C:\\Program Files (x86)\\Avaya\\Avaya one-X Communicator\\onexcui.exe"; 
	// Network Configuration for Android Client
	public String APPIUM_SERVER_ADDRESS								= "127.0.0.1";
	public String APPIUM_SERVER_PORT								= "4723";
	public String MOBILE_UDID										= "LGH818de48b2c1"; //udid of your testing device
	public String DEVICE_NAME										= "LG G4";
	public String PLATFORM_NAME										= "ANDROID";
	public String PLATFORM_VERSION									= "6.0";
	public String APP_PACKAGE										= "com.avaya.android.flare";
	public String APP_ACTIVITY										= "com.avaya.android.flare.MainActivity";
	public String TIMEOUT											= "30000";

//	public String APPIUM_SERVER_ADDRESS								= "127.0.0.1";
//	public String APPIUM_SERVER_PORT								= "4723";
//	public String MOBILE_UDID										= "0815f825e84f2401"; //udid of your testing device
//	public String DEVICE_NAME										= "Samsung S6";
//	public String PLATFORM_NAME										= "ANDROID";
//	public String PLATFORM_VERSION									= "7.0";
//	public String APP_PACKAGE										= "com.avaya.android.flare";
//	public String APP_ACTIVITY										= "com.avaya.android.flare.MainActivity";
//	public String TIMEOUT											= "30000";
	
	// Network Configuration for IOS Client
	public String APPIUM_SERVER_ADDRESS_IOS							= "10.255.253.107";
	public String MOBILE_UDID_IOS									= "8cd287cd04f67ac56ab3627c0cf185e8b779db77"; //udid of your testing device
	public String DEVICE_NAME_IOS									= "IPAD 4";
	public String PLATFORM_NAME_IOS									= "iOS";
	public String PLATFORM_VERSION_IOS								= "10.3.1";	
	public String APPIUM_VERSION									= "1.6.5";
	public String xcodeConfigFile									= "/Users/macbookpro/Desktop/xcodeConfig.xcconfig";
//	public String xcodeConfigFile									= "/Users/Msg/Desktop/xcodeConfig.xcconfig";
	public String APP_BUNDLE_ID										= "com.avaya.AvayaCommunicator";
	
	
	
	
}
*/