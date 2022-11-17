package genericUtility;

import java.awt.Desktop.Action;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilityMethod {
public static  Actions ActionUtility(WebDriver driver) {
	Actions act=new Actions(driver);
	return act;
}

public void SelectUtility(WebElement element , String value) {
	Select select=new Select(element);
	try {
		select.selectByVisibleText(value);
	}catch (NoSuchElementException e) {
		select.selectByValue(value);
	}catch(Exception e) {
		int index = Integer.parseInt(value);
		select.selectByIndex(index);
	}
}
}
