package com.mystore.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static Properties prop;
	public static WebDriver driver;
	@BeforeTest
	public void loadconfig() 
	{
		try
		{
			prop=new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/Configuration/Config.properties");
			prop.load(ip);
			System.out.println("driver :"+ driver);
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
		
		public void launchBrowser() 
		{
			WebDriverManager.chromiumdriver().setup();
			String browsername=prop.getProperty("browser");
			
			if(browsername.contains("Chrome")) 
			{
				driver=new ChromeDriver();
			}
			else if(browsername.contains("Firefox")) 
			{
				driver=new FirefoxDriver();
			}
			else if(browsername.contains("Firefox")) 
			{
				driver=new InternetExplorerDriver();
			}
		}
}
