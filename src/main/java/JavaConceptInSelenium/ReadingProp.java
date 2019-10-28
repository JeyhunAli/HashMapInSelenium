package JavaConceptInSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingProp {
	
	
	static WebDriver driver;
	

	public static void main(String[] args) throws IOException {
		
		
Properties prop = new Properties();
FileInputStream input = new FileInputStream("/Users/jey/git/HashMapInSelenium/src/main/java/JavaConceptInSelenium/config.proporties");
prop.load(input);

String BroswerName = prop.getProperty("browser");
String url = prop.getProperty("url");
String name = prop.getProperty("name");
String LastName = prop.getProperty("LastName");


if(BroswerName.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}else if (BroswerName.equals("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else if (BroswerName.equals("IO")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	else if (BroswerName.equals("safari")) {
		driver = new SafariDriver();
		
	}
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(url);
driver.findElement(By.xpath("//input[@id='sign_up_form_first_name']")).sendKeys(prop.getProperty(name, name));
driver.findElement(By.xpath("//*[@id=\"sign_up_form_last_name\"]")).sendKeys(prop.getProperty(LastName, LastName));
System.out.println("property file works fine ");
	}
	
	
}
