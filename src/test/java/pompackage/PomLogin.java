package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {

	
	//object repository
	//@FindBy(className="oxd-input--active")
	@FindBy(xpath = "//*[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement Password;
	
	@FindBy(css="//button[@type='submit']") 
	WebElement Loginbtn;

	
//initiate page elements
public PomLogin() {
	PageFactory.initElements(driver, this);
	}
public void typeusername(String name) {
	 Username.sendKeys(name);
}

public void typepassword(String pass) {
	Password.sendKeys(pass);
}
 public void clickbtn() {
	Loginbtn.click();
 }
	public String verify() {
		return driver.getTitle();
		
	}

}
