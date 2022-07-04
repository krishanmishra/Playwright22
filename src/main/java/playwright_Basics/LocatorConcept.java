package playwright_Basics;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {
	
	
//	C:\Users\kkm\eclipse-workspace\PlayWrightDemo_01
//	mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen wikipedia.org"


	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext brctx = browser.newContext();

		// locator---Single Element
		Page page = brctx.newPage();
//		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");		
//		Locator contactSales=page.locator("text= CONTACT SALES");
//		contactSales.hover();
//		contactSales.click();

//		page.navigate("https://academy.naveenautomationlabs.com/");		
//		Locator contactSales=page.locator("text= Login");
//		contactSales.hover();
//		contactSales.click();

//		page.navigate("https://academy.naveenautomationlabs.com/");		
//		Locator loginButton=page.locator("text= Login").first();
//		loginButton.hover();
//		loginButton.click();

//		page.navigate("https://academy.naveenautomationlabs.com/");		
//		Locator loginButton=page.locator("text= Login");
//		
//		int totalLoginBtn=loginButton.count();
//		
//		System.out.println(totalLoginBtn);
//		
//		loginButton.first().click();

		// multiple elements
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Locator countryOptions = page.locator("select#Form_submitForm_Country option");
		System.out.println(countryOptions.count());

//		for(int i=0;i<countryOptions.count();i++) {
//			String text=countryOptions.nth(i).textContent();
//			System.out.println(text);
//			
//		}

		List<String> countriesList = countryOptions.allTextContents();
//		
//		for(String e:countriesList) {
//			System.out.println(e);
//		}

//		for(int i=0;i<countriesList.size();i++) {
//			
//			String text=countriesList.get(i);
//			
//			System.out.println(text);
//		}
//		
		Iterator<String> itr = countriesList.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// lambda
		// countriesList.forEach(ex ->System.out.println(ex));

		page.close();
		browser.close();
	}

}
