package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassAuto {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "https://login.salesforce.com";
        String username = "yixamik485-n3jy@force.com";
        String password = "*Test019";
        String expectedTitle = "Home | Salesforce";
        String actualTitle = "";
        String accountName = "Test Account 6";
        String accountEditName = "Test Account 6 - Updated";
        
        //Login Element Xpath
        String username_xpath = "/html//input[@id='username']";
        String password_xpath = "/html//input[@id='password']";
        String loginBtn_xpath = "/html//input[@id='Login']";
        
        //Account Element Xpath
        String accountLnk_xpath = "//div[@class='viewport']/section//one-appnav//one-app-nav-bar[@class='slds-grid slds-has-flexi-truncate']/nav[@role='navigation']/div[@role='list']/one-app-nav-bar-item-root[2]/a[@title='Accounts']";
        String accountNew_xpath = "//div[@id='sfdc-splitview-content']/div/div/div/div/div//div[@class='slds-grid']/div[2]/ul/li[1]/a[@role='button']/div[@title='New']";
        String accountName_xpath = "//div/label/span[text()='Account Name']/../following::input[1]";
        String accountSave_xpath = "//div[contains(@class, 'isModal')]//button[span[text() = 'Save']]";
        String accountEdit_xpath = "//body[@class='desktop']//div[@class='viewport']/section//div[@role='main']/div[@class='contentArea fullheight']/div/div/div//one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-account_-record_-page___-account___-v-i-e-w[@class='adg-rollup-wrapped']/forcegenerated-flexipage_account_record_page_account__view_js[@class='forcegenerated-flexipage-module']/record_flexipage-record-page-decorator//records-record-layout-event-broker//flexipage-record-home-template-desktop2[@class='forcegenerated-flexipage-template']//slot[@name='header']/flexipage-component2//records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___012000000000000aaa___compact___view___recordlayout2[@class='forcegenerated-record-layout2']/records-highlights2//runtime_platform_actions-actions-ribbon/ul[@class='slds-button-group-list']//runtime_platform_actions-action-renderer[@title='Edit']/runtime_platform_actions-executor-page-reference//lightning-button/button[@name='Edit']";
        String accountRecord_xpath = "//body/div[4]/div[@class='viewport']/section//div[@role='main']/div[@class='contentArea fullheight']/div/div/div//one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-account_-record_-page___-account___-v-i-e-w[@class='adg-rollup-wrapped']/forcegenerated-flexipage_account_record_page_account__view_js[@class='forcegenerated-flexipage-module']/record_flexipage-record-page-decorator//records-record-layout-event-broker//flexipage-record-home-template-desktop2[@class='forcegenerated-flexipage-template']//slot[@name='header']/flexipage-component2//records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___012000000000000aaa___compact___view___recordlayout2[@class='forcegenerated-record-layout2']/records-highlights2//slot[@name='primaryField']/sfa-output-name-with-hierarchy-icon-account/sfa-output-name-with-hierarchy-icon-wrapper/force-aura-action-wrapper//lightning-formatted-text[@class='custom-truncate']";
        
        driver.get(baseUrl);
        
        //Login 
        driver.findElement(By.xpath(username_xpath)).sendKeys(username);
        driver.findElement(By.xpath(password_xpath)).sendKeys(password);
        driver.findElement(By.xpath(loginBtn_xpath)).click(); 
        
        Thread.sleep(5000);
       
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Login successful!");
        } else {
            System.out.println("Login not successful!");
        }
        
        //Create Account
       Thread.sleep(5000);
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath(accountLnk_xpath)));
       Thread.sleep(5000);
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath(accountNew_xpath)));
       Thread.sleep(5000);
       driver.findElement(By.xpath(accountName_xpath)).sendKeys(accountName);
       driver.findElement(By.xpath(accountSave_xpath)).click();
       
       Thread.sleep(5000);
       
       if(driver.findElement(By.xpath(accountRecord_xpath)).getText().contentEquals(accountName)){
    	   System.out.println("Test Case No. 1 : Account created!");
       } else {
           System.out.println("Test Case No. 1 : Account not created!");
       }
       
       //Edit Account
       Thread.sleep(5000);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath(accountEdit_xpath)));
       Thread.sleep(5000);
       driver.findElement(By.xpath(accountName_xpath)).clear();
       driver.findElement(By.xpath(accountName_xpath)).sendKeys(accountEditName);
       driver.findElement(By.xpath(accountSave_xpath)).click();
       
       Thread.sleep(5000);
       
       if(driver.findElement(By.xpath(accountRecord_xpath)).getText().contentEquals(accountEditName)){
    	   System.out.println("Test Case No. 2 : Account updated!");
       } else {
           System.out.println("Test Case No. 2 : Account not updated!");
       }
       
       
       driver.close();

	}

}
