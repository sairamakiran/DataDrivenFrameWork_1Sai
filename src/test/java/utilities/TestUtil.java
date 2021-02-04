package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

public class TestUtil extends TestBase{
	
	public static String ScreenshotName;
	public static String screenshotPath;
	
	public static void captureScreenshot() throws IOException
	{
		
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		ScreenshotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		//If we simply give error.jpg it will give only one screen shot with error.jpg 
		//So we are giving time stamp to capture.
		FileUtils.copyFile(scrfile, 
				new File(System.getProperty("user.dir") + "\\reports\\" + ScreenshotName));
	}
	@Test(dataProvider = "getData")

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {
		String sheetName =m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				// data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}

}
