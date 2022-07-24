package com.coding_Test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation_test_driver {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\Project\\WebDrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Automation_test_Objects testObjects=new Automation_test_Objects();
		driver.manage().window().maximize();

		File file=new File("C:\\Users\\Lenovo\\eclipse-workspace\\Project\\Movies.xlsx");
		FileInputStream fis=new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		String check=workbook.getSheetAt(0).getRow(1).getCell(0)+"";
		Automation_test runner=new Automation_test();
		for(int i=1;i<workbook.getSheetAt(0).getPhysicalNumberOfRows();i++)
		{
			if(check.equals("Yes"))
			{
				String movieName=workbook.getSheetAt(0).getRow(1).getCell(1)+"";
				String reldate=workbook.getSheetAt(0).getRow(1).getCell(2)+"";
				String reldatewiki=workbook.getSheetAt(0).getRow(1).getCell(4)+"";
				String country=workbook.getSheetAt(0).getRow(1).getCell(3)+"";
				runner.checkMovieIMDB(driver,movieName,reldate,country);
				runner.checkMovieWiki(driver, movieName, reldatewiki, country);
			}
			
		}
		

	}
}
