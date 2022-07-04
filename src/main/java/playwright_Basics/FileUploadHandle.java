package playwright_Basics;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploadHandle {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//input type -- file
		page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));
		Thread.sleep(3500);
		//detach the file
		page.setInputFiles("input#filesToUpload", new Path[0]);
		
		
		//multiple files
		page.setInputFiles("input#filesToUpload", new Path[] {
				Paths.get("applogin.json"),
				Paths.get("applogin.json"),
				Paths.get("applogin.json")});
		Thread.sleep(3000);
		//detach the file
		page.setInputFiles("input#filesToUpload", new Path[0]);
		

	}

}
