//~category manager user --go to the app--add all the products
//~customer user --go to the app-- buy a product --place an order
//~admin user --go to the app-- can see all the orders
//~Seller user --go to the app--see only those orders which are relevant
//~Distributor User - go to the app--can see the respective order
//~Delivery Boy User --go to the app--can see the order and deliver the product
//~customer care user --go to the app-- log a ticket

//lets say these all users of the application and need to handle it need store it in our framwork 
// to handle these to store all these data no need to write code again and again for that we store all these in hashmap
//in hashmap duplicate key is not allowed 
//if i store here dublicate customer its not allowed because its key 
//but duplicate value is allowed 
//in hashmap we can pass only key its enough to get value as well 

//this is calls 
//Use Case:
//Different Users/Roles : Permission Based User Management System.


package JavaConceptInSelenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HashMapInSelenium {
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.get("https://www.crmpro.com/index.html");
//		
//		driver.findElement(By.xpath("//input[@name='username']"));
//		driver.findElement(By.xpath("//input[@name='password']"));
		
//		System.out.println(getCredentialsMap());
//		System.out.println(getCredentialsMap().get("userGunel")); //here im passing key and getting value 
//		System.out.println(getCredentialsMap().get("customer")); //here im passing key and getting value 
		
		//String credentials_customer = getCredentialsMap().get("customer");// here im storing method name with get method in string 
		
		//this one 1st way to use it 
//		//here im im using string value to access split method to choose from hashmap
		//here split method will return string array 
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(credentials_customer.split(":")[0]);
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(credentials_customer.split(":")[1]);
		
		
		//another way more jenerics way to call hashmap 
		//whenever i need another user i just pass ket here then run it it will take the key and value from 
		//hashmap then it will execute 
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(getUserName("customer"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(getUserPassword("customer"));
		
		
		

	}
	
	//creating generics method out of the main method 
	//here creating object of hashmap
	// i will store the value here in the form of key and value   k,v
	//theres a question how to store usernmae and password in same string 
	//for that in hashmap we have to use like that  ("customer", "Jeyhun:Test456"); here customer key, jeyhun username :by is separet test456
	//is password 
	
	public static HashMap<String, String> getCredentialsMap() {
		HashMap<String, String> userMap = new HashMap<String, String>();
		
		userMap.put("customer", "Jeyhun:Test456");
		userMap.put("admin", "adminHasan:Test456");
		userMap.put("userGunel", "Gunel:Test456");
		userMap.put("seller", "SellerGirl:Test456");
		userMap.put("deliveryBoy", "deliveryTom:Test456");
		
		return userMap;
		

	}
	
	//to use another way of calling hashmap more jenerics one for that im creating method 
	
	public static String getUserName(String role ) {
		String credentials = getCredentialsMap().get(role);
		return credentials.split(":")[0];
		
	}
	
	public static String getUserPassword(String role ) {
		String credentials = getCredentialsMap().get(role);
		return credentials.split(":")[1];
		
	}
	
	
	
	
}
