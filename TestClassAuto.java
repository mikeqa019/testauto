package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassAuto {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	String baseUrl = "https://console.uat.asians.group/#/domain/list";
        String username = "ravev29388@brandoza.com";
        String password = "1";
        String expectedTitle = "CDN console - high-speed, high-defense, high-speed CDN";

        
        //Login Element Xpath
        String username_xpath = "/html//input[@id='username']";
        String password_xpath = "/html//input[@id='password']";
        String loginBtn_xpath = "/html//input[@id='kc-login']";
        
        driver.get(baseUrl);
        
        //Login 
        driver.findElement(By.xpath(username_xpath)).sendKeys(username);
        driver.findElement(By.xpath(password_xpath)).sendKeys(password);
        driver.findElement(By.xpath(loginBtn_xpath)).click(); 
       
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Login successful!");
        } else {
            System.out.println("Login not successful!");
        }
       
       
       driver.close();

	}

}
