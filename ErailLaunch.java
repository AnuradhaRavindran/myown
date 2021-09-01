import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ErailLaunch {

	public static void main(String[] args) throws InterruptedException
 {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("ms");
		driver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("mdu");
		driver.findElementById("txtStationTo").sendKeys(Keys.TAB);
		driver.findElementById("chkSelectDateOnly").click();
		
		Thread.sleep(2000);
		List<String> trainnames = new ArrayList<String>();
		int size =  driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr").size();
		for(int i = 1 ;i <=size; i++) {
	String text = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]").getText();
	trainnames.add(text);
	System.out.println(text);
	//copy the list including duplicates
	int listsize = trainnames.size();
	Set<String>  setTrainNames = new LinkedHashSet<String>(trainnames);
	int setsize = setTrainNames.size();
	
	
	if(listsize == setsize) {
		
		System.out.println("There is no Duplicate");
	  }
	else
	{
 
			System.out.println("There are duplicates");
	}
	
	
		}
	
	}
}

	


