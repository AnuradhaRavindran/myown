import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class irctc {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElementByXPath("//button[text()='OK']").click();
		driver.findElementByLinkText("FLIGHTS").click();
		String title = driver.getTitle();
		System.out.println(title);
		String firstwindowHandle = driver.getWindowHandle();
		System.out.println(firstwindowHandle);
		Set<String>  windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		String secondwindowHandles = listHandles.get(1);
		driver.switchTo().window(secondwindowHandles);
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.switchTo().window(firstwindowHandle);
		driver.close();
		
		
		
	}
	

}
