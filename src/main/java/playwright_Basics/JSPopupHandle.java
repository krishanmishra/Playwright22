package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSPopupHandle {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		//listener
		page.onDialog(dialog ->{
			String text=dialog.message();
			System.out.println(text);
//			dialog.accept();
			dialog.accept("I am krishan mishra");
		});

		// JS alert, prompt, confirmation pop ups

		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.click("//button[text()='Click for JS Alert']");
	//	Thread.sleep(1500);		
		String result2 = page.textContent("#result");
		System.out.println(result2);
		
		page.click("//button[text()='Click for JS Confirm']");
		Thread.sleep(1500);
		result2 = page.textContent("#result");
		System.out.println(result2);
		
		page.click("//button[text()='Click for JS Prompt']");
		Thread.sleep(1500);
		result2 = page.textContent("#result");
		System.out.println(result2);
		
		
//		//alert
//		page.click("//button[text()='Click for JS Alert']");
//		String result = page.textContent("#result");
//		System.out.println(result);
//		
//        //confirm
//		page.click("//button[text()='Click for JS Confirm']");
//		String result1 = page.textContent("#result");
//		System.out.println(result1);
//		
		//prompt
////		page.click("//button[text()='Click for JS Prompt']");
//		String result2 = page.textContent("#result");
//		System.out.println(result2);
		
		page.close();
		browser.close();
		playwright.close();

	}

}
