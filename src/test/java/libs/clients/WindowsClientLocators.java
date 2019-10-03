package libs.clients;

import org.openqa.selenium.By;

public class WindowsClientLocators {

	public By SEARCH_TEXT_BOX = By.xpath("//*[@ClassName='TextBox']");
	public By SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR = By.xpath("//*[contains(@Name,'ENTERPRISE')]");
	public By search_contact_enterprise_result (String name) {
		return By.xpath("//*[contains(@Name,'ENTERPRISE')]//following-sibling::*[contains(@Name,'Search Results')]/*[contains(@Name,'Avaya.UCC.ViewModels.DashboardTabContents.Contacts.ContactViewModel')]/*[contains(@Name,'"+name+"')]");
	}
	
	
}
