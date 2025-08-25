package AutomationExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class LoginUser 
{
	public static void main(String[] args) throws InterruptedException
	{
// Test Case 2: Login User with correct email and password
		
//		1. Launch browser
		WebDriver driver=BrowserFactory.LaunchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);
		
//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("http://automationexercise.com");
		Thread.sleep(1000);
		
//		3. Verify that home page is visible successfully
		WebElement homepage=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		String hometxt=homepage.getText();
		
		if(hometxt.equalsIgnoreCase("Home"))
		{
			System.out.println("Home page verified: Passed");
		}
		else 
		{
			System.out.println("Test case failed for verify home page.");
		}
		Thread.sleep(1000);

//		4. Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();
		Thread.sleep(1000);

	
//		5. Verify 'Login to your account' is visible
		String signtxt="Login to your account";
		WebElement newlogintxt=driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
		String login=newlogintxt.getText();

		if(login.contains(signtxt))
		{
			System.out.println("Login to your account is visible: Passed");
		}
		else 
		{
			System.out.println("Login to your account is visible test case: Failed");
		}
		Thread.sleep(1000);
		
		
//		6. Enter correct email address and password
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys("kmsonika7@gmail.com");
		driver.findElement(By.xpath("((//input[@placeholder='Password'])[1]")).sendKeys("sonika123#");
		Thread.sleep(1000);
		
//		7. Click 'login' button
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		Thread.sleep(2000);
		
//		8. Verify that 'Logged in as username' is visible
		WebElement loggedIn=driver.findElement(By.xpath("//a[contains(text(),'Logged')]"));
		
//		9. Click 'Delete Account' button
		driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();

		
//		10. Verify that 'ACCOUNT DELETED!' is visible
		WebElement deleteAccpage=driver.findElement(By.xpath("//b[contains(text(),'Account Deleted')]"));
		String deleteAccTxt=deleteAccpage.getText();
		if(deleteAccTxt.equalsIgnoreCase("ACCOUNT DELETED!"))
		{
			System.out.println("ACCOUNT DELETED! page visible: Passed");
		}
		else 
		{
			System.out.println("ACCOUNT DELETED! page visible: Fail");
		}
		Thread.sleep(2000);
		
		System.out.println("User Login with correct Email/password code working successfully.");
		driver.quit();
	}
}
