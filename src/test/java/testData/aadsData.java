package testData;

import excel.ExcelData;

public class aadsData {
	ExcelData excelData = new ExcelData();
	ExcelData setting = new ExcelData();

	public String lab = excelData.getTestSetting("Setting", 1, 1);
	public String user = excelData.getTestSetting("Setting", 2, 1);

	public String AADS_SERVER = excelData.getLabInfo(lab, 2, 1);

	public String AADS_SERVER_ADDRESS = "https://" + AADS_SERVER + ":8445/admin";
	public String AADS_SERVER_IPv4_ADDRESS = excelData.getLabInfo(lab, 2, 3);
	public String AADS_SERVER_VERSION = excelData.getTestData("Browser", 2, 1);
	public String SM_ADDRESS = excelData.getLabInfo(lab, 5, 1);
	public String SIP_CONTROL_LIST = SM_ADDRESS + ":5061;transport=TLS";

	public String SMGR_ADDR = excelData.getLabInfo(lab, 4, 1);
	public String AADS_COMMON_NAME = "aads.aam1.com";

	public String ALIAS = "smgrca";
	public String AADS_VERSION = "7.1.3.1.23";
	public String SMGRCA = "smgrca";
	public String WEBLMURL = "https://smgr245146.aam1.com:443/WebLM/LicenseServer";
	public String WEBLMURL2 = "https://smgr25080.aam1.com:443/WebLM/LicenseServer";

	public String AADS_ADMIN_ROLE_USER = excelData.getLabInfo(user, 2, 1);
	public String AADS_USER_1_NAME = excelData.getLabInfo(user, 5, 1);
	public String SECURITY_ROLE_USER = excelData.getLabInfo(user, 3, 1);
	public String AADS_USER_NAME = excelData.getLabInfo(user, 5, 1);
	public String AADS_USER_1_NAME_SIP_PHONE = excelData.getLabInfo(user, 6, 1);
//	public String AADS_USER_1_STANDARD_CONFIG = excelData.getLabInfo(user, 7, 1);
	public String AADS_USER_1_STANDARD_CONFIG = "Standard";
	public String AADS_USER_GROUP = excelData.getTestData("Browser", 1, 1); 
	public String AADS_USER_1_GROUP_CN ="AMMUsers [" + AADS_USER_GROUP +"]";
//	public String AADS_USER_GROUP = excelData.getLabInfo(user, 8, 1);
	
	
	
	public String SECURITY_ROLE_PWD = "tma_12Tma";

	public String AADS_USER_PWD = "tma_12Tma";
	public String AADS_USER_NAME_SIP_PHONE = "83807";

	// Constant
	public static String AADS_USER_GROUP_INPUT_5_CHARACTER = "AMMUsers"; // AD
	public String AADS_USER_1_GROUP = "AMMUsers";							// 2016

	public String AADS_EMAIL_SEARCH_CRQS = "amm83910@aam1.com";

	public String AADS_USER_PWD_INVALID = "invalidPass";
	public String AADS_USER_PWD_BLANK = "";
	public String AADS_USER_NAME_INVALID = "invalidUser";
	public String AADS_USER_NAME_BLANK = "";

	// Application Property
	public String ADMIN_HTTPSESSION_TIMEOUT_NEW = "16";
	public String APPLICATION_HTTPSESSION_TIMEOUT_NEW = "16";
	public String MAX_CONCURRENT_HTTP_SESSIONS_NEW = "200010";
	public String MAX_CONCURRENT_HTTP_SESSIONS_OTHER = "20001";
	public String CONCURRENT_HTTP_SESSIONS_PER_USER_NEW = "60";
	
	public String ADMIN_HTTPSESSION_TIMEOUT = "15";
	public String APPLICATION_HTTPSESSION_TIMEOUT = "15";
	public String MAX_CONCURRENT_HTTP_SESSIONS = "200000";
	public String CONCURRENT_HTTP_SESSIONS_PER_USER = "50";

	// New enterprise directory_2016 data
	public String NEW_ENTERPRISE_DIRECTORY_TYPE = "ActiveDirectory_2016";
	public String NEW_ENTERPRISE_DIRECTORY_PRIORITY = "6";
	public String NEW_ENTERPRISE_DIRECTORY_ADRR = "10.255.253.47";
	public String NEW_ENTERPRISE_DIRECTORY_BINDDN = "adminex16";
	public String NEW_ENTERPRISE_DIRECTORY_PORT = "3268";
	public String NEW_ENTERPRISE_DIRECTORY_BIND_CREDENTIAL = "tma_12Tma";
	public String NEW_ENTERPRISE_DIRECTORY_UID = "sAMAccountName";
	public String NEW_ENTERPRISE_DIRECTORY__BASE_CONTEXT_DN = "dc=aam1,dc=com";
	public String NEW_ENTERPRISE_DIRECTORY__LAST_UPDATE_TIME_ATTRIBUTE_ID = "whenChanged";

	//public String AADS_CLUSTER_NODES_CLUSTER = "10.255.250.36";
	public String AADS_CLUSTER_NODES_CLUSTER_UPDATE = "10.255.250.72(aads25072.aam1.com)";
	public String AADS_CLUSTER_NODES_SINGLE = "10.255.250.72";


	public String CORS_CONFIG_SPECIFIC_DOMAIN = "aam1.com";

	// public String AADS_ADMIN_ROLE_USER = excelData.getLabInfo(user, 2, 1);
	public String AADS_SECURITY_ROLE_USER = excelData.getLabInfo(user, 3, 1);
	public String AADS_AUDITOR_ROLE_USER = excelData.getLabInfo(user, 4, 1);

	// Client User
	// public String AADS_USER_1_NAME = excelData.getLabInfo(user, 5, 1);
	// public String AADS_USER_1_NAME_SIP_PHONE = excelData.getLabInfo(user, 6,
	// 1);
	// public String AADS_USER_1_STANDARD_CONFIG = excelData.getLabInfo(user, 7,
	// 1);
	// public String AADS_USER_1_GROUP = excelData.getLabInfo(user, 8, 1);
	// public String AADS_USER_1_GROUP = "cn=USERS,ou=Groups,dc=aam1,dc=com";


	// public String AADS_USER_2_NAME = dataExcel.getDataFromExcel(user, 8, 1);
	// public String AADS_USER_2_FULL_NAME = dataExcel.getDataFromExcel(user, 9,
	// 1);

	// public String AADS_USER_3_NAME = dataExcel.getDataFromExcel(user, 10, 1);
	// public String AADS_USER_3_FULL_NAME = dataExcel.getDataFromExcel(user,
	// 11, 1);

	public String AADS_APPCAST_FILE_NAME = "Avaya Equinox Setup 3.4.0.146.37";
	public String AADS_APPCAST_FILE_NAME_NEW = "Avaya Equinox Setup 3.4.0.146.37 new";
	public String AADS_APPCAST_VERSION = "3.4.0.146.37";

	public String AADS_GROUP_VIEW = "CN=AMMUsers,OU=Roles,OU=AMM,DC=aam1,DC=com";

}
