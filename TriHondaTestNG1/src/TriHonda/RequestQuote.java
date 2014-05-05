package TriHonda;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.io.*;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@Test
public class RequestQuote {
	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	Sheet s; 	
	WebDriver driver;
	
	String folder = "";
	String name="Y://TrHondaTestNG1/RequestQuote" + timeStamp + "/" + "hondacar.png";
	String local=(new java.io.File("").getAbsolutePath());
	String data="" + local + "/" + "infoqa.xls";
	private StringBuffer verificationErrors = new StringBuffer();
	
  public void f() {
  }
  @Test
  public void beforeMethod() throws Exception {
	  FileInputStream fi = new FileInputStream(data);

		Workbook w = Workbook.getWorkbook(fi);
		s = w.getSheet(0);
		for(int row=1; row <=s.getRows();row++) {
			
			   // String baseurl="http://www.google.com";
			   // driver.get(baseurl);

				String urlname = s.getCell(0, row).getContents();
				driver.get(urlname);
				Thread.sleep(1000);
			    File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile1, new File("Y://Screenshots/RequestQuote/" + timeStamp + "/" + row  + "-" + "hondacar.png"));
				
				//((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//Thread.sleep(3000);

				
				
				
				   //driver.findElement(By.cssSelector("a.request-button.blue-button > span")).click();
				   
				   driver.findElement(By.cssSelector("div.no-offer-callout-details > a.request-button.blue-button > span")).click();
				    driver.findElement(By.id("fname")).clear();
				    driver.findElement(By.id("fname")).sendKeys("TestFirst");
				    driver.findElement(By.id("lname")).clear();
				    driver.findElement(By.id("lname")).sendKeys("TestLast");
				    driver.findElement(By.id("email")).clear();
				    driver.findElement(By.id("email")).sendKeys("donotreply@pkt.com");
				    driver.findElement(By.id("zipcode")).clear();
				    driver.findElement(By.id("zipcode")).sendKeys("11413");
				    driver.findElement(By.id("phone")).clear();
				    driver.findElement(By.id("phone")).sendKeys("2122222222");
				    driver.findElement(By.cssSelector("div.button > button.blue-button")).click();
				    File scrFile11 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				    FileUtils.copyFile(scrFile11, new File(name));
				    System.out.println("Inside Name function?");
				    System.out.println(name);
				    System.out.println("My Lolal is: ");
				    System.out.println(new java.io.File("").getAbsolutePath());
			    	System.out.println(RequestQuote.class.getClassLoader().getResource("").getPath());
			    	Reporter.log("<a href='"+ local+"/" + name + "'> <img src='"+ local+"/"+ name + " ' height='100' width='100'/>" + "<a href='"+ urlname+"'>'"+ urlname+"'</a> " + " </a>");
			    	
					Thread.sleep(1000);
					
		}

  }

  @AfterMethod
  public void afterMethod() throws Exception {
	    //File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //FileUtils.copyFile(scrFile1, new File(name));
	    //System.out.println("Inside Name function?");
	    //System.out.println(name);
	    //System.out.println("My Lolal is: ");
	    //System.out.println(new java.io.File("").getAbsolutePath());
    	//System.out.println(RequestQuote.class.getClassLoader().getResource("").getPath());
    	//Reporter.log("<a href='"+ local+"/" + name + "'> <img src='"+ local+"/"+ name + " ' height='100' width='100'/>" + "" + " </a>");
	    
	 
  }


  //@DataProvider
  //public Object[][] dp() {
   // return new Object[][] {
    //  new Object[] { 1, "a" },
     // new Object[] { 2, "b" },
     

    //};
//  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
		//((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
		driver.manage().window().maximize();
		try {
			afterMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("I'm after class is there an image?");
	  try {
		afterMethod();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  }

  @BeforeTest
  public void beforeTest() {
	    }

  @AfterTest
  public void afterTest() {
	  

  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
  }

}
