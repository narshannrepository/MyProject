package testLayer;

//import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pompackage.PomLogin;
import testdata.ExcelSheet;
import basePackage.BaseHRMClass;

public class LoginTest extends BaseHRMClass {
	PomLogin Log;
	
	public LoginTest() {
		super();
	}
		@BeforeMethod
		public void initsetup() {
			initiate();
			screenshots("Login");
			Log=new PomLogin();
		}
		
		@Test(priority=1)
		public void Title() {
			String actual=Log.verify();
			System.out.println(actual);
			Assert.assertEquals(actual, "OrangeHRM");
	}

	
	  @DataProvider 
	  public Object[][] Details() { 
		  Object result [][]=ExcelSheet.readdata("Sheet1"); 
		  return result;
	 
}
		
	
	  @Test(priority=2, dataProvider="Details") 
	  public void Login(String name,String password) throws InterruptedException {
		  Log.typeusername(name);
	  Thread.sleep(3000);
	  Log.typepassword(password); 
	// Log.clickbtn();
	 		}
		
	
		/*
		 * @Test(priority=2) public void Login() throws InterruptedException {
		 * Log.typeusername(prop.getProperty("username")); Thread.sleep(3000);
		 * Log.typepassword(prop.getProperty("password")); Log.clickbtn();
		 */
	 
		//}
		
	@AfterMethod
	public void close() {
		driver.close();
	}
}
