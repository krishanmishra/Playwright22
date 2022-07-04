package playwright_Basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopUp {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bx1=browser.newContext();
		BrowserContext bx2=browser.newContext();
		
		//1. open a new tab/window with after click on link on parent page
		Page page1=bx1.newPage();
		page1.navigate("https://opensource-demo.orangehrmlive.com/");
		
		Page popup=page1.waitForPopup(() ->{
			page1.click("img[alt='OrangeHRM on twitter']");
		});
		
		popup.waitForLoadState();
		
		System.out.println("Popup window title is: "+popup.title());
		System.out.println("Popup window url is: "+popup.url());
		popup.close();
		
		System.out.println("Parent window title is: "+page1.title());
		page1.close();
	
		//open new blank tab/window pop up and enter the url:
		Page page2=bx2.newPage();
		page2.navigate("https://opensource-demo.orangehrmlive.com/");
		
		Page popup2=page2.waitForPopup(()-> {
			page2.click("a[target='_blank']"); //open in new tab window
		});
		
		popup2.waitForLoadState();
		
		popup2.navigate("http://www.google.com");
		System.out.println("Popup window title is: "+popup2.title());
		popup2.close();
		
		System.out.println("Parent window title is: "+page2.title());
		page2.close();
		
		
		
		
//		Page page1=bx1.newPage();
//		Page page2=bx2.newPage();
//		
//		page1.navigate("http://www.google.com");
//		page2.navigate("http://www.amazon.com");


	}

}
