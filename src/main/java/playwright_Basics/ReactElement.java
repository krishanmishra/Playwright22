package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactElement {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext=browser.newContext();
		Page page=browserContext.newPage();
		page.navigate("https://www.netflix.com/in/");
		
		
		Locator footer=page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']");
//		List<String> footerList=footer.allTextContents();
//		footerList.stream().forEach(e->System.out.println(e));
//		for(String e:footerList) {
//			System.out.println(e);
//		}
		
		footer.allInnerTexts().forEach(e->System.out.println(e));
		

	}

}
