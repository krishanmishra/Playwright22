package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWright_Basic {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch();
		Page page = browser.newPage();

		page.navigate("http://www.google.com");
		System.out.println(page.title());

	}

}
