package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class {

	static WebDriver driver;

	public static  WebDriver browser_Launch() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
return driver;
	}

	public static void url(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}

	public static void sendKeys(WebElement element, String send) {
		// TODO Auto-generated method stub
		element.sendKeys(send);
	}
	
	
	public static void screenshot( String fnname) throws IOException {
		// TODO Auto-generated method stub

		TakesScreenshot a = (TakesScreenshot) driver;

		File screenshotAs = a.getScreenshotAs(OutputType.FILE);

		File obj = new File("G:\\Maven_Evng\\Screenshot\\ "+fnname+ ".png");

		FileUtils.copyFile(screenshotAs, obj);
		
	}
	
	public static String values;
	//DataDriven
	public static String data_pass(int r,int c) throws IOException {
		// TODO Auto-generated method stub
File f = new File("G:\\Maven_Evng\\Data.xlsx");
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fi);
		
		Sheet sheetAt = wb.getSheetAt(0);
		
		Row row = sheetAt.getRow(r);
		Cell cell = row.getCell(c);
		CellType cellType = cell.getCellType();
		if (cellType.equals(CellType.STRING)) {
			System.out.println(cell.getStringCellValue());
			values = cell.getStringCellValue();
			
		} else if(cellType.equals(CellType.NUMERIC)) {

			double numericCellValue = cell.getNumericCellValue();
			int numericCellValue1=(int) numericCellValue;
			System.out.println(numericCellValue1);
			values = String.valueOf(numericCellValue1);
		}
		
		return values;
		
	}
		
	
	

	

}
