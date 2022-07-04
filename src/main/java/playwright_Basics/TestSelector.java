package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestSelector {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

//		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
//
//		// page.locator("text=Contact Sales").click();
//		// page.locator("text= Privacy Policy").first().click();
//		Locator links = page.locator("text= Privacy Policy");
//		 
//		for(int i=0;i<links.count();i++) {
//			System.out.println(links.nth(i).textContent());
//			
//			String text=links.nth(i).textContent();
//			if(text.contains("Service Privacy Policy")) {
//				links.nth(i).click();
//				break;
//			}
//		}

		
		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		//String header=page.locator("h2:has-text('New Customer')").textContent();
		
		String header=page.locator("div.well h2:has-text('New Customer')").textContent();
		System.out.println(header);
		
//		String pageHeader=page.locator("'Your Store'").textContent();
		String pageHeader=page.locator("text=Your Store").first().textContent();  //last()
		
		//"'Your Store'" same as "text=Your store"
		System.out.println(pageHeader);
		
		
		//button
		page.locator("form input:has-text('Login')").click();
		
		
//		page.close();
//		browser.close();

	}

}
