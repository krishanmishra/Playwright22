package playwright_Basics;

import java.nio.charset.StandardCharsets;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class ReadUploadFileContent {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");

		// read content of uploaded file
		page.setInputFiles("input[name='upfile']",
				new FilePayload("krishan.text", "text/plain", "Krishan here".getBytes(StandardCharsets.UTF_8)));
		page.click("input[value=Press]");
		

	}

}
