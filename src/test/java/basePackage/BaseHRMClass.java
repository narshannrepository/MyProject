package basePackage;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import utility.TimeUtils;

public class BaseHRMClass {
	
	//browser info WebDriver driver=new FirefoxDriver();	
	//url info
	//username and password

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Step 1
	public BaseHRMClass() {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\shann\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environementvariables\\Config.properties");
		prop.load(file);		
		}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
		catch (IOException a) {
			a.printStackTrace();
		}
	}
			// Step 2
			public static void initiate() {
				String Browsername=prop.getProperty("browser");	//driver path webDriver.gecko
				
						
				if (Browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");	//maximize page load, implicit, getting url
			driver=new FirefoxDriver();  //if browser=chrome webDriver.chrome.driver
				
				}		
			else if (Browsername.equals("chrome")) {	//elseif(browser=firefox) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 	//webdriver.gecko.driver
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(op);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			WebDriverWait wait=new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
			driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
				}  
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			}
						
		public static void screenshots(String Filename) {
				File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
				FileUtils.copyFile(file,new File("C:\\Users\\shann\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
			
				}
				catch(IOException e) {
					e.printStackTrace();
				}
}
}
