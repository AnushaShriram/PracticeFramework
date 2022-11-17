package genericUtility;

import java.util.Set;

public class WebDriverUtility extends BaseClass{

	//Method to switching driver control to another window
	public static void switchingWindow(Set<String> allId) {
		for(String id:allId) {
			driver.switchTo().window(id);
		}
	}
	
	//Method to switching back the control main window
	public static void switchingBackWindow(String Id) {
		driver.switchTo().window(Id);
	}
	
	//Method to switching driver control to frame
	public static void switchToFrame(String FrameRef){
		try {
			driver.switchTo().frame(FrameRef);
		}catch(Exception e) {
			int index = Integer.parseInt(FrameRef);
			driver.switchTo().frame(index);
		}
	}
}
