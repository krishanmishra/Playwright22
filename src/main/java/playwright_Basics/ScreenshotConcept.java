package playwright_Basics;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ScreenshotOptions;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.Playwright;

public class ScreenshotConcept {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://www.naveenautomationlabs.com/opencart/");
//		page.navigate("http://www.amazon.com");
		page.screenshot
		       (new Page.ScreenshotOptions()
		    		    .setPath(Paths.get("screenshot.png"))
		    		       .setFullPage(true));
		page.screenshot
	       (new Page.ScreenshotOptions()
	    		    .setPath(Paths.get("screenshot1.png"))
	    		       .setFullPage(false));
		
		page.locator("img[title='MacBook']")
		       .screenshot(new ScreenshotOptions().setPath(Paths.get("locator.png")));
		
		page.locator("div#content  div.row").screenshot(new ScreenshotOptions().setPath(Paths.get("area.png")));
		

	}

}
