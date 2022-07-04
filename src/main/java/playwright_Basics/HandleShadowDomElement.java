package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleShadowDomElement {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// Page ---DOM ---> Shadow DOM  -->elements
	   // Page -- DOM ---->Frame -->Shadow DOM -> elements
		Page page = browser.newPage();

//		page.navigate("https://books-pwakit.appspot.com/");
//
//		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
//		
//		String text=page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
//		System.out.println(text);
		
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger masala Tea");
		page.frameLocator("#pact").locator("div#app2 #pizza").fill("Pizza afternoon");
//		page.frameLocator("#pact").locator("div#concepts #training").fill("shadow dom support");
		

	}

}
