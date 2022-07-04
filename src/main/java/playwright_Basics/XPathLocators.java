package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XPathLocators {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
//		page.navigate("https://www.amazon.com/");
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
//        Locator check_joeRoot=page.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']");
//        check_joeRoot.click();
//		Locator checkboxes=page.locator("//table[@id='resultTable']//input[@type='checkbox']");
//		for(int i=0;i<checkboxes.count();i++) {
//			checkboxes.nth(i).click();
//		}
		
		page.locator("xpath=(//table[@id='resultTable']//input[@type='checkbox'])[1]").click();
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
		
		
//		Locator totalAmazonLinks=page.locator("//a[contains(text(),'Amazon')]");
//		System.out.println(totalAmazonLinks.count());
//		List<String> amazonList=totalAmazonLinks.allTextContents();
//		for(String e:amazonList) {
//			System.out.println(e);
//		}
	}

}
