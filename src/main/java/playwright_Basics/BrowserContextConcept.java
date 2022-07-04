package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext brctx1 = browser.newContext();
		Page page1 = brctx1.newPage();
		page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		page1.fill("#Form_submitForm_Name", "krishan");
		System.out.println(page1.title());
		System.out.println(page1.url());

		BrowserContext brctx2 = browser.newContext();
		Page page2 = brctx2.newPage();
		page2.navigate("http://automationpractice.com/index.php");
		page2.fill("input#search_query_top", "Dress");
		System.out.println(page2.title());
		System.out.println(page2.url());

		BrowserContext brctx3 = browser.newContext();
		Page page3 = brctx3.newPage();
		page3.navigate("http://www.amazon.in");
		System.out.println(page3.title());
		System.out.println(page3.url());

		page1.close();
		brctx1.close();

		page2.close();
		brctx2.close();

		page3.close();
		brctx3.close();

	}

}
