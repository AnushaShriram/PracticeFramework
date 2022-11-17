package loginModule;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.PropertyFileUtility;
import genericUtility.ScreenshotUtility;

public class TC_id extends BaseClass {
@Test
public void TestCaseDescription() throws IOException {
	WebElement email = driver.findElement(By.id("Email"));
	WebElement password = driver.findElement(By.id("Password"));
	WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
	/*String username = PropertyFileUtility.PropertyReader("username");
	email.sendKeys(username);
	password.sendKeys(PropertyFileUtility.PropertyReader("password"));
	loginButton.click();*/
/*	WebElement radio = driver.findElement(By.id("pollanswers-1"));
	radio.click();
	assertEquals(loginButton.isSelected(),true);
	Logger.log(Status.FAIL, "failed");
	//ScreenshotUtility.takeScreenShotMethod("myscrrenshot");*/
	
	
	assertEquals(false, true);
	
}
	
}
