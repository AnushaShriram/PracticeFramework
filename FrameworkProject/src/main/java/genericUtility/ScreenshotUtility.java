package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtility extends BaseClass implements IAutoConstant{

	public static String takeScreenShotMethod(String screenshotName) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File photo = screenshot.getScreenshotAs(OutputType.FILE);
		String ldt = LocalDateTime.now().toString().replace(':', '-');
		String destination = System.getProperty("user.dir")+ERRORSHOTS+screenshotName+" "+ldt+".png";
		//File storage=new File(ERRORSHOTS+screenshotName+" "+ldt+".png");
		File storage=new File(destination);
		FileUtils.copyFile(photo, storage);
		return destination;
	}
}
