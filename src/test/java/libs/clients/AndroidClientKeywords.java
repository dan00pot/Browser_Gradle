package libs.clients;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import libs.common.Selenium;
import libs.clients.AndroidClientLocators;

public class AndroidClientKeywords {

	Selenium selenium = new Selenium();
	AndroidClientLocators androidClient = new AndroidClientLocators();

	AndroidDriver androidClientDriver;

	public boolean autoConfigLogin(AndroidDriver androidClientDriver,
			String address, String usr, String pwd) throws Exception {
		boolean n = false;
		try {
			selenium.clickElement(androidClientDriver,
					androidClient.FIRST_SCREEN_SETTING_BTN);

			selenium.clickElement(androidClientDriver,
					androidClient.FIRST_SCREEN_SETTING_USE_WEB_BTN);

			selenium.clickElement(androidClientDriver,
					androidClient.FIRST_SCREEN_SETTING_WEB_ADDRESS_TXT);
			selenium.inputText(androidClientDriver,
					androidClient.FIRST_SCREEN_SETTING_WEB_ADDRESS_TXT, address);
			selenium.clickElement(androidClientDriver,
					androidClient.FIRST_SCREEN_SETTING_USE_WEB_NEXT_BTN);

			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SETTING_USER_TXT);
			selenium.inputText(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SETTING_USER_TXT, usr);

			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SETTING_PWD_TXT);
			selenium.inputText(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SETTING_PWD_TXT, pwd);
			androidClientDriver.pressKeyCode(AndroidKeyCode.ENTER);

			selenium.inputText(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SETTING_USER_TXT, usr);

			for (int i = 0; i < 2; i++) // 4
			{
				selenium.clickElement(androidClientDriver,
						androidClient.AADS_LOGIN_SCREEN_ALLOW_TXT);
				Thread.sleep(1000);
			}
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_OK_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_ACCEPT_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_ACCEPT_COMFIRM_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SKIP_TUTORIAL_BTN);
		} catch (Exception exception) {
			throw new Exception("autoConfigLogin - Failed - Exception occurs: "
					+ exception);
		}
		return n;
	}

}