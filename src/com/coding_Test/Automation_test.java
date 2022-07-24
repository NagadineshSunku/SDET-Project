package com.coding_Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Automation_test {
	Automation_test_Objects testObjects=new Automation_test_Objects();
public void checkMovieIMDB(WebDriver driver,String movieName,String reldate,String country) throws InterruptedException, AWTException
{
	driver.get(testObjects.IMDBlink);
	Thread.sleep(4000);
	driver.findElement(By.id(testObjects.IMDBSearchBox)).click();
	Thread.sleep(2000);
	driver.findElement(By.id(testObjects.IMDBSearchBox)).sendKeys(movieName);
	Robot robot=new Robot();
	Thread.sleep(3000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.delay(2000);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(6000);
	driver.findElement(By.xpath(testObjects.movieLink)).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath(testObjects.movieDetails)).click();
	String checkReldate=driver.findElement(By.xpath(testObjects.relDate)).getText();
	System.out.println(checkReldate);
	Thread.sleep(3000);
	String checkCountry=driver.findElement(By.xpath(testObjects.country)).getText();
	System.out.println(checkCountry);
	Assert.assertEquals(reldate,checkReldate);
	Assert.assertEquals(country, checkCountry);
	
}
public void checkMovieWiki(WebDriver driver,String movieName,String reldatewiki,String country) throws InterruptedException, AWTException
{
	driver.get("https://www.wikipedia.org/");
	Thread.sleep(3000);
	String[] list=movieName.split("-");
	driver.findElement(By.xpath(testObjects.wikiSearch)).sendKeys(list[0]);
	Robot robot=new Robot();
	Thread.sleep(3000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.delay(2000);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(6000);
	driver.findElement(By.xpath(testObjects.movieDetailsWiki)).click();
	Thread.sleep(2000);
	String checkrelDateWiki=driver.findElement(By.xpath(testObjects.relDateWiki)).getText();
	System.out.println(checkrelDateWiki);
	String checkcountryWiki=driver.findElement(By.xpath(testObjects.countryWiki)).getText();
	System.out.println(checkcountryWiki);
	Assert.assertEquals(reldatewiki.trim(),checkrelDateWiki.trim());
	Assert.assertEquals(country.trim(), checkcountryWiki.trim());
	
	
}
	

}
